package org.example.webfluxapi.Entity;


import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public Employee(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return firstName;
    }
    public String setLastName(String lastName) {
        this.lastName = lastName;
        return lastName;
    }
    public String setEmail(String email) {
        this.email = email;
        return email;
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

}

