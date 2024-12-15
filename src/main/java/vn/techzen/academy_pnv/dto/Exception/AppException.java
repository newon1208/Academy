package vn.techzen.academy_pnv.dto.Exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppException extends ErrorCode {
    ErrorCode errorCode;

    // Constructor để khởi tạo errorCode
    public AppException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
