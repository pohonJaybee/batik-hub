package com.ecommerce.web.jpa.e_commerce_web_jpa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.web.jpa.e_commerce_web_jpa.Entities.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {

    Staff findByEmailAndPassword(String email, String password);
}
