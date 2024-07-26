package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.dao.UserDao;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class LoginService {
	@Autowired
	UserDao userdao;
	
	public LoginResponse login(LoginRequest loginBody) 
	{
		LoginResponse loginResponse=new LoginResponse();
		//Users users=userdao.findById(1).get();
		//Users users=userdao.findByFirstName(loginBody.user);
		//Users users=userdao.findByPassword(loginBody.password);
		Users users=userdao.findByLoginName(loginBody.user);
		if(users.getLoginName().equals(loginBody.user) && users.getPassword().equals(loginBody.password))
		{
		
			loginResponse.errorCode="0000";
			loginResponse.message="Login Success";
			loginResponse.id=users.getId();
			loginResponse.firstName=users.getFirstName();
			loginResponse.lastName=users.getLastName();
			loginResponse.loginName=users.getLoginName();
			loginResponse.password=users.getPassword();
			return loginResponse;
		}
		else
		{
			loginResponse.errorCode="9111";
			loginResponse.message="Login Failed";
			return loginResponse;
		}
		
	}
		
	}
