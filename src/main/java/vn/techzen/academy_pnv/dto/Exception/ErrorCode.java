package vn.techzen.academy_pnv.dto.Exception;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    STUDENT_NOT_EXIST(40401, "Student is not exist!", HttpStatus.NOT_FOUND),
    TEACHER_NOT_EXIST(40402, "Teacher is not exist!", HttpStatus.NOT_FOUND),
    ;

    Integer code;
    String message;
    HttpStatus status;

    ErrorCode(int i, String s, HttpStatus httpStatus) {
    }
}
