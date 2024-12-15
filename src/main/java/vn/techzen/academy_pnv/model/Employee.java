package vn.techzen.academy_pnv.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

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
}