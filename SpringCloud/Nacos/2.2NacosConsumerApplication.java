package com.rali.nacos.nacos_consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)  //
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }

    @Bean   //
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RestController
    class HelloController{
        @Autowired  //
        private DiscoveryClient discoveryClient;

        @Autowired  //
        private RestTemplate restTemplate;

        private String serviceName = "my-provider";

        @GetMapping("/info")
        public String info(){
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName); //
            StringBuilder sb = new StringBuilder();
            sb.append("Allservices:"+discoveryClient.getServices()+"<br/>");
            sb.append("my-provider instance list:<br/>");
            serviceInstances.forEach( instance -> {     //使用lambda遍历获取的所有实例，去获取各个实例里的host和port信息。
                sb.append("[serviceId:"+instance.getServiceId()+
                            ",host:"+instance.getHost()+
                            ",port:"+instance.getPort()+"]");
                sb.append("<br/>");
            });
            return sb.toString();
        }

        @GetMapping("/hello")
        public String hello(){
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            ServiceInstance serviceInstance = serviceInstances.stream()
                    .findAny().orElseThrow(() ->
                    new IllegalStateException("no"+serviceName+"instance available"));  //
            return restTemplate.getForObject(   //
            "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+
                    "/echo?name=nacos",String.class);

        }
    }
}
