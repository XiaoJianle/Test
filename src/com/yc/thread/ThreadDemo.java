package com.yc.thread;

import java.util.MissingFormatArgumentException;

public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread mainThread =Thread.currentThread();
		System.out.println("线程ID"+mainThread.getId());
		
		System.out.print("线程名称"+mainThread.getName());
		
		System.out.println("线程优先级（10最高，1最低，5默认）："+mainThread.getPriority());
		
		Thread.sleep(2000);//休眠 单位：毫米
		
		System.out.println("线程是否处于守护线程状态："+mainThread.isDaemon());
		
		System.out.println("线程是否处于活动状态："+mainThread.isAlive());
		
		System.out.println("线程是否处于中断状态："+mainThread.isInterrupted());
		
		
		/**\
		 * 创建线程
		 * 方法一：继承Thread类
		 * 方法二：实现Runnable接口
		 */
		
	
		MyThread1 mt1 = new MyThread1();
	
		//在启动线程之前设置好优先级
		mt1.setPriority(1);
		
		//必须运行start方法
		mt1.start();//第一个线程
		
		
		MyThread2 mt2 = new MyThread2();
		
		Thread t=new Thread(mt2,"多线程");
		
		t.start();//第二个线程
		
		
		
		
		
				
	}
	
	
	
	
	


	
}



class MyThread1 extends Thread{
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}



class MyThread2 extends Thread{

	@Override
	public void run() {
		for(int i = 0 ;i<100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	
}