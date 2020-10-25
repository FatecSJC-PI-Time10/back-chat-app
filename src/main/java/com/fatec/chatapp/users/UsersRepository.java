package com.fatec.chatapp.users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository <UserModel, Long> {
    UserModel findOneById(UUID id);

    @Query(value = "SELECT * FROM users u WHERE u.email = :email", nativeQuery = true)
    UserModel findOneByEmail(String email);
}
