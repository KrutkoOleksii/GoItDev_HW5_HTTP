package ua.goit.model;

import com.google.gson.annotations.SerializedName;

public class Category implements BaseEntity<Long> {
    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
        new Category(0L, "out of categories");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
