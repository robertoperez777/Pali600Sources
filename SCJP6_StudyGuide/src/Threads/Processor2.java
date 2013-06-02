package Threads;

import java.util.LinkedList;
import java.util.Random;

public class Processor2 {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	public void produce() throws InterruptedException {

		int value = 0;

		while (true) {
			synchronized (this.lock) {
				while (this.list.size() == this.LIMIT) {
					this.lock.wait();
				}
				this.list.add(value++);
				this.lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		Random random = new Random();
		while (true) {
			synchronized (this.lock) {
				while (this.list.size() == 0) {
					this.lock.wait();
				}
				System.out.println("List size is: " + this.list.size());
				int value = this.list.removeFirst();
				System.out.println("; value is: " + value);
				this.lock.notify();
			}

			Thread.sleep(random.nextInt(1000));
		}
	}

	public static void main(String[] args) {

	}

}
