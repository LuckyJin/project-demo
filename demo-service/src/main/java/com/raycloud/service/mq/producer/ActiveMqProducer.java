package com.raycloud.service.mq.producer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class ActiveMqProducer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    AtomicInteger cnt = new AtomicInteger(0);

    ConnectionFactory connectionFactory;

    Connection connection;

    Session session;

    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<>();

    public void init(){
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
            MessageProducer messageProducer;

            if ((messageProducer = threadLocal.get()) == null) {
                messageProducer = session.createProducer(queue);
            }

            while (true) {
                int num = cnt.getAndIncrement();
                TextMessage message = session.createTextMessage(Thread.currentThread().getName() +
                        " here is producer , cnt = " + num);
                messageProducer.send(message);
                session.commit();
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
