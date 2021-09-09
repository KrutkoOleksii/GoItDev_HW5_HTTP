package ua.goit.service.retrofit;

import retrofit2.Call;
import ua.goit.model.BaseEntity;

public interface RetrofitClient<ID,E extends BaseEntity<ID>> {

    Call<E> addEntity(E e);
    Call<E> updateEntity(E e);
    Call<E> getEntity (ID id);
    Call<E> deleteEntity(ID id);
}
