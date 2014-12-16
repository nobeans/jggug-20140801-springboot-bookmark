package sample

import net.sf.log4jdbc.Log4jdbcProxyDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

@Configuration
public class AppConfig {

    @Autowired
    DataSourceProperties properties
    DataSource dataSource

//    @ConfigurationProperties(prefix = DataSourceAutoConfiguration.CONFIGURATION_PREFIX)
    @Bean(destroyMethod = "close")
    DataSource realDataSource() {
        dataSource = DataSourceBuilder.create(properties.classLoader)
            .url(properties.url)
            .username(properties.username)
            .password(properties.password)
            .build()
        return dataSource
    }

    @Bean
    DataSource dataSource() {
        new Log4jdbcProxyDataSource(dataSource)
    }
}
