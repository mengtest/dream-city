package com.dream.city.job.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	
	private static final ExecutorService threadPool = Executors.newCachedThreadPool();
	
	public static void execute(Runnable command){
		threadPool.execute(command);
	}
	
}
