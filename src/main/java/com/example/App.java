package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * Hello world!
 *
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws AddressException, MessagingException {
        logger.info("started.");
        CustomMailSender sender = new CustomMailSender();
        sender.sendMail();
        return;
    }
}