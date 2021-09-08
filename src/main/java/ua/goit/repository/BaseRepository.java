package ua.goit.repository;

import okhttp3.ResponseBody;
import ua.goit.model.BaseEntity;

public interface BaseRepository <ID, E extends BaseEntity<ID>>{

    E createEntity(E e); // POST

    E updateEntity(E e); // PUT

    E getEntity(ID id); // GET

    ResponseBody deleteEntity(ID id); // DELETE


}
