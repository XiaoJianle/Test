
package com.yc.thread;

public class WaitDemo {
	 public static void main(String[] args) throws InterruptedException {
		MyRunnable mr =new MyRunnable();
		for(int i=0;i<100;i++){
			new Thread(mr,"线程"+i).start();
		}
		
		Thread.sleep(1100);
		
		//同步块代码
		synchronized (mr) {
			//通知49线程继续执，注意：之前执行的是mr的wait,所以这里也是执行mr的notify
			mr.notify();
		}
		System.out.println(mr.count);
		
		
//		Thread t1=new Thread(mr,"陈平安");
//		Thread t2=new Thread(mr,"小宝瓶");
//		Thread t3=new Thread(mr,"李槐");
//		Thread t4=new Thread(mr,"林守一");
//		Thread t5=new Thread(mr,"阿良");
//		Thread t6=new Thread(mr,"崔东山");
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
//		t6.start();
		
	}
}
	
class MyRunnable implements Runnable{
	int count=100;
	@Override
	/**
	 * synchronized 表示改代码只能被同一个线程执行
	 */
	//同步方法
	public synchronized void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if("线程49".equals(Thread.currentThread().getName())){
			System.out.println("---------------线程49-------------------在此等待");

			try {
				wait();//是object的方法
				System.out.println("11");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+":"+count--);
		
	}
	
}





