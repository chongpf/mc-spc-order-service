package com.chong.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Autowired
    private Environment environment;

    public String getProperty(String key){
        return environment.getProperty(key,String.class);
    }

    public String getInstanceId(){
        return environment.getProperty("eureka.instance.instance-id",String.class);
    }
}
