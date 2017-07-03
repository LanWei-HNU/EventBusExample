package com.lw.event;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;
import com.lw.thread.AThread;
import com.lw.thread.BThread;

/**
 * 定义我的事件
 * 1.项目中只需要在此类添加使用@Subscribe注解的方法完成事件订阅;
 * 2.对于每类事件封装一个特定的事件类型是必要的;
 * 3.EventBus中的事件可以是任意类型的，事件分发的时候只需要根据订阅参数类型来分发消息，
 * 		多个订阅事件类型上存在类型继承的关系，则当前的事件会分发到多个不同的订阅者上，
 * 		这一点大家在使用的时候可能要仔细处理，在不需要重复处理的消息上就要做好细节处理了;
 * 4.解耦异步代码(发送短信等异步任务)。
 * @author LanWei-HNU
 * 2017年6月30日17:35:51
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
	 * 当EventBus发布了一个事件，但是注册的订阅者中没有找到处理该事件的方法，
	 * 那么EventBus就会把该事件包装成一个DeadEvent事件来重新发布；
	 * @param de
	 */
	 @Subscribe
	 public void onDeadEvent(DeadEvent de) {
	     System.out.println("发布了错误的事件:" + de.getEvent());
	 }
}

