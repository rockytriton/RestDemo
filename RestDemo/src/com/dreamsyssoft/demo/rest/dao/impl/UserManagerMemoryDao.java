package com.dreamsyssoft.demo.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dreamsyssoft.demo.rest.dao.UserManagerDao;
import com.dreamsyssoft.demo.rest.model.User;

public class UserManagerMemoryDao implements UserManagerDao
{
	private int nextUserId = 0;

	List<User> users = new ArrayList<User>();

	public User fetchUserById(Integer id)
	{
		for (User user : users)
		{
			if (user.getId() == id)
			{
				return user;
			}
		}

		throw new RuntimeException("User Not Found: " + id);
	}

	public List<User> fetchAllUsers()
	{
		return users;
	}

	public void insertUser(User user)
	{
		user.setId(nextUserId++);
		users.add(user);
	}

	public void updateUser(User user)
	{
		User editUser = fetchUserById(user.getId());

		editUser.setBirthDate(user.getBirthDate());
		editUser.setCity(user.getCity());
		editUser.setEmail(user.getEmail());
		editUser.setName(user.getName());
		editUser.setState(user.getState());
	}

	public void deleteUser(User user)
	{
		User delUser = fetchUserById(user.getId());
		users.remove(delUser);
	}

}
