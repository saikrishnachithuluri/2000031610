package com.dp.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationResponseRepository extends JpaRepository<AuthorizationResponse, Long> {
}
