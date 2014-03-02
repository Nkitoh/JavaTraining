package thread;

/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 */

/**
 * Simple Thread Pool class.
 * 
 * This class can be used to dispatch an Runnable object to be exectued by a
 * thread.
 * 
 * [Instruction] Implement one constructor and three methods. Don't forget to
 * write a Test program to test this class. Pay attention to @throws tags in the
 * javadoc. If needed, you can put "synchronized" keyword to methods. All
 * classes for implementation must be private inside this class. Don't use
 * java.util.concurrent package.
 */
public class ThreadPool {

	private ThreadPool myThread = this;
	private boolean threadStart = false;
	private boolean threadStop = false;
	private ThreadForTP[] nThread;
	private SingleLinkQueue<Runnable> workQueue;
	private int queueSize;

	final private class ThreadForTP extends Thread {
		private boolean halt_;

		public ThreadForTP() {
			halt_ = false;
		}

		public void run() {
			Runnable r;
			System.out.println("before run");
			while (!halt_) {
				synchronized (myThread) {
					System.out.println("norify");
					System.out.println(Thread.currentThread());
					System.out.println(workQueue.size());
					while (workQueue.size() == 0 && halt_ == false) {
						try {
							myThread.wait();
						} catch (InterruptedException ignored) {
						}

					}
							r = workQueue.remove();
							if (r != null)
								myThread.notifyAll();
				}
				if (r != null) {
					try {
						r.run();
					} catch (RuntimeException e) {

					}
				}
			}
		}

		public void halt() {
			while (this.isAlive()) {
				halt_ = true;
				synchronized (myThread) {
					myThread.notifyAll();
				}
			}
			try {
				join();
			} catch (InterruptedException e) {
				e.getMessage();
			}

		}

	}

	/**
	 * Constructs ThreadPool.
	 * 
	 * @param queueSize
	 *            the max size of queue
	 * @param numberOfThreads
	 *            the number of threads in this pool.
	 * 
	 * @throws IllegalArgumentException
	 *             if either queueSize or numberOfThreads is less than 1
	 */
	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1 || numberOfThreads < 1)
			throw new IllegalArgumentException(
					"queueSize or numberOfThread is small");

		nThread = new ThreadForTP[numberOfThreads];
		workQueue = new SingleLinkQueue<Runnable>();
		this.queueSize = queueSize;
	}

	/**
	 * Starts threads.
	 * 
	 * @throws IllegalStateException
	 *             if threads has been already started.
	 */
	public void start() {
		if (threadStart == false)
			threadStart = true;
		else
			throw new IllegalStateException("thread is already started");
		
		System.out.println(ThreadPool.this);
		System.out.println(this);

		for (int i = 0; i < nThread.length; i++) {
			nThread[i] = new ThreadForTP();
			System.out.println("start");
			nThread[i].start();
		}

	}

	/**
	 * Stop all threads and wait for their terminations.
	 * 
	 * @throws IllegalStateException
	 *             if threads has not been started.
	 */
	public void stop() {
		if (threadStart == true && threadStop == false) {
			threadStart = false;
			threadStop = true;
		} else
			throw new IllegalStateException("thread is not started");
		for (int i = 0; i < nThread.length; i++) {
			nThread[i].halt();
		}
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool. run()
	 * method will be invoked in the thread. If the queue is full, then this
	 * method invocation will be blocked until the queue is not full.
	 * 
	 * @param runnable
	 *            Runnable object whose run() method will be invoked.
	 * 
	 * @throws NullPointerException
	 *             if runnable is null.
	 * @throws IllegalStateException
	 *             if this pool has not been started yet.
	 */
	public synchronized void dispatch(Runnable runnable) {
		if (runnable == null)
			throw new NullPointerException("runnable is null");
		if (threadStart != true)
			throw new IllegalStateException("thread is not started");

		while (workQueue.size() >= queueSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
		System.out.println("dispatch");
		workQueue.add(runnable);
		myThread.notifyAll();

	}
}
