package com.fatec.chatapp.users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository <UserModel, Long> {
    public UserModel findOneById(UUID id);
}
