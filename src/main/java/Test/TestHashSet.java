package main.java.Test;

import java.util.HashSet;

public class TestHashSet {
	
	public static void main(String args[]){
		HashSet<String> h = new HashSet<String>();
		h.add("3");
		h.add("1");
		h.add("2");
		h.add("12");
		h.add("11");
		System.out.println(h);
	}
}
