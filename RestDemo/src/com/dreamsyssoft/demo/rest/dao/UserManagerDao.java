package com.dreamsyssoft.demo.rest.dao;

import java.util.List;

import com.dreamsyssoft.demo.rest.model.User;

public interface UserManagerDao
{
	public User fetchUserById(Integer id);

	public List<User> fetchAllUsers();

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);
}
