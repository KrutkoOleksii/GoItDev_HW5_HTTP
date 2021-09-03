package ua.goit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Order implements BaseEntity<Integer>{
    @SerializedName("id")
    private Integer id;
    @SerializedName("petId")
    private Integer petId;
    @SerializedName("quantity")
    private Integer quantity;
    @SerializedName("shipDate")
    private String shipDate;
    @SerializedName("status")
    private String status;
    @SerializedName("complete")
    private Boolean complete;

    public Order(Integer id, Integer petId, Integer quantity, String shipDate, String status, Boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

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
