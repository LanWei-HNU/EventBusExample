package com.lw.main;

import com.google.common.eventbus.EventBus;
import com.lw.thread.AThread;
import com.lw.thread.BThread;
import com.lw.util.EventBusUtil;

public class TestMain {

	public static void main(String[] args) {
		
		EventBus bus = EventBusUtil.getEventBus();
		
		AThread a = new AThread("A");
		AThread b = new AThread("B");
		AThread c = new AThread("C");
		AThread d = new AThread("D");
		AThread e = new AThread("E");
		BThread t1 = new BThread();
		
		/*********************事件通知start***************************/
		bus.post(a);
		bus.post(b);
		bus.post("do what");
		bus.post(c);
		bus.post(d);
		bus.post(e);
		bus.post(t1);
		
		// deadEven测试
		bus.post(new Integer(111));
		bus.post(new TestMain());
		/*********************事件通知end***************************/
		
		
	}

}
