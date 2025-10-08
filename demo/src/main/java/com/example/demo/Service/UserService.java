package com.example.demo.Service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.Models.UserTB;
import com.example.demo.Repositories.UserRepository;

@Service
@Validated
public class UserService 
{
	private final UserRepository m_UserRepository;

	public UserService(UserRepository userRepository)
	{
		this.m_UserRepository = userRepository;

	}
	public List<UserTB> GetAll()
	{
		return m_UserRepository.findAll();
	}
}
