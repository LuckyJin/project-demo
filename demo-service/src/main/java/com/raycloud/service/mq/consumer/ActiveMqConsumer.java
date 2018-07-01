package com.raycloud.service.mq.consumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class ActiveMqConsumer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    AtomicInteger cnt = new AtomicInteger(0);

    ConnectionFactory connectionFactory;

    Connection connection;

    Session session;

    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<>();

    public void init() {
        try {
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEN_URL);
            connection = connectionFactory.createConnection();

            connection.start();
            session = connection.createSession(true, Session.SESSION_TRANSACTED);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String disName) {
        try {
            Queue queue = session.createQueue(disName);
            MessageConsumer messageConsumer;

            if ((messageConsumer = threadLocal.get()) == null) {
                messageConsumer = session.createConsumer(queue);
            }

            while (true) {
                TextMessage message = (TextMessage) messageConsumer.receive();
                if (message != null) {
                    message.acknowledge();
                    System.out.println(Thread.currentThread().getName() +
                            " here is consumer , cnt" + cnt.getAndIncrement());
                } else {
                    break;
                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
