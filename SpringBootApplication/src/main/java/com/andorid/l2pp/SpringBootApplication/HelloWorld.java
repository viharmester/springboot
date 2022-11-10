package com.andorid.l2pp.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

public class HelloWorld implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    @Value("${spring.datasource.url}")
    private String dbPath;

    @Override
    public void run(String... args) throws Exception {
        LOG.info("hello world");
        LOG.info("DB path is: " + dbPath);
    }
}
