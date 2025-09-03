package com.grpc.grpcDemo.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grpc.grpcDemo.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
