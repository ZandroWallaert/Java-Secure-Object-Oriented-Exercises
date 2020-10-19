package be.howest.ti.sooa.domain;

import java.io.Serializable;

public class Review implements Serializable {

    private int id;
    private String name;
    private String reviewText;

    public Review(int id, String name, String reviewText) {
        this.id = id;
        this.name = name;
        this.reviewText = reviewText;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReviewText() {
        return reviewText;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reviewText='" + reviewText + '\'' +
                '}';
    }
}
