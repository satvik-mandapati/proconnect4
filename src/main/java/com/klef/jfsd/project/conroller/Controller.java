package com.klef.jfsd.project.conroller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.project.service.Service;

@RestController
@CrossOrigin
public class Controller {
	
	
	@Autowired
	Service ser;
	
	
	@GetMapping("/")
	public String home()
	{
		return "Hello";
	}
	
	@PostMapping("/check")
	public ResponseEntity<Map<String, String>> check(@RequestBody Map<String, String> credentials) {
	    String username = credentials.get("username");
	    String password = credentials.get("password");

	    Map<String, String> users = Map.of(
	        "admin", "admin",
	        "prof", "prof",
	        "rohan","rohan123",
	        "user", "user",
	        "support", "support"
	    );

	    if (users.containsKey(username) && users.get(username).equals(password)) {
	    	
	    	ser.register(username,password);
	    	

	        String role = switch (username) {
	            case "admin" -> "admin";
	            case "prof" -> "professional";
	            case "rohan" -> "rohan123";
	            case "user" -> "user";
	            case "support" -> "support";
	            default -> "unknown";
	        };

	        Map<String, String> response = Map.of("role", role);
	        return ResponseEntity.ok(response);
	    }

	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid credentials"));
	}

	

}
