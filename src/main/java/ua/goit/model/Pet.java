package ua.goit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Pet implements BaseEntity<Integer>{
    @SerializedName("id")
    private Integer id;
    @SerializedName("category")
    private Category category;
    @SerializedName("name")
    private String name;
    @SerializedName("photoUrls")
    private String[] photoUrls;
    @SerializedName("tags")
    private Tag[] tags;
    @SerializedName("status")
    private String status;

    public Pet(Integer id, Category category, String name, String[] photoUrls, Tag[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Pet() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + Arrays.toString(photoUrls) +
                ", tags=" + Arrays.toString(tags) +
                ", status='" + status + '\'' +
                '}';
    }
}
