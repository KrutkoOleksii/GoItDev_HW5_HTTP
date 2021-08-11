package ua.goit.model;

import com.google.gson.annotations.SerializedName;

public class Tag implements BaseEntity<Integer> {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;

    public Tag(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
