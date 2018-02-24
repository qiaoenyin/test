package main.java.Test;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
	private AtomicReference<Thread> owner =new AtomicReference<>();
	public void lock(){
		Thread current = Thread.currentThread();
		while(!owner.compareAndSet(null, current)){
		}
	}
	public void unlock (){
		Thread current = Thread.currentThread();
		owner.compareAndSet(current, null);
	}
}