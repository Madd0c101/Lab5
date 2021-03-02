package jdev.tracker.controllers;

import jdev.domain.Response;
import jdev.domain.RestRequest;
import jdev.tracker.services.BackendAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicLong;

import java.util.Random;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/geo")
public class CounterController_TRK {
    private final RestTemplate restTemplate;
    private static final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;
    private static final Logger log = LoggerFactory.getLogger(CounterController_TRK.class);
    private static String coord="";
    private static String STATUS = "error";
    private String server = "localhost";
    private int port = 8080;
    public CounterController_TRK(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /*
    private BackendAdapter backendAdapter;

    Random objGenerator = new Random();
  //  @Value("${instance.id.prop}")
    private int instanceId=1;

  //  @Value("${secret.prop}")
    private String secret="stage-secret";

    @GetMapping("/")
    public String getRequestsCount() {
      instanceId++;
        String result = String.format("Number of requests %s (gateway %d, secret %s)",
                backendAdapter.getRequests(), instanceId, secret);
        log.info("Handling count request. Result {}", result);
        return result;
    }
    */

    @GetMapping
    public static Response showStatus() {
        return new Response(STATUS, 1);
    }

    @PostMapping("/post")
    public static Response post(@RequestParam(value = "key") String key, @RequestBody RestRequest request) throws Exception {

        final Response response;

        if (key.equals("good")) {
            //      request.setCoord(Jform.fromJson());
            coord = request.getCoord();
            STATUS = SUCCESS_STATUS;
            // Process the request
            //log.info(coord);

            // Return success response to the client.
            response = new Response(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            response = new Response(ERROR_STATUS, AUTH_FAILURE);
            STATUS = ERROR_STATUS;
        }
        return response;
    }
    @RequestMapping("/**")
    @ResponseBody
    public String mirrorRest(@RequestBody String body, HttpMethod method, HttpServletRequest request) throws URISyntaxException
    {
        URI uri = new URI("http", null, server, port, request.getRequestURI(), request.getQueryString(), null);

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(uri, method, new HttpEntity<String>(body), String.class);

        return responseEntity.getBody();
    }

        }