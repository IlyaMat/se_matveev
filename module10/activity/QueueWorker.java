package sef.module10.activity;

public class QueueWorker implements Runnable {

	private String task;
	private String name;
	private int length;
	private TaskQueue queue;

	public QueueWorker(String name, TaskQueue queue) {
		this.name = name;
		this.queue = queue;
	}

	public void run() {
		while (true) {
			synchronized (this.queue) {
				if (this.queue.isEmpty()) {
					try {
						System.out.println(name + " waiting for task");
						queue.wait(); //приостановка выполнения, и освобождается монитор объекта queue
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
		//когда вызовется м-д notifyAll() в классе QueueSample, то начнет выполняться эта часть кода
			this.task = queue.getNextTask();
			this.length = task.length();


			doTask();
			
		}
	}
	
	private void doTask(){
		System.out.println(name + " GIVEN : " + task);
		for (int i = 0; i < length; i++) {
			System.out.println(name + " DOING " + task + " at cycle " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
