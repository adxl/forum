package com.adxl.forum.repositories;

import com.adxl.forum.models.Thread;
import org.springframework.data.repository.CrudRepository;


public interface ThreadRepository extends CrudRepository<Thread,Integer> {
}
