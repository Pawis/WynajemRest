package com.example.WynajemRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WynajemRest.service.WynajemService;

@RestController
public class Controller {
	
	@Autowired
	private WynajemService wynajemService;;
	
	@PostMapping("/post")
	public String sql() {
		
		wynajemService.saveRezerwacja();
		
		return "asd";
	}

}
