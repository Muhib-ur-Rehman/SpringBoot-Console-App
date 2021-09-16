package com.example.SpringBootExample3;

import com.example.SpringBootExample3.model.User;
import com.example.SpringBootExample3.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootExample3Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootExample3Application.class, args);
		UserRepository userRepository=applicationContext.getBean(UserRepository.class);

		//Saving single user
//		User user = new User(5,"Ahmed","Karachi");
//		User u=userRepository.save(user);
//		System.out.println(u);

//		//Saving multiple users
//		User user1 = new User(2,"Ali","Karachi");
//		User user2 = new User(3,"Hasan","Karachi");
//		User user3 = new User(4,"Aqib","Karachi");
//		List<User> users = List.of(user1,user2,user3);
//		Iterable<User> result= userRepository.saveAll(users);
//		result.forEach(user -> System.out.println(user));

		//Updating user
//		Optional<User> op= userRepository.findById(2);
//		User user = op.get();
//		user.setCity("Lahore");
//		userRepository.save(user);

		//Get all user
//		Iterable<User> users = userRepository.findAll();
//		users.forEach(user -> System.out.println(user));

		//Deleting user
//		userRepository.deleteById(4);

		//Custom finder methods; check this link for more complex queries creation (https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)
		Iterable<User> user = userRepository.findByName("Ali");
		user.forEach(user1 -> System.out.println(user1));

		user = userRepository.findByCity("Karachi");
		user.forEach(user1 -> System.out.println(user1));

		user = userRepository.findByNameAndCity("Ali","Lahore");
		user.forEach(user1 -> System.out.println(user1));

		//Executing JPQL Query
		user = userRepository.findByUsingJPQLQuery("Muhib");
		user.forEach(user1 -> System.out.println(user1));

		//Executing Native Query
		user = userRepository.findByUsingNativeQuery("Muhib");
		user.forEach(user1 -> System.out.println(user1));



	}

}
