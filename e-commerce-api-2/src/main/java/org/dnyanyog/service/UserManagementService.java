package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DButils;
import org.dnyanyog.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagementService {
	
	
	
	public List<User> getAllUser() throws SQLException
	{
	    String query="select * from user";
	    ResultSet result=DButils.executeSelectQuery(query);
	    ArrayList<User> userList=new ArrayList<>();
	    while(result.next())
	    {
	    	User user=new User();
	    	user.id=result.getInt(1);
	    	user.firstName=result.getString(2);
	    	user.lastName=result.getString(3);
	    	user.age=result.getInt(4);
	    	user.gender=result.getString(5);
	    	user.email=result.getString(6);
	    	user.mobileNo=result.getLong(7);
	    	user.password=result.getString(8);
	    	userList.add(user);
	    }
	    return userList;
	}
}
