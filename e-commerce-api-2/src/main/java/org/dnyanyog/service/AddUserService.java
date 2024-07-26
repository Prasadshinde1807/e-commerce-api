package org.dnyanyog.service;

import java.sql.SQLException;
import org.dnyanyog.dao.UserDao;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.dto.UpdateUserRequest;
import org.dnyanyog.dto.UpdateUserResponse;
import org.dnyanyog.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddUserService {
	@Autowired
	UserDao userDao;
	
	public AddUserResponse addUser(AddUserRequest request) throws SQLException,NullPointerException
	{
		Users usersTable=new Users();
		
		usersTable.setFirstName(request.getFirstName());
		usersTable.setLastName(request.getLastName());
		usersTable.setAge(request.getAge());
		usersTable.setGender(request.getGender());
		usersTable.setEmail(request.getEmail());
		usersTable.setMobileNo(request.getMobileNo());
		usersTable.setLoginName(request.getLoginName());
		usersTable.setPassword(request.getPassword());
		
		Users dataInsertedByDaoIncludingGeneratedValue = userDao.save(usersTable);
		
		AddUserResponse response =new AddUserResponse();
		
		response.setResponceCode("0000");
		response.setMessage("User added successfully");
		response.setRequest(request);
		response.setUserID(dataInsertedByDaoIncludingGeneratedValue.getId());
		return response;
	}
	
	public UpdateUserResponse updateUser(UpdateUserRequest request)
	{
		UpdateUserResponse response=new UpdateUserResponse();
		
		if(request.getUserID()==null)
		{
			response.setCodeResponce("911");
			response.setMessage("UserID not sent in request,it mandatory to update");
			return response;
		}
		
		Users usersTable=new Users();
		
		if(request.getUserID()!=usersTable.getId())
		{
			response.setCodeResponce("911");
			response.setMessage("UserID not found in table");
			return response;
		}
	
		
		usersTable.setId(request.getUserID());
		usersTable.setFirstName(request.getFirstName());
		usersTable.setLastName(request.getLastName());
		usersTable.setAge(request.getAge());
		usersTable.setGender(request.getGender());
		usersTable.setEmail(request.getEmail());
		usersTable.setMobileNo(request.getMobileNo());
		usersTable.setLoginName(request.getLoginName());
		usersTable.setPassword(request.getPassword());
		
		userDao.save(usersTable);
		
		response.setCodeResponce("0000");
		response.setMessage("User updated successfully");
		response.setRequest(request);
		return response;
		
		
}
}
