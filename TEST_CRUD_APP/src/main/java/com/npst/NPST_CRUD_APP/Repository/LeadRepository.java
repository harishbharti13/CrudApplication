package com.npst.NPST_CRUD_APP.Repository;

import com.npst.NPST_CRUD_APP.Entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    Optional<Lead> findById(Long id);

    Optional<Lead> findByEmail(String email);

    List<Lead> findByMobileNumber(String mobileNumber);



}
