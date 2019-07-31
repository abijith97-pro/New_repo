package com.example.demo.Model;
        import lombok.Data;
        import javax.validation.constraints.NotBlank;
        import javax.validation.constraints.Size;

@Data


public class Register {

    @NotBlank
    @Size(min = 2,message = "Atleast 2 characters")
    private String full_name;
    @NotBlank
    @Size(min = 5,message = "Must be minimum 5 characters")
    private String password;

}
