package com.dhyan.netman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/okta")
public class NetmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetmanApplication.class, args);
	}

	@GetMapping("movies")
	public ResponseEntity<String> Hello(){
		return new ResponseEntity<>("Hi token", HttpStatus.OK);
	}
}
