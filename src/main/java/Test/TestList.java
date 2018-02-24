package main.java.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {
	
	 
	public static void removeList(List<Integer> list){
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
		Integer item = iterator.next();
			if (item > 0) {
				iterator.remove();
			}
		}
	};
	
	static List<Integer> initList(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<10;i++){
			list.add(i);
		}
		return list;
	}
	
	public static void main(String[] args){
		List<Integer> list = initList();
		//removeList(list);
		clearList();
	}
	
	static void clearList(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		for (String item : list) {
			if ("1".equals(item)) {
				list.remove(item);
			}
		}
		System.out.println("======================"+list);
	}
}	
