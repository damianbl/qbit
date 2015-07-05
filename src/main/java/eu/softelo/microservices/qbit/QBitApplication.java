package eu.softelo.microservices.qbit;

import eu.softelo.microservices.qbit.service.TodoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QBitApplication {

    public static void main(String[] args) {
        SpringApplication.run(QBitApplication.class, args);
    }

    @Bean
    public TodoService todoService() {
        return new TodoService();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}