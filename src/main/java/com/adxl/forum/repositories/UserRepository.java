package com.adxl.forum.repositories;

import com.adxl.forum.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
