package com.nadhem.users.register;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadhem.users.entities.User;


public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
    VerificationToken findByUser(User user);
}
