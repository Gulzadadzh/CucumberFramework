package com.hrms.testbase;

public class TestCase {
public static void main(String[] args) {
	String str = "This is test";
	String[] array = str.split(" ");
	for(int i = array.length -1; i >= 0; i--) {
		System.out.print(array[i] + " ");
	}
	
}
}