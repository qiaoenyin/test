package main.java.Test;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock1 {
	private AtomicReference<Thread> owner =new AtomicReference<>();
	private int count =0;
	public void lock(){
		Thread current = Thread.currentThread();
		if(current==owner.get()) {
			count++;
			return ;
		}
		while(!owner.compareAndSet(null, current)){}
	}
	
	
	public void unlock (){
		Thread current = Thread.currentThread();
		if(current==owner.get()){
			if(count!=0){
				count--;
			}else{
				owner.compareAndSet(current, null);
			}
		}
	}
}
