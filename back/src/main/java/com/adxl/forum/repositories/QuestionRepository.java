package com.adxl.forum.repositories;

import com.adxl.forum.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question,Integer> {
}
