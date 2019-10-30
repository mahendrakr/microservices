package com.mak.asyn;

public class Main {
public static void main(String[] args) {
	final long MICRO_PER_DAY=24*60*60*1000*1000;
	final long MILLIS_PER_DAY=24*60*60*1000;
	System.out.println(MICRO_PER_DAY/MILLIS_PER_DAY);
	System.out.println(MICRO_PER_DAY);
	//System.err.println(Integer.toBinaryString(86400000000));
	System.out.println(500654080/MILLIS_PER_DAY);
	System.out.println("1010000011101110101110110000000000000".length());
}
}
