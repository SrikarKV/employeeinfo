package com.test.employeeinfo.repositories;

import com.test.employeeinfo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User save(User user);
}
