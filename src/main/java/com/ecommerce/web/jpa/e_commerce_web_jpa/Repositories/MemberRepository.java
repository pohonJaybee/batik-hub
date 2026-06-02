package com.ecommerce.web.jpa.e_commerce_web_jpa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.web.jpa.e_commerce_web_jpa.Entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByEmailAndPassword(String email, String password);

}
