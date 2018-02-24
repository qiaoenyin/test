package main.java.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.management.monitor.StringMonitorMBean;

public class TestTreeSet {
    public static void main(String[] args) {
        Set<Integer> tsInt = new TreeSet<Integer>();
       // _initSet(tsInt);
       // _setRandom(tsInt);
       //listToSet(tsInt);
       /*Iterator<Integer> ints = tsInt.iterator();
       while(ints.hasNext()){
        	System.out.print(ints.next() + " ");
       }*/
       //_toTreeSet();
       //getRepetition();
    }

	public static void _initSet(Set<Integer> tsInt){
    	String Astr = "11 12 32 32 32 34 34 54 98 78 43 39 87 93 48 75 345 79 08 390 28 34 73 24 82 74 723";
        String[] arrStrings=Astr.split(" ");
        List<Integer> LString = new ArrayList<Integer>();
        for(String str:arrStrings){
        	LString.add(Integer.parseInt(str));
        }
        tsInt.addAll(LString);
        tsInt.add(101);
        tsInt.add(1);
        tsInt.add(3);
        tsInt.add(2);
        tsInt.add(10);
        tsInt.add(5);
        tsInt.add(4);
        tsInt.add(7);
        tsInt.add(7);
        tsInt.add(7);
        tsInt.add(7);
        tsInt.add(7);
    }
	
	private static void _setRandom(Set<Integer> tsInt) {
		 Random random = new Random();
		 for(int i=0;i<100;i++){
			 tsInt.add(random.nextInt(20));
		 }
	}
	
	private static void _setRandomToList(List<Integer> list) {
		 Random random = new Random();
		 for(int i=0;i<100;i++){
			 list.add(random.nextInt(20));
		 }
	}
	
	private static void listToSet(Set<Integer> tsInt){
		List<Integer> list=new ArrayList<Integer>();
		_setRandomToList(list);
		System.out.println("list:"+list);
		tsInt.addAll(list);
		System.out.println("tsInt:"+tsInt);
	}
	
	public static void _toTreeSet(){
		Set<String> treeSet = new TreeSet<String>();
		treeSet.add("1");
		treeSet.add("c");
		treeSet.add("a");
		treeSet.add("b");
		treeSet.add("d");
		treeSet.add("4");
		treeSet.add("A");
		treeSet.add("B");
		treeSet.add("B");
		treeSet.add("B");
		treeSet.add("B");
		treeSet.add("B");
		treeSet.add("Bc");
		System.out.println(treeSet.size());
		Iterator<String> its = treeSet.iterator();
		while(its.hasNext()){
			System.out.print(its.next()+" ");
		}
	}
	
	public static void getRepetition(){
		List<Integer> list =new ArrayList<Integer>();
		Random random = new Random();
		 for(int i=0;i<20;i++){
			 list.add(random.nextInt(20));
		 }
		 List<Integer> list2= new ArrayList<Integer>();
		 for(Integer a:list){
			 if(list2.contains(a)){
				 System.out.print(a+" ");
			 }else{
				 list2.add(a);
			 }
		 }
	}
}
