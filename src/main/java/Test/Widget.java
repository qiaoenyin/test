package main.java.Test;

public class Widget {
	public synchronized void doSomething(){
		System.out.println(Thread.currentThread().getId() +"=========="+ System.currentTimeMillis() + "进入");
		this.doSomething();
		System.out.println(Thread.currentThread().getId() +"======"+ System.currentTimeMillis() + "离去");
	}
}
