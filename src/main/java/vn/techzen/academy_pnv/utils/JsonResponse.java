package vn.techzen.academy_pnv.utils;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vn.techzen.academy_pnv.dto.ApiResponse;

public class JsonResponse {

    public static <T> ResponseEntity<ApiResponse<T>> ok(T t) {
        return ResponseEntity.ok(ApiResponse.<T>builder().data(t).build());
    }
    public static <T> ResponseEntity<ApiResponse<T>> created(T t) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<T>builder().data(t).build());
    }



    public static ResponseEntity<Void> notFound() {
        return ResponseEntity.notFound().build();
    }
}
