package com.jsystems.qa.frontend;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
    private static final Config CONFIG = ConfigFactory.load("config.conf");
    private static final String ENVIROMENT = CONFIG.getString("enviroment");
    private static final String BROWSER = CONFIG.getString("browser");
    private static final String MACHINE = CONFIG.getString("machine");

    private static final Config ENV = CONFIG.getConfig("enviroments").getConfig(ENVIROMENT);

    public static final String BASE_URL = ENV.getString("baseUrl");
    public static final String LOGIN = ENV.getString("login");
    public static final String PASSWORD = ENV.getString("password");

    public static String getBROWSER() {

        return BROWSER;
    }

    public static String getMACHINE() {

        return MACHINE;
    }

}

