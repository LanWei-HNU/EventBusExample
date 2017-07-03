package com.lw.event;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;
import com.lw.thread.AThread;
import com.lw.thread.BThread;

/**
 * �����ҵ��¼�
 * 1.��Ŀ��ֻ��Ҫ�ڴ������ʹ��@Subscribeע��ķ�������¼�����;
 * 2.����ÿ���¼���װһ���ض����¼������Ǳ�Ҫ��;
 * 3.EventBus�е��¼��������������͵ģ��¼��ַ���ʱ��ֻ��Ҫ���ݶ��Ĳ����������ַ���Ϣ��
 * 		��������¼������ϴ������ͼ̳еĹ�ϵ����ǰ���¼���ַ��������ͬ�Ķ������ϣ�
 * 		��һ������ʹ�õ�ʱ�����Ҫ��ϸ�����ڲ���Ҫ�ظ��������Ϣ�Ͼ�Ҫ����ϸ�ڴ�����;
 * 4.�����첽����(���Ͷ��ŵ��첽����)��
 * @author LanWei-HNU
 * 2017��6��30��17:35:51
 */
public class MyEvent {
	
	private String name;
	
	public MyEvent(String name) {
		super();
		this.name = name;
	}

	@Subscribe
	public void sub1(String msg){
		System.out.println(name+" : "+msg);
	}
	
	@Subscribe
	public void sub2(AThread task){
		Thread a = new Thread(task);
		a.start();
	}
	
	@Subscribe
	public void sub3(BThread task){
		Thread a = new Thread(task);
		a.start();
	}
	
	/**
	 * ��EventBus������һ���¼�������ע��Ķ�������û���ҵ�������¼��ķ�����
	 * ��ôEventBus�ͻ�Ѹ��¼���װ��һ��DeadEvent�¼������·�����
	 * @param de
	 */
	 @Subscribe
	 public void onDeadEvent(DeadEvent de) {
	     System.out.println("�����˴�����¼�:" + de.getEvent());
	 }
}

