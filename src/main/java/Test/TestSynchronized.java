package main.java.Test;

public class TestSynchronized implements Runnable{

	public synchronized void get(){
		System.out.println("======get===="+Thread.currentThread().getId());
		set();
	}

	public synchronized void set(){
		System.out.println("====set====="+Thread.currentThread().getId());
	}

	@Override
	public void run() {
		get();
	}
	public static void main(String[] args) {
		TestSynchronized ss=new TestSynchronized();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
	}
}
