package sample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.ComponentScan
import org.springframework.transaction.annotation.EnableTransactionManagement

// To avoid an error of DI caused by using transactional proxy.
// http://stackoverflow.com/questions/18369258/spring-aop-at-service-layer
// http://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/transaction.html
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@EnableAutoConfiguration
@ComponentScan
class App {

    static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args)
    }
}
