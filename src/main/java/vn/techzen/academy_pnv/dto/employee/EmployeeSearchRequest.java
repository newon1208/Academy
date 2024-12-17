package vn.techzen.academy_pnv.dto.employee;




import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import vn.techzen.academy_pnv.model.Employee;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeSearchRequest {
    String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dobFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dobTo;
    Employee.Gender gender;
    String salaryRange;
    String phone;
    Integer departmentId;


    public void setEndDob(String endDob) {
    }

    public void setStartDob(String startDob) {
    }
}