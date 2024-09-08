package week4;

/*
Write a class which implements Runnable interface.
Implement public void run() method in class created above.
Write business logic which need to be executed in new thread, in run() method of step2.
In main method Create an object of Class of Step1

 */

class ChildThread implements Runnable{
@Override	
public void run(){
	
	for(int i=0;i<200;i+=3){
		try{
		System.out.println("Child Thread:");
		Thread.sleep(20);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
}

public class RunnableEg {
public static void main(String[] args) throws Exception{
	
	Thread t = new Thread(new ChildThread());
	t.start();
	
	for(int j=0;j<400;j++){
		System.out.println("Main Thread:"+j);
		Thread.sleep(25);
	}
}
}
