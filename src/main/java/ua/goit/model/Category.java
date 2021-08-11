package ua.goit.model;

import com.google.gson.annotations.SerializedName;

public class Category implements BaseEntity<Integer> {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;

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
