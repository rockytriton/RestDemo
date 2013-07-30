package com.dreamsyssoft.demo.rest.services;

import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import com.dreamsyssoft.demo.rest.model.UserRequest;
import com.dreamsyssoft.demo.rest.model.UserResponse;

@Rest(rootUrl = "http://10.0.0.5:8080/RestDemo/services/rest/UserManager", converters = { MappingJacksonHttpMessageConverter.class })
public interface UserManager {
	@Post("/fetchUserById")
	public UserResponse fetchUserById(UserRequest request);
	@Post("/fetchAllUsers")
	public UserResponse fetchAllUsers(UserRequest request);
	@Post("/insertUser")
	public UserResponse insertUser(UserRequest request);
	@Post("/updateUser")
	public UserResponse updateUser(UserRequest request);
	@Post("/deleteUser")
	public UserResponse deleteUser(UserRequest request);
}

