package ua.goit.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order implements BaseEntity<Long>{
    @SerializedName("id")
    private Long id;
    @SerializedName("petId")
    private Long petId;
    @SerializedName("quantity")
    private Integer quantity;
    @SerializedName("shipDate")
    private String shipDate;
    @SerializedName("status")
    private String status;
    @SerializedName("complete")
    private Boolean complete;

    public Order(Long id, Long petId, Integer quantity, String shipDate, String status, Boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    @Override
    public Long getId() {
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
