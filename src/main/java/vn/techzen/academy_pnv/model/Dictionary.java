package vn.techzen.academy_pnv.model;

public class Dictionary {
    private String englishWord;
    private String vietnameseTranslation;

    // Constructor
    public Dictionary(String englishWord, String vietnameseTranslation) {
        this.englishWord = englishWord;
        this.vietnameseTranslation = vietnameseTranslation;
    }

    // Getters and Setters
    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getVietnameseTranslation() {
        return vietnameseTranslation;
    }

    public void setVietnameseTranslation(String vietnameseTranslation) {
        this.vietnameseTranslation = vietnameseTranslation;
    }
}