package com.mak.asyn;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static java.util.stream.Collectors.toList;

public class Shop {
	private String product;
	private String name;
	private double price;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Shop(String product) {
		this.product = product;
		this.name=product;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
		
	}

	public void doSomethingElse() {
	}

	public static List<String> findPrices(String product) {
		return getShops().parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
				.collect(toList());
	}

	private static List<Shop> getShops() {
		List<Shop> shops = List.of(new Shop("BestPrice"), new Shop("LetsSaveBig"), new Shop("MyFavoriteShop"),
				new Shop("BuyItAll"));
		return shops;
	}
	
	
	public static List<String> findPrices1(String product) {
		List<CompletableFuture<String>> priceFutures =
				getShops().stream()
				.map(shop -> CompletableFuture.supplyAsync(
				() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))))
				.collect(toList());
				return priceFutures.stream()
				.map(CompletableFuture::join)
				.collect(toList());
	}
	
	public static List<String> findPrices2(String product) {
	return	getShops().parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
		.collect(toList());
	}
			
	private Executor getCustomExecutor() {
		return	Executors.newFixedThreadPool(Math.min(getShops().size(), 100),
			(Runnable r) -> {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
			}
			);
	}

	public double getPrice(String product) {
		Random random = new Random();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public Future<Double> getPriceAsync(String product) {
		
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}
	
public Future<List<String>> getPriceAsync1(String product) {
	
	
//	Shop shop = new Shop("BestShop");
//	return CompletableFuture.supplyAsync(() -> shop.getName() + " price is " +
//			shop.getPrice(product), getCustomExecutor());
	return CompletableFuture.supplyAsync(() -> getShops().stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(toList()), getCustomExecutor());
	}

	
//	  public Future<Double> getPriceAsync1(String product) {
//	  CompletableFuture<Double> futurePrice = new CompletableFuture<>(); new
//	  Thread( () -> { try { double price = calculatePrice(product);
//	  futurePrice.complete(price); }catch(Exception e) {
//	  futurePrice.completeExceptionally(e); } }).start(); return futurePrice; }
	 

	public static void delay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private double calculatePrice(String product) {
		delay();
		Random random = new Random();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}
}
