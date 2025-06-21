package org.example.webfluxapi.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "employees")
public class Employee {

    @Id
    private String id;
    private String FirstName;
    private String LastName;
    private String Email;
}
