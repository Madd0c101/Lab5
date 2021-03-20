package jdev.tracker.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static jdev.tracker.services.Msgsendservice.request;

//import static jdev.domain.Jform.point;
@Service
public class ResponseTick {

    private static final Logger log = LoggerFactory.getLogger(ResponseTick.class);
    private String S;

    public void run() throws IOException, InterruptedException, NullPointerException,java.lang.Exception {

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(request.getMessage());
            log.info("POST by tracker: {}", json);
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}