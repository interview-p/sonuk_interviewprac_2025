package com.graphql.graphqlTest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.graphqlTest.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   
}
