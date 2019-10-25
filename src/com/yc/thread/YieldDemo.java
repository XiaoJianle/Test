package com.yc.thread;

public class YieldDemo {
	
	public static void main (String[]args){
		new Thread(){
			@Override
			public void run() {
				long start= System.currentTimeMillis();
					for(int i=0;i<20;i++){
						try {
							sleep(888);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Math.random();
						Thread.yield();
						System.out.println("t1:"+i);
					}
					long time =System.currentTimeMillis() -start;
					System.out.println(Thread.currentThread().getName()+":"+time);
					
				}
		}.start();
		
		
		
		
		new Thread("多线程"){
			@Override
			public void run() {
				long start= System.currentTimeMillis();
					for(int i=0;i<20;i++){
						try {
							sleep(888);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Math.random();
						
						if(i==10){
							Thread.yield();	//执行让渡
						}
						
						System.out.println("t2:"+i);
					}
					long time =System.currentTimeMillis() -start;
					System.out.println(Thread.currentThread().getName()+":"+time);
					
				}
		}.start();
	}

}

