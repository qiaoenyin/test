package main.java.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class treeMap {
	public static void main(String args[]){
		Map<String, Integer>map =  new HashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("V", 3);
		map.put("R", 4);
		map.put("J", 5);
		map.put("G", 5);
		map.put("Q", 6);
		map.put("L", 1);
		map.put("S", 2);
		map.put("D", 3);
		map.put("F", 4);
		map.put("C", 5);
		map.put("X", 5);
		map.put("Z", 6);
		map.put("M", 1);
		map.put("L", 2);
		map.put("N", 3);
		map.put("B", 4);
		map.put("O", 5);
		map.put("T", 5);
		map.put("Y", 6);
		TreeMap<String, Integer> treemap = new TreeMap<String, Integer>(map);
		for (Map.Entry<String, Integer> entry : treemap.entrySet()) {  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		}  
		
		/*for (String key : treemap.keySet()) {  
		    System.out.println("Key = " + key);  
		} 
		
		for(Integer value:treemap.values()){
			System.out.println("value = " + value);
		}
		
		Iterator<Map.Entry<String, Integer>> entries = treemap.entrySet().iterator();  
		while (entries.hasNext()) {  
		    Map.Entry<String, Integer> entry = entries.next();  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		} */ 
	}
}
