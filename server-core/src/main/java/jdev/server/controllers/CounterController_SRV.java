package jdev.server.controllers;
import jdev.domain.Response;
import jdev.domain.RestRequest;
//import net.logstash.logback.marker.Markers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import static net.logstash.logback.marker.Markers.append;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/geoS")
public class CounterController_SRV {
    private final RestTemplate restTemplate;
    private static final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;
    private static final Logger log = LoggerFactory.getLogger(CounterController_SRV.class);
    private static String coord="";
    private static String STATUS = "error";
    private static String Log="";
    private final AtomicLong counter = new AtomicLong();
    public CounterController_SRV(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public static Response showStatus() {
        return new Response(STATUS, 1);
    }
/*
    @GetMapping("/requests")
    public Long getRequestsCount() {
        long result = counter.incrementAndGet();
        log.info(Markers.append("Request", result), "Request counter incremented");
        return result;
    }
*/
    /*
    @PostMapping("/post")
    public static Response post(@RequestParam(value = "key") String key, @RequestBody RestRequest request) throws java.lang.Exception{

        final Response response;

        if (key.equals("good")) {
      //      request.setCoord(Jform.fromJson());
        coord = request.getCoord();
        STATUS=SUCCESS_STATUS;
            // Process the request
        //log.info(coord);

            // Return success response to the client.
            response = new Response(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            response = new Response(ERROR_STATUS, AUTH_FAILURE);
            STATUS=ERROR_STATUS;
        }
        return response;
    }
    */

        }