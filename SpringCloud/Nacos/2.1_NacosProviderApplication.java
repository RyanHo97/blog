package com.rali.nacos.nacos_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class NacosProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosProviderApplication.class, args);//配合@SpringBoot注解启动一个SpringBoot应用
	}

	@RestController
	class EchoController{	//使用@RestController定义一个EchoController

		@GetMapping("/echo")	// /echo是EchoController对外暴露的访问路径
		public String echo(HttpServletRequest request){
			return "echo:"+request.getParameter("name");	// /echo返回"echo:#{name 参数}"
		}

	}
}
