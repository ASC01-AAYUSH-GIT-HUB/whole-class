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
public class PlaneAppStart
{
    public static void main( String[] args )
    {
        SpringApplication.run(PlaneAppStart.class,args);
        System.err.println( "working man" );
    }
}
