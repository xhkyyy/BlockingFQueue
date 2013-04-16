package test;

import cn.queue.BlockingQueueWithFQueue;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		BlockingQueueWithFQueue<String> l = new BlockingQueueWithFQueue<String>();

		new Thread(new TakeThread(l)).start();
		
		new Thread(new PutThread(l)).start();
		
		Thread.sleep(60000000);
		
	}

}
