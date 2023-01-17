package com.testeblue.memo.dto;

import lombok.Data;



@Data
public class ContactDto {

    @NotBlank
    private String nameContact;

    @NotBlank
    @Email
    private String emailContact;

}