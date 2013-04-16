package test;

import cn.queue.BlockingQueueWithFQueue;
public class PutThread implements Runnable{

	private BlockingQueueWithFQueue<String> queue;
	public PutThread(BlockingQueueWithFQueue<String> queue){
		this.queue = queue;
	}
	
	public void run() {
		int len = 10000000;
		String tmp = null;
		Time t = new Time();
		t.start();
		
		while(len > 0){
			try {
				
				//Thread.sleep(10000);
				tmp = "你好吗？abc" + len;
				queue.put(tmp);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			len --;
		}
	
		t.end();
	}


}
