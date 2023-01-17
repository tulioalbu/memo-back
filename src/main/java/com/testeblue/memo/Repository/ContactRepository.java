package com.testeblue.memo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testeblue.memo.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
  Optional<Contact> findByNameContact(String nameContact);

  boolean existsByNameContact(String nameContact);
  boolean existsByEmailContact(String emailContact);

}