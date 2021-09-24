package ua.goit.service;

import okhttp3.ResponseBody;
import retrofit2.Response;
import ua.goit.model.BaseEntity;

public interface BaseService<ID, E extends BaseEntity<ID>>{

    E createEntity(E e); // POST

    E updateEntity(E e); // PUT

    E getEntity(ID id); // GET

    String deleteEntity(ID id); // DELETE


}
