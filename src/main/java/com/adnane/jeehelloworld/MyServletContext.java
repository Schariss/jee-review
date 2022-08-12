package com.adnane.jeehelloworld;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Level;
import java.util.logging.Logger;

//@WebListener
public class MyServletContext implements ServletContextListener {

    private static  final Logger LOG = Logger.getLogger(MyServletContext.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.log(Level.INFO, "--------contextInitialized--------");
        //ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.log(Level.INFO, "--------contextDestroyed--------");
        //ServletContextListener.super.contextDestroyed(sce);
    }
}
