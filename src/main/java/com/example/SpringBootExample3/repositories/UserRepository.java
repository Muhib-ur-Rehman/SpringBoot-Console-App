package com.example.SpringBootExample3.repositories;

import com.example.SpringBootExample3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User> findByName(String name);

    public List<User> findByCity (String city);

    public List<User> findByNameAndCity(String name , String city);

    @Query("select u from User u where u.name=:n")
    public List<User> findByUsingJPQLQuery(@Param("n") String name);

    @Query(value = "select * from User where name =:n" , nativeQuery = true)
    public List<User> findByUsingNativeQuery(@Param("n") String name);

}
