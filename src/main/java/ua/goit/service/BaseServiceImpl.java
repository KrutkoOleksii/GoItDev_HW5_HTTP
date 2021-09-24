package ua.goit.service;

import okhttp3.ResponseBody;
import retrofit2.Response;
import ua.goit.model.BaseEntity;

public abstract class BaseServiceImpl<ID,E extends BaseEntity<ID>> implements BaseService<ID,E> {

    @Override
    public E createEntity(E e) {
        return null;
    }

    @Override
    public E updateEntity(E e) {
        return null;
    }

    @Override
    public E getEntity(ID id) {
        return null;
    }

    @Override
    public String deleteEntity(ID id) {
        return null;
    }

}
