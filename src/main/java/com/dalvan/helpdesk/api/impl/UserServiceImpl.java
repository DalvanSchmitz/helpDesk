package com.dalvan.helpdesk.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dalvan.helpdesk.api.entity.User;
import com.dalvan.helpdesk.api.repository.UserRepository;
import com.dalvan.helpdesk.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(String id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);
	}

	@Override
	public Page<User> findAll(int page, int count) {
		@SuppressWarnings("deprecation")
		Pageable pages = new PageRequest(page, count);
		return userRepository.findAll(pages);
	}

}
