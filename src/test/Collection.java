package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Collection {
	
	public static void main(String args[]){
		List<String> alist = new ArrayList<String>();
		alist.add("1");
		alist.add("2");
		Iterator<String> iterator = alist.iterator();
		while (iterator.hasNext()) {
		String item = iterator.next();
			if ("2".equals(item)) {
				iterator.remove();
			}
		}
		System.out.println(alist.toString());
	}
	
}
