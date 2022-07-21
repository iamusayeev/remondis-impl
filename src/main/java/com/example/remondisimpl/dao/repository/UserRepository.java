package com.example.remondisimpl.dao.repository;

import com.example.remondisimpl.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
