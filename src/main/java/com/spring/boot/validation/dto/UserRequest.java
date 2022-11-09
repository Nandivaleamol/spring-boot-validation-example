package com.spring.boot.validation.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	@NotNull(message = "username shouldn't be null")
	private String name;
	@Email(message = "invalid email address")
	private String email;
	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered")
	private String mobile;
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank(message = "nationality shouldn't be blank or null")
	private String nationality;

}
