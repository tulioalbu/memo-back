package com.testeblue.memo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testeblue.memo.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
  Optional<Contact> findByContactName(String contactName);

  boolean existsByContactName(String contactName);
  boolean existsByContactEmail(String contactEmail);
  boolean existsByContactPhone(String contactPhone);

  boolean existsByContactAvatar(String contactAvatar);

}
