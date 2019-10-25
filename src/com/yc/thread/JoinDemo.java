package com.yc.thread;

public class JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread t =	new Thread("�Ҳ���д����"){
		
			public void run() {
			
					for(int i=0;i<20;i++){
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+":"+i);
					}
				}
		};
			
	
		
		Thread t1 =	new Thread("�ҳ�������������д����"){
			public void run() {
				for(int i=0;i<20;i++){
						try {
							sleep(1000);
							if(i==10){
								t.join();
							}
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println(Thread.currentThread().getName()+":"+i);	
					};
			}
		
		};
		
		t.start();
		t1.start();
		
		
		
		
		
		
	}
		
		
}
