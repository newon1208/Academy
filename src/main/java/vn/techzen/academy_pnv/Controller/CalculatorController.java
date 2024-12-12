package vn.techzen.academy_pnv.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.techzen.academy_pnv.model.Calculator;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping
    public ResponseEntity<String> calculate(
            @RequestParam(value = "firstNumber", defaultValue = "") String firstNumberStr,
            @RequestParam(value = "secondNumber", defaultValue = "") String secondNumberStr,
            @RequestParam(value = "operator", defaultValue = "") String operator) {

        // Check input
        if (firstNumberStr.isEmpty()) {
            return ResponseEntity.badRequest().body("First number cannot be empty.");
        } else if (secondNumberStr.isEmpty()) {
            return ResponseEntity.badRequest().body("Second number cannot be empty.");
        } else if (!isDouble(firstNumberStr)) {
            return ResponseEntity.badRequest().body("First number must be numeric.");
        } else if (!isDouble(secondNumberStr)) {
            return ResponseEntity.badRequest().body("Second number must be numeric.");
        }

        // Convert String to double
        double firstNumber = Double.parseDouble(firstNumberStr);
        double secondNumber = Double.parseDouble(secondNumberStr);

        // Perform calculations
        try {
            Calculator calculator = new Calculator(firstNumber, secondNumber, operator);
            return ResponseEntity.ok("Result: " + calculator.getResult());
        } catch (ArithmeticException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Check if it is a real number
    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}