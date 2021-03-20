package jdev.server.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"jdev.server", "jdev.server.services","jdev.tracker","jdev.tracker.services", "jdev.domain"})
public class Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);//s
    }
}
