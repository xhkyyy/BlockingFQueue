package test;

import cn.queue.BlockingQueueWithFQueue;

public class TakeThread implements Runnable{

	private BlockingQueueWithFQueue<String> queue;
	public TakeThread(BlockingQueueWithFQueue<String> queue){
		this.queue = queue;
	}
	
	public void run() {
		int size = 0;
		while(true){
			try {
				//queue.take();
				System.out.println("get(" + (++size) + ")：" + queue.take() + "\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
