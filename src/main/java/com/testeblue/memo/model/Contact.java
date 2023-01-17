package com.testeblue.memo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="TB_CONTACT")
public class Contact implements Serializable{
  
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long idContact;

  @Column(name = "name_contact")
  private String nameContact;

  @Column(name = "phone_contact")
  private String phoneContact;

  @Column(name = "email_contact")
  private String emailUser;

  @Column(nullable = false)
  private LocalDateTime registrationDate;
  
}
