package org.example.webfluxapi.Dto;

import lombok.Setter;

@Setter
public class EmployeeDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDto(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    // constructor vacío y completo, si no usas Lombok
}
