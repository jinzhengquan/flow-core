package cn.flow;

import cn.flow.core.annotation.EnableGlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableGlobalExceptionHandler
public class FlowApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(FlowApplicationBootstrap.class, args);
    }
}
