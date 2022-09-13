package io.mart.concurrency.lock_api;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReentrantReadWriteLockExample {
	
	private static Map<String, String> syncHashMap = new HashMap<>();
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	
	// Write operation => using write lock
	public void put(String key, String value) throws InterruptedException {
		try {
			writeLock.lock();
			System.out.println(Thread.currentThread().getName() + " writing");
			syncHashMap.put(key, value);
			Thread.sleep(1000);
		} finally {
			writeLock.unlock();
		}
		
	}
	
	// Read operation => using read lock
	public String get(String key) {
		try {
			readLock.lock();
			System.out.println(Thread.currentThread().getName() + " reading");
			return syncHashMap.get(key);
		} finally {
			readLock.unlock();
		}
	}
	
	// Write operation => using write lock
	public String remove(String key) {
		try {
			writeLock.lock();
			return syncHashMap.remove(key);
		} finally {
			writeLock.unlock();
		}
	}
	
	// Read operation => using read lock
	public boolean containsKey(String key) {
		try {
			readLock.lock();
			return syncHashMap.containsKey(key);
		} finally {
			readLock.unlock();
		}
	}
	
	boolean isReadLockAvailable() {
		return readLock.tryLock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final int threadCount = 3;
		final ExecutorService service = Executors.newFixedThreadPool(threadCount);
		ReentrantReadWriteLockExample object = new ReentrantReadWriteLockExample();
		
		service.execute(new Thread(new Writer(object), "Writer"));
		service.execute(new Thread(new Reader(object), "Reader1"));
		service.execute(new Thread(new Reader(object), "Reader2"));
		
		service.shutdown();
	}
	
	private static class Reader implements Runnable {
		
		ReentrantReadWriteLockExample object;
		
		Reader(ReentrantReadWriteLockExample object) {
			this.object = object;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				object.get("key" + i);
			}
		}
	}
	
	private static class Writer implements Runnable {
		
		ReentrantReadWriteLockExample object;
		
		public Writer(ReentrantReadWriteLockExample object) {
			this.object = object;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					object.put("key" + i, "value" + i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}