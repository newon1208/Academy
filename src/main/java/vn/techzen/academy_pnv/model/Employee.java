package vn.techzen.academy_pnv.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     UUID id;

     String name;

     LocalDate dob;

     Gender gender;

     Double salary;

     String phone;

     Integer departmentId;

     public enum Gender {
          MALE, FEMALE, OTHER;
     }
     @PrePersist
     public void generateId() {
          if (id == null) {
               id = UUID.randomUUID();
          }
}
}