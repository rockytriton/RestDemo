package com.dreamsyssoft.demo.rest.model;

import java.util.List;

public class UserResponse
{
	private List<User> users;
	private String errorMessage;
	private Boolean success = true;

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}

	public Boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(Boolean success)
	{
		this.success = success;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
}
