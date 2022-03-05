package io.mart.concurrency.intrinsicLock;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Lock in on object, not on the method. If the thread aquired the lock on the objects,
 * other threads are not able to call other synchronized methods.
 * It is possible to call non-synchronized methods
 */
public class MultipleSyncMethodsDemo {
	
	public static void main (String[] args) throws InterruptedException {
		MultipleSyncMethodsDemo demo = new MultipleSyncMethodsDemo();
		Thread thread1 = new Thread(() -> {
			System.out.println("thread1 before call "+ LocalDateTime.now());
			demo.syncMethod1("from thread1");
			System.out.println("thread1 after call "+LocalDateTime.now());
		});
		Thread thread2 = new Thread(() -> {
			System.out.println("thread2 before call "+LocalDateTime.now());
			demo.syncMethod2("from thread2");
			System.out.println("thread2 after call "+LocalDateTime.now());
		});
		
		thread1.start();
		thread2.start();
	}
	
	private synchronized void syncMethod1 (String msg) {
		System.out.println("in the syncMethod1 "+msg+" "+LocalDateTime.now());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private synchronized void syncMethod2 (String msg) {
		System.out.println("in the syncMethod2 "+msg+" "+LocalDateTime.now());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}