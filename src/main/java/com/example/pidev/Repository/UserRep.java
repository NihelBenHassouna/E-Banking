package com.example.pidev.Repository;

import com.example.pidev.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends CrudRepository<User,Long> {
}
