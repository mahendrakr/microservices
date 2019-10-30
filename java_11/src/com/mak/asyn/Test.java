package com.mak.asyn;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test {

	public static void main(String[] args) {
		
		Shop shop = new Shop("BestShop");
		long start = System.nanoTime();
		Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Invocation returned after " + invocationTime+ " msecs");
		// Do some more tasks, like querying other shops
		shop.doSomethingElse();
		// while the price of the product is being calculated
		try {
		double price = futurePrice.get();
		System.out.printf("Price is %.2f%n", price);
		} catch (Exception e) {
		throw new RuntimeException(e);
		}
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Price returned after " + retrievalTime + " msecs");
		
		System.out.println("**********************************");
		long start1 = System.nanoTime();
		System.out.println(Shop.findPrices1("myPhone27S"));
		long duration = (System.nanoTime() - start1) / 1_000_000;
		System.out.println("Done in " + duration + " msecs");		
//		[BestPrice price is 212.07, LetsSaveBig price is 121.70, MyFavoriteShop price is 218.06, BuyItAll price is 150.38]
//				Done in 3 msecs
		System.out.println("*********************************");
		Future<List<String>> priceAsync1 = shop.getPriceAsync1("my favorite product");
		try {
			System.out.println(priceAsync1.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
