package vn.techzen.academy_pnv.model;

public class Student {
    private int id;
    private String name;
    private double score;

    // Constructor
    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // Optional: Override toString() to make debugging easier
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', score=" + score + "}";
    }
}
