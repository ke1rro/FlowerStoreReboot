package com.example.demo;

import java.util.List;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/demo")
public class DemoApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/messages")
	public List<String> demoMessages() {
		return List.of(
				"Welcome to Flower Store demo",
				"Use /api/flowers to browse catalog",
				"Use /api/payments or /api/delivery to test strategies");
	}

}
