package com.springPro.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RabbitMQ {
	public RabbitMQ() throws Exception {

		QueueConsumer consumer = new QueueConsumer("queue");
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		/*long b = System.currentTimeMillis();
		ExecutorService es = Executors.newFixedThreadPool(1);
		for(int i = 0; i < 1; i++){
			QueueConsumer consumer = new QueueConsumer("queue");
			Thread consumerThread = new Thread(consumer);
			es.execute(consumerThread);
		}
		es.shutdown();
		while(true){
			if(es.isTerminated()){
				long a = System.currentTimeMillis();
				System.out.println("耗时：" + (a-b));
				break;
			}
			
		}*/
		
		/*Producer producer = new Producer("queue");

		for (int i = 0; i < 100000; i++) {
			HashMap message = new HashMap();
			message.put("message number", i);
			producer.sendMessage(message);
			System.out.println("Message Number " + i + " sent.");
		}*/
		
		
	}

	/**
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		new RabbitMQ();
	}
}
