package com.HealthInsurance.healthInsurance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HealthInsurance.healthInsurance.Model.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

	List <Claim> findAll();
  List<Claim> findByStatus(String status);
   Claim findByPolicy(String  policy);
   List<Claim> findByUserId(String userId);
}
