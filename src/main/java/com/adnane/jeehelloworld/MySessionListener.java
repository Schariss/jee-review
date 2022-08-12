package com.adnane.jeehelloworld;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

//@WebListener
public class MySessionListener implements HttpSessionListener {

    private static final Logger LOG = Logger.getLogger(MySessionListener.class.getName());
    private int sessionCounter = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // in case we have multiple threads
        synchronized (this){
            sessionCounter++;
        }
        LOG.log(Level.INFO, "-----Session created, currently {0} sessions in memory-----", sessionCounter);
        //HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        synchronized (this){
            sessionCounter--;
        }
        LOG.log(Level.INFO, "-----Session destroyed, currently {0} sessions in memory-----", sessionCounter);
        //HttpSessionListener.super.sessionDestroyed(se);
    }
}
