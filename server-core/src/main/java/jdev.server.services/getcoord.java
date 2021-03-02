package jdev.server.services;
//import jdev.domain.Jform;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdev.domain.RestRequest;
import jdev.server.controllers.CounterController_SRV;
import org.springframework.stereotype.Service;

//import jdev.tracker.services.ResponseTick.JForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jdev on 05.05.2017.
 */
@Service
public class getcoord {
    private static final Logger log = LoggerFactory.getLogger(getcoord.class);
    private static Integer i = 0;
    public static String position;
    public static RestRequest request=new RestRequest();
    public static String push() throws Exception {
      //  ObjectMapper mapper = new ObjectMapper();
       // String jsonString = "[\"1000 Current coordinate: track# 2 lattitude=37.376205 longtitude=-122.1826 United States Palo Alto success\",\"989 Current coordinate: track# 14 lattitude=30.050003 longtitude=31.25 Egypt Misr success\"]";
      //   reader=mapper.reader(String.class);
       // List list=new ArrayList<>();
     //   mapper.readValue(jsonString,List.class);
      //  request.getCoord();
     //    ObjectMapper mapper = new ObjectMapper();
      //     String json = mapper.writeValueAsString(request.getCoord()+" "+ CounterController_SRV.showStatus().getStatus());
       //     log.info("POST result2: {}", json);
       //     log.info("2");
       // return ReqCreate.request.getCoord();
        try {
            FileReader fr = new FileReader("tracker-core\\src\\main\\resources\\log_file.log");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                position =line;
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            log.info("SRV reading: {}", CounterController_SRV.showStatus().getStatus());
        return CounterController_SRV.showStatus().getStatus();
        // log.info("SRV reading: {}", position);
        //  return position;
    }

    }

