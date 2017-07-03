package com.lw.thread;

public class BThread implements Runnable {

	@Override
	public void run() {
		System.out.println("another thread is working!");
	}

}
