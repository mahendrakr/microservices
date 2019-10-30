package com.mak.asyn;

import java.util.Arrays;

public enum Weekday {
MON("Monday"),TUE("Tuesday"),WED("Wednesday"),THU("Thursday"),FRI("Friday"),SAT("Saturday"),SUN("Sunday");
private String day;
 Weekday(String day){
	this.day=day;
	System.out.println("bye");
}
 Weekday(){
	 System.out.println("Hello");
 }
public String getDay() {
	return day;
}
//public abstract void m1();
public static void main(String[] args) {
//	Arrays.stream(Weekday.values()).forEach(System.out::println);
//	Weekday d = new Weekday("");
}
}
