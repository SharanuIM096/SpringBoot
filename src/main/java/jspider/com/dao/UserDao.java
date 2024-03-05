package jspider.com.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jspider.com.dto.User;
import jspider.com.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {

		return repo.save(user);

	}

	public User getuser(Integer userId) {
		return repo.findById(userId).orElse(null);
	}

	public User updateUser(int id, User user) {
		Optional<User> user1 = repo.findById(id);
		if (user1 != null) {
			user.setUserId(id);
			return repo.save(user);
		}
		return null;
	}

	public User deleteUser(int id) {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			repo.deleteById(id);
			return user.get();
		}
		return null;
	}

	public User getUserByEmail(String email) {
		User user=getUserByEmail(email);
		if(user!=null) {
			return user;
		}
		
		return null;
	}
}
