package vn.techzen.academy_pnv.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv.model.Dictionary;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private List<Dictionary> dictionaryList = new ArrayList<>(
            List.of(
                    new Dictionary("hello", "xin chào"),
                    new Dictionary("apple", "táo"),
                    new Dictionary("banana", "chuối"),
                    new Dictionary("orange", "cam"),
                    new Dictionary("lemon", "chanh"),
                    new Dictionary("melon", "dưa"),
                    new Dictionary("watermelon", "dưa hấu"),
                    new Dictionary("blueberry", "việt quất")
            )
    );

    // API GET /dictionary to look up a word
    @GetMapping
    public ResponseEntity<String> dictionary(@RequestParam(defaultValue = "") String word) {
        String normalizedWord = word.trim().toLowerCase();
        for (Dictionary entry : dictionaryList) {
            if (entry.getEnglishWord().equals(normalizedWord)) {
                return ResponseEntity.ok(entry.getVietnameseTranslation());
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The word was not found in the dictionary.");
    }

    // API POST /dictionary to add a new word
    @PostMapping
    public ResponseEntity<Dictionary> addDictionary(@RequestBody Dictionary newEntry) {
        // Add new entry to the dictionary list
        dictionaryList.add(newEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntry);
    }
}