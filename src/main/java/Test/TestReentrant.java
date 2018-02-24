package main.java.Test;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrant implements Runnable{
	ReentrantLock lock = new ReentrantLock();

	public void get() {
		lock.lock();
		System.out.println("====get====="+Thread.currentThread().getId());
		set();
		lock.unlock();
	}

	public void set() {
		lock.lock();
		System.out.println("=====set====="+Thread.currentThread().getId());
		lock.unlock();
	}
	
	@Override
	public void run() {
		get();
	}

	public static void main(String[] args) {
		TestSynchronized ss = new TestSynchronized();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
	}
}
