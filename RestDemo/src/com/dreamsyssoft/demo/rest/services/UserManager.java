package com.dreamsyssoft.demo.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.dreamsyssoft.demo.rest.model.UserRequest;
import com.dreamsyssoft.demo.rest.model.UserResponse;

@Consumes("application/json")
@Produces("application/json")
public interface UserManager
{
	@POST
	@Path("/fetchUserById/")
	public UserResponse fetchUserById(UserRequest request);

	@POST
	@Path("/fetchAllUsers/")
	public UserResponse fetchAllUsers(UserRequest request);

	@POST
	@Path("/insertUser/")
	public UserResponse insertUser(UserRequest request);

	@POST
	@Path("/updateUser/")
	public UserResponse updateUser(UserRequest request);

	@POST
	@Path("/deleteUser/")
	public UserResponse deleteUser(UserRequest request);
}
