package ua.goit.model;

public class Tag implements BaseEntity<Integer> {
    private Integer id;
    private String name;

    @Override
    public Integer getId() {
        return id;
    }
}
