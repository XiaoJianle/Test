package com.yc.thread;
public class X2 implements Runnable {
             private int x;
             private int y;
        public static void main(String[] args){
                    X2 that=new X2();
                    (new Thread(that)).start();
                    (new Thread(that)).start();//��6��
                    //��7��
        }
        public synchronized void run() {
                   for( ; ; ){
                        x++;
                        y++;//��11�� 
                      System.out.println("x="+x+",y="+y);
                   }
         }
}