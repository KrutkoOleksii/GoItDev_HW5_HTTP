package ua.goit.model;

public class Pet implements BaseEntity<Integer>{
    private Integer id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;


    @Override
    public Integer getId() {
        return id;
    }
    /*
    {
      "id": 0,
      "category": {
        "id": 0,
        "name": "string"
      },
      "name": "doggie",
      "photoUrls": [
        "string"
      ],
      "tags": [
        {
          "id": 0,
          "name": "string"
        }
      ],
      "status": "available"
    }
    * */
}
