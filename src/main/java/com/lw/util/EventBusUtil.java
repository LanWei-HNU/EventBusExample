package com.lw.util;

import com.google.common.eventbus.EventBus;
import com.lw.event.MyEvent;

/**
 * ��EventBus��װ�ɵ�������������¼�ע��
 * @author LanWei-HNU
 *
 */
public class EventBusUtil {
	
	private static EventBus bus = new EventBus();
	
	static {
		System.out.println("��ʼ��>>>>>>>>>>>>>>>>>");
		initBus();
	}
	
	private static void initBus() {
		//ע���¼��ڴ����
		bus.register(new MyEvent("even1"));
	}
	
	public static EventBus getEventBus(){
		return bus;
	}
}
