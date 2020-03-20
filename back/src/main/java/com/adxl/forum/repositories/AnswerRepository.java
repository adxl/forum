package com.adxl.forum.repositories;

import com.adxl.forum.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer,Integer> {
}
