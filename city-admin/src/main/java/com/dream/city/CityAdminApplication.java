package com.dream.city;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.dream.city.base.config.RedisConfig;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @author Wvv
 */
@SpringBootApplication
@EnableAdminServer
@EnableEurekaClient
//@MapperScan("com.dream.city.base.model.mapper")
@EnableFeignClients
@EnableCaching
@Import({RedisConfig.class})
@EnableDistributedTransaction
public class CityAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityAdminApplication.class, args);
    }

}
