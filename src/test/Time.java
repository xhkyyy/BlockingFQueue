package test;

public class Time {

	private long start = 0;
	
	private long end = 0;
	
	private double sum;
	
	public void start(){
		start = System.currentTimeMillis();
	}
	
	public void end(String str){
		end = System.currentTimeMillis();
		sum = end - start;
		sum /= 1000D;
		
		System.out.println(str + " 耗时: " + sum + "s");
	}
	
	public void end(){
		end = System.currentTimeMillis();
		sum = end - start;
		sum /= 1000D;
		
		System.out.println("耗时: " + sum + "s");
	}
	
	public void endMillis(){
		end = System.currentTimeMillis();
		sum = end - start;
		System.out.println("耗时: " + sum + "ms");
	}
}
