package ua.goit.model;

import com.google.gson.annotations.SerializedName;

public class Tag implements BaseEntity<Long> {
    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Long getId() {
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
