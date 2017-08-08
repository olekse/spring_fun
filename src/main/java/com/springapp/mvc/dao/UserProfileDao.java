package com.springapp.mvc.dao;

import java.util.List;

import com.springapp.mvc.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
