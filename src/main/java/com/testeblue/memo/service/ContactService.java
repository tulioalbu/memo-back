package com.testeblue.memo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.testeblue.memo.Repository.ContactRepository;
import com.testeblue.memo.model.Contact;

import jakarta.transaction.Transactional;

@Service
public class ContactService {

    final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    public Contact save(Contact contact) {
        return contactRepository.save(contact) ;
    }

    public boolean existsByNameContact(String nameContact) {
        return contactRepository.existsByNameContact(nameContact);
    }

    public boolean existsByEmailContact(String emailContact) {
        return contactRepository.existsByEmailContact(emailContact);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Optional<Contact> findByNameContact(String nameContact) {
        return contactRepository.findByNameContact(nameContact);
    }

    public Optional<Contact> findById(Long idContact) {
        return contactRepository.findById(idContact);
    }

    @Transactional
    public void delete(Contact contact) {
         contactRepository.delete(contact);
    }

}