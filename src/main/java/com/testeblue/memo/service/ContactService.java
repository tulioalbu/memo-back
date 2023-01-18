package com.testeblue.memo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.testeblue.memo.model.Contact;
import com.testeblue.memo.repository.ContactRepository;

import jakarta.transaction.Transactional;

@Service
public class ContactService {

    final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public boolean existsByContactName(String contactName) {
        return contactRepository.existsByContactName(contactName);
    }

    public boolean existsByContactEmail(String contactEmail) {
        return contactRepository.existsByContactEmail(contactEmail);
    }

    public boolean existsByContactPhone(String contactPhone) {
        return contactRepository.existsByContactPhone(contactPhone);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Optional<Contact> findByContactName(String contactName) {
        return contactRepository.findByContactName(contactName);
    }

    public Optional<Contact> findById(Long contactId) {
        return contactRepository.findById(contactId);
    }

    @Transactional
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

}