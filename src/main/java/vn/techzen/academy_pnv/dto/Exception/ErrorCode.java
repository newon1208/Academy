package vn.techzen.academy_pnv.dto.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    STUDENT_NOT_EXIST(40401, "Student is not exist!", HttpStatus.NOT_FOUND),
    TEACHER_NOT_EXIST(40402, "Teacher is not exist!", HttpStatus.NOT_FOUND);

    private final Integer code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(Integer code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
