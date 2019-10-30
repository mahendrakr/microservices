package com.mak.asyn;

public class BenchMark {
	public static void main(String[] args) {
		//String to Wrapper Class
		Integer wrapper= Integer.valueOf("10");
		//String to Primitive
		 int primitive = Integer.parseInt("10");
		 //Wrapper to String
		 String String1= String.valueOf(wrapper);
		 String String2 = wrapper.toString();
		 //Wrapper to primitive
		   int intValue = wrapper.intValue();
		   //primitive to Wrapper
		    Integer wrap = Integer.valueOf(10);
		    //primitive to String
		      String string3 = Integer.toString(10);
		      byte a=-4;
		     System.out.println(Integer.toBinaryString(a));
		int c=   a>>>2;
		System.out.println(Integer.toBinaryString(c));
		System.out.println(c);
	
		     
		    
	}
	
}
