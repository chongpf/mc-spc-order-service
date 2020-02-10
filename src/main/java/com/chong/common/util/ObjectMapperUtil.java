package com.chong.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectMapperUtil {

    private static final Logger logger = LoggerFactory.getLogger(ObjectMapperUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String getStringValue(Object responseData){
        try {
            return mapper.writeValueAsString(responseData);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
