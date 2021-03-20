package jdev.tracker.main;
//import jdev.tracker.controllers.TrackController;
import jdev.domain.*;
import jdev.tracker.controllers.InjectionContext;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.net.URL;

//@SpringBootApplication
@ComponentScan({"jdev.tracker","jdev.tracker.services"})
public class Application {
    private static String foo=null;
    public static void main(String[] args) throws Exception {

//        SpringApplication.run(Application.class, args);//ss
          ApplicationContext context = new AnnotationConfigApplicationContext(InjectionContext.class);
    }
}
