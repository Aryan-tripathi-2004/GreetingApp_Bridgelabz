package org.example.greetingapp.repository;

import org.example.greetingapp.Model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    @Query(value = "SELECT * FROM AUTH_USER WHERE EMAIL = :email", nativeQuery = true)
    AuthUser findByEmail(@Param("email") String email);
    AuthUser findByResetToken(String resetToken);
}
