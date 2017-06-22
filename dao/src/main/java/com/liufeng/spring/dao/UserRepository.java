package com.liufeng.spring.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>,
		JpaSpecificationExecutor<User> {

	@Modifying
	@Query("update User a set a.name = ?2 where a.id = ?1")
	int updateNameById(Long id, String name);
	
	@Modifying
	@Query("update User a set a.isDeleted = 1 where a.id = ?1")
	int del(Long id);
	
	
}
