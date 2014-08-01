package sample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
class App {

    static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args)
    }
}
