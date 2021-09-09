package ua.goit.service;

import okhttp3.ResponseBody;
import ua.goit.model.BaseEntity;

public interface BaseService<ID, E extends BaseEntity<ID>>{

    E createEntity(E e); // POST

    E updateEntity(E e); // PUT

    E getEntity(ID id); // GET

    E deleteEntity(ID id); // DELETE


}
