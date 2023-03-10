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
@Table(name = "TB_CONTACT")
public class Contact implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long contactId;

  @Column(name = "contact_name")
  private String contactName;

  @Column(name = "contact_phone")
  private String contactPhone;

  @Column(name = "contact_email")
  private String contactEmail;

  @Column(name = "contact_avatar")
  private String contactAvatar;

  @Column(nullable = false)
  private LocalDateTime registrationDate;

}
