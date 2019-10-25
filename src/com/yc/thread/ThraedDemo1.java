package com.yc.thread;

/**
 * 线程分类运行特性
 * 1.父线程：主线程会等所有的子线程执行完毕后再终止执行，但是守护的子线程例外
 * 2.子线程
 * 3.守护线程
 * @author 笑溅了
 *
 */
public class ThraedDemo1 {
	public  static void main(String []args) throws InterruptedException{
		//匿名类线程
		Thread t1=new Thread("多线程"){

			@Override
			public void run() {
				for(int i=0;i<100;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
			}
			
			
		};
			
		t1.setDaemon(true);//设置守护线程
		t1.start();
		
		Thread.sleep(1);
		System.out.println("代码执行完毕");
		
	}
}
