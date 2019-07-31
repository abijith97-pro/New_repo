package com.example.demo.model;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data

public class Register1{


    @Id
    @NotBlank
    @Size(min = 2,message = "Atleast 2 characters")
    private String full_name;
    @NotBlank
    @Size(min = 3,message = "Invalid email")
    private String email_address;
    @NotBlank
    @Size(min = 5,message = "Must be minimum 5 characters")
    private String password;


}
