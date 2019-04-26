package sef.module10.activity;

public class QueueSample {

	public static void main(String arg[]) {

		TaskQueue queue = new TaskQueue();
		QueueWorker w1 = new QueueWorker("Curly", queue);
		QueueWorker w2 = new QueueWorker("Larry", queue);
		QueueWorker w3 = new QueueWorker("Moe", queue);

		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w2);
		Thread t3 = new Thread(w3);

		t1.start();
		t2.start();
		t3.start();

		System.out.println("Queue starting in 5 seconds!");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Queuing now!");

		//добавляем задания в очередь
		queue.addTask("Task 1");
		queue.addTask("Task 2");
		queue.addTask("Task 3");
		queue.addTask("Task 4");

		//а теперь оповещаем все потоки, что они могут продолжить выполнение
		synchronized (queue) {
			queue.notifyAll(); //All threads -> Runnable. Execute only in monitor.
		}

	}
}
