package com.example.demo.Controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.UserTB;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController 
{
	private final UserService m_UserService;

	public UserController(UserService userService)
	{

		m_UserService = userService;
	}

	@GetMapping("/all")
	 public ResponseEntity<List<UserTB>> GetAllUsers() 
    {
        List<UserTB> customers = m_UserService.GetAll();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
	
}
