package com.example;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomMailSender {
    private static Logger logger = LoggerFactory.getLogger(CustomMailSender.class);
    public void sendMail() throws AddressException, MessagingException {
        Session tmp = null;
        MimeMessage message = new MimeMessage(tmp);
        message.setRecipient(RecipientType.TO, new InternetAddress("pcmail01@localhost"));
        message.setFrom(new InternetAddress("sender@localhost"));
        message.setText("text");
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "localhost");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.transport.protocol", "smtp");
        logger.info("creating sessin...");
        Session session = Session.getInstance(props);
        logger.info("getting transport...");
        Transport transport = session.getTransport();

        logger.info("connecting transport...");
        transport.connect();
        logger.info("checking connection...");
        transport.isConnected();
        logger.info("checking connection...");
        transport.isConnected();
        logger.info("sending message...");
        if (!transport.isConnected()) {
            transport.connect();
        }
        transport.sendMessage(message, message.getAllRecipients());
        logger.info("closing connection...");
        transport.close();
    }
}
