package io.mart.concurrency.lock_api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SharedObjectWithLock {
	
	private ReentrantLock lock = new ReentrantLock(true);
	private int counter = 0;
	
	void perform() {
		lock.lock();
		System.out.println("Thread - " + Thread.currentThread().getName() + " acquired the lock");
		try {
			System.out.println("Thread - " + Thread.currentThread().getName() + " processing");
			Thread.sleep(1000);
			
			counter++;
		} catch (Exception exception) {
			System.out.println(" Interrupted Exception " + exception);
		} finally {
			System.out.println("Thread - " + Thread.currentThread().getName() + " will release the lock now");
			lock.unlock();
		}
	}
	
	private void performTryLock() {
		System.out.println("Thread - " + Thread.currentThread().getName() + " attempting to acquire the lock");
		try {
			boolean isLockAcquired = lock.tryLock(6, TimeUnit.SECONDS);
			if (isLockAcquired) {
				try {
					System.out.println("Thread - " + Thread.currentThread().getName() + " acquired the lock");
					System.out.println("Thread - " + Thread.currentThread().getName() + " processing");
					Thread.sleep(1000);
				} finally {
					System.out.println("Thread - " + Thread.currentThread().getName() + " will release the lock now");
					lock.unlock();
				}
			} else {
				System.out.println("Thread - " + Thread.currentThread().getName() + " could not acquire the lock");
			}
		} catch (InterruptedException exception) {
			System.out.println(" Interrupted Exception " + exception);
		}
	}
	
	public ReentrantLock getLock() {
		return lock;
	}
	
	boolean isLocked() {
		return lock.isLocked();
	}
	
	boolean hasQueuedThreads() {
		return lock.hasQueuedThreads();
	}
	
	int getCounter() {
		return counter;
	}
	
	public static void main(String[] args) {
		
		final int threadCount = 5;
		final ExecutorService service = Executors.newFixedThreadPool(threadCount);
		final SharedObjectWithLock object = new SharedObjectWithLock();
		
		for (int i = 0; i < 5; i++) {
//			service.execute(object::perform);
			service.execute(object::performTryLock);
		}
		service.shutdown();
		
	}
	
}