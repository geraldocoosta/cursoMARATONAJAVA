package br.com.ultcode.concorrencia.test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite {
	private Map<String, String> map = new LinkedHashMap<>();

	public void put(String key, String value) {
		map.put(key, value);
	}

	public Object[] allKeys() {
		return map.keySet().toArray();
	}
}

public class MapReadWriteLockTest {
	private static final MapReadWrite MAP_READ_WRITE = new MapReadWrite();
	private static final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();

	public static void main(String[] args) {
		Thread threadWriter = new Thread(new Write(), "Writer");
		Thread threadReaderA = new Thread(new ReadA(), "ReaderA");
		Thread threadReaderB = new Thread(new ReadB(), "ReaderB");

		threadWriter.start();
		threadReaderA.start();
		threadReaderB.start();
	}

	static class Write implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				LOCK.writeLock().lock();
				;
				try {
					Thread.sleep(150);
					MAP_READ_WRITE.put(String.valueOf(i), String.valueOf(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					LOCK.writeLock().unlock();
				}
			}
		}

	}

	static class ReadA implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				LOCK.readLock().lock();
				try {
					System.out.println(Thread.currentThread().getName() + "\n"+Arrays.toString(MAP_READ_WRITE.allKeys()));
				} finally {
					LOCK.readLock().unlock();
				}
			}
		}
	}

	static class ReadB implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				LOCK.readLock().lock();
				try {
					System.out.println(Thread.currentThread().getName());
					System.out.println(Arrays.toString(MAP_READ_WRITE.allKeys()));
				} finally {
					LOCK.readLock().unlock();
				}
			}
		}
	}
}
