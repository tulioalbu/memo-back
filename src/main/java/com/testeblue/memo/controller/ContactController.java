package com.testeblue.memo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testeblue.memo.model.Contact;
import com.testeblue.memo.service.ContactService;
import com.testeblue.memo.dto.ContactDto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contacts")
public class ContactController {

    final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Object> saveContact(@RequestBody ContactDto contactDto) {
        if (contactService.existsByContactName(contactDto.getContactName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Contact already registered.");
        }
        if (contactService.existsByContactEmail(contactDto.getContactEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: E-mail already registered.");
        }
        if (contactService.existsByContactPhone(contactDto.getContactPhone())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Phone already registered.");
        }

        var contact = new Contact();
        BeanUtils.copyProperties(contactDto, contact);
        contact.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.save(contact));
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneContact(@PathVariable(value = "id") Long contactId) {
        Optional<Contact> contactOptional = contactService.findById(contactId);
        if (!contactOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contactOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContact(@PathVariable(value = "id") Long contactId) {
        Optional<Contact> contactOptional = contactService.findById(contactId);
        if (!contactOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found.");
        }
        contactService.delete(contactOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Contact deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContact(@PathVariable(value = "id") Long idContact,
            @RequestBody ContactDto contactDto) {
        Optional<Contact> contactOptional = contactService.findById(idContact);
        if (!contactOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found.");
        }
        var contact = contactOptional.get();
        contact.setContactName(contactDto.getContactName());
        contact.setContactEmail(contactDto.getContactEmail());

        return ResponseEntity.status(HttpStatus.OK).body(contactService.save(contact));

    }

}
