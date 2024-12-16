package vn.techzen.academy_pnv.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonResponse {

    // Example of returning an OK response
    public static ResponseEntity<?> ok(Object data) {
        return ResponseEntity.ok(data);
    }

    // Example of returning a Created response
    public static ResponseEntity<?> created(Object data) {
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    // Example of returning No Content response
    public static ResponseEntity<?> noContent() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Add more methods here as required, ensuring all return statements are included
}
