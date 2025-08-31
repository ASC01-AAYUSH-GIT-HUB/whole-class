package org.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AirportServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(AirportServiceApplication.class,args);
        System.err.println( "yo, it is working" );
    }
}
