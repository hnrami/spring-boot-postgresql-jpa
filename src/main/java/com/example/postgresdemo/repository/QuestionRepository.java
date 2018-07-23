package com.example.postgresdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.postgresdemo.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	
	
	// this is also Query but JPA will understand
	//:description and @param("description") should be same 
	@Query("select q from Question q where q.title = :title and q.description = :description")
	public List<Question> getfirstMehtodofJPA(@Param("title")String title,
			@Param("description")String dec);
	
	
	@Query("select q from Question q where q.title = ?1 and q.description = ?2 ")
	public List<Question> getSecondMehtodofJPA(String title,String dec);
	
	
	
}
