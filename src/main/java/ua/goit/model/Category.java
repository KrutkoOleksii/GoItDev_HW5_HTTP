package ua.goit.model;

import com.google.gson.annotations.SerializedName;

public class Category implements BaseEntity<Integer> {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
        new Category(0, "out of categories");
    }

    @Override
    public Integer getId() {
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
