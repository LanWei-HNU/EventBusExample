package com.lw.util;

import com.google.common.eventbus.EventBus;
import com.lw.event.MyEvent;

/**
 * 将EventBus封装成单例，并且完成事件注册
 * @author LanWei-HNU
 *
 */
public class EventBusUtil {
	
	private static EventBus bus = new EventBus();
	
	static {
		System.out.println("初始化>>>>>>>>>>>>>>>>>");
		initBus();
	}
	
	private static void initBus() {
		//注册事件在此完成
		bus.register(new MyEvent("even1"));
	}
	
	public static EventBus getEventBus(){
		return bus;
	}
}
