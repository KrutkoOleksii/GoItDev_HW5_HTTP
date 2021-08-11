package ua.goit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Store implements BaseEntity<Integer>{
    @SerializedName("id")
    private Integer id;
    @SerializedName("petId")
    private Integer petId;
    @SerializedName("quantity")
    private Integer quantity;
    @SerializedName("shipDate")
    private Date shipDate;
    @SerializedName("status")
    private Integer status;
    @SerializedName("complete")
    private Boolean complete;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", petId=" + petId +
                ", quantity=" + quantity +
                ", shipDate=" + shipDate +
                ", status=" + status +
                ", complete=" + complete +
                '}';
    }
}
