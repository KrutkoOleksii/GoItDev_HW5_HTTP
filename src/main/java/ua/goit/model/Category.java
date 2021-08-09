package ua.goit.model;

public class Category implements BaseEntity<Integer> {
    private Integer id;
    private String name;

    @Override
    public Integer getId() {
        return id;
    }
}
