package jdev.tracker.services;
import jdev.domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import jdev.domain.Jform;

/**
 * Created by user on 04.02.2021.
 */

@Service
public class Msgsendservice {

    private static final Logger log = LoggerFactory.getLogger(Msgsendservice.class);
    private long previous;
    private String foo=null;
    public static Client request=new Client();
   // private static Long i= Long.valueOf(0);
   static AtomicInteger i = new AtomicInteger(0);
    RestTemplateBuilder builder=new RestTemplateBuilder();
    public void send() throws InterruptedException,Exception,IOException,java.lang.NullPointerException {
     //   ReqCreate.create();
  //    request=ReqCreate.request;
      //  log.info("sending request");
        long current = System.currentTimeMillis();
     //  log.info((current - previous) + " Current coordinate: " + Jform.fromJson());

        request.setId(i.intValue());
        if (Jform.fromJson()==foo)
        {
            request.setMessage("conection lost");

        }
        else {
            request.setMessage(Integer.toString(i.incrementAndGet())+ " Current coordinate: " + Jform.fromJson());
            //(current - previous)
        }
        try {
            String result= builder.build().postForObject("http://localhost:8080/clients",request,String.class);
        //    i.++;
            previous = current;
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ResponseTick resp;

    @PostConstruct
    @Scheduled(cron= "${cron.prop3}") //60000
    private void init() throws InterruptedException,Exception {
        resp.run();
    }

}

