package main.java.Test;

public class Reentrant implements Runnable {
	Widget widget;

	public Reentrant(Widget widget) {
		this.widget = widget;
	}

	public synchronized void get() {
		widget.doSomething();
	}

	@Override
	public void run() {
		get();
	}

	public static void main(String[] args) {
		Widget widget = new Widget();

		Reentrant reentrant = new Reentrant(widget);
		new Thread(reentrant).start();
	}
}
