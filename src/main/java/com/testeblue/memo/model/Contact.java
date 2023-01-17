package com.testeblue.memo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "TB_CONTACT")
@AllArgsConstructor
@NoArgsConstructor
public class Contact implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long idContact;

  @Column(name = "contact_name")
  private String contactName;

  @Column(name = "contact_phone")
  private String contactPhone;

  @Column(name = "contact_email")
  private String contactEmail;

  @Column(nullable = false)
  private LocalDateTime registrationDate;

}
