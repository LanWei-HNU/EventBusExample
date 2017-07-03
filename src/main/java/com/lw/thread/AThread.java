package com.lw.thread;

public class AThread implements Runnable {
	
	private String name;
	
	

	public AThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name+" is working !");
	}

}
