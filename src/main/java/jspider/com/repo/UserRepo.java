package jspider.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jspider.com.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value="select u from user u where u.userEmail=?1")
	public User getUserByEmail(String email);
}
