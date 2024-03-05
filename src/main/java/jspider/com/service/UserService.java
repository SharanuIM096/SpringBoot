package jspider.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jspider.com.dao.UserDao;
import jspider.com.dto.User;
import jspider.com.response.ResponseStructure;

@Service
public class UserService {
	
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private User user;
	
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	
	public User getuser(Integer userId) {
		return dao.getuser(userId);
	}

	
	public ResponseStructure<User> updateUser(int id, User user)
	{
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("updates message");
		responseStructure.setData(dao.updateUser(id, user));
		return responseStructure;
}
	
	public ResponseStructure<User> deleteUser(int id)
	{
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("delete message");
		responseStructure.setData(dao.deleteUser(id));
		return responseStructure;
}
	public ResponseStructure<User> findByEmail(String email,String password){
		User user=dao.getUserByEmail(email);
		
		if(password.equals(user.getUserPassword())){
			ResponseStructure<User> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("successfully fetched");
			responseStructure.setData(dao.getUserByEmail(email));
			return responseStructure;
			
		}
		return null;
	}

}