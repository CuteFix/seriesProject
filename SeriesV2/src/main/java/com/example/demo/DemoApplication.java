package com.example.demo;

import lombok.extern.java.Log;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PreDestroy;
import javax.websocket.OnClose;


@SpringBootApplication
public class DemoApplication{
    //private static final Logger logger = LogManager.getLogger(DemoApplication.class);
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

    private static String log4jConfPath = "D:\\4\\PIS\\Series\\src\\test\\java\\com\\example\\demo\\Servise\\log4j.properties";

    public static void configureLogger(String[] args){
        PropertyConfigurator.configure(log4jConfPath);
        if (args.length > 0 && args[0].equals("-verbose")){
            logger.setLevel(Level.TRACE);
        }
    }


    public static void main(String[] args) {
        args = new String[]{"-verbose"};
        configureLogger(args);
        logger.info("Start application");
        SpringApplication.run(DemoApplication.class, args);
        logger.info("Finish application");
    }
}
