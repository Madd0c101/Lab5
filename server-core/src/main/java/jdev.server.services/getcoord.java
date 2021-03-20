package jdev.server.services;
import jdev.domain.*;
import jdev.server.controllers.CounterController_SRV;
import jdev.server.controllers.SRVController;
import jdev.server.main.Application;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

/**
 * Created by jdev on 05.05.2017.
 */
@Service
public class getcoord {
    private static final Logger log = LoggerFactory.getLogger(getcoord.class);
   public static String response;
    public static String out;
    public static String push() throws Exception {
            response = IOUtils.toString(new URL("http://localhost:8080/clients/"), "UTF8");
            String str[]=response.split(",");
        out=str[str.length-1].replaceAll("[}]]","");
         //    log.info("HERE3",out);
        return out;
    }

    }

