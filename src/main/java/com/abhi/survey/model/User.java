package com.abhi.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;


@Entity
@Table(name = "User")
@Data
public class User {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer userId;

   @NotNull(message = "Name is  Required")
   private String userName;

   @Column(unique = true)
   @Email(message = "Enter Valid Email")
   @NotNull
   private String userEmail;

   @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}",
   message="Must contains contains altest a upper case alphabet, lower case alphabet, special characters and digits")
   private String password;

}
