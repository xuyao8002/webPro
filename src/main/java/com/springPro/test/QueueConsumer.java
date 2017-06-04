package com.springPro.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.springframework.util.SerializationUtils;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;
import com.rabbitmq.client.ShutdownSignalException;

public class QueueConsumer extends EndPoint implements Runnable, Consumer{
	
	public QueueConsumer(String endPointName) throws IOException, TimeoutException{
		super(endPointName);		
	}
	
	public void run() {
		/*try{
			while(true){
				boolean autoAck = false;
				GetResponse response = channel.basicGet(endPointName, autoAck);
				if (response == null) {
					break;
				    // No message retrieved.
				} else {
				    //AMQP.BasicProperties props = response.getProps();
				    byte[] body = response.getBody();
				    Map map = (HashMap)SerializationUtils.deserialize(body);
				    System.out.println("Message Number "+ map.get("message number") + " received.");
				    long deliveryTag = response.getEnvelope().getDeliveryTag();
				    channel.basicAck(deliveryTag, false);
				}
			}
			
		}catch	(Exception e){
			e.printStackTrace();
		}*/
		
		
		
		try {
			//start consuming messages. Auto acknowledge messages.
			channel.basicConsume(endPointName, false,this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Called when consumer is registered.
	 */
	public void handleConsumeOk(String consumerTag) {
		System.out.println("Consumer "+consumerTag +" registered");		
	}

	/**
	 * Called when new message is available.
	 */
	public void handleDelivery(String consumerTag, Envelope env,
			BasicProperties props, byte[] body) throws IOException {
		Map map = (HashMap)SerializationUtils.deserialize(body);
	    System.out.println("Message Number "+ map.get("message number") + " received.");
		
	}

	public void handleCancel(String consumerTag) {}
	public void handleCancelOk(String consumerTag) {}
	public void handleRecoverOk(String consumerTag) {}
	public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {}
}
