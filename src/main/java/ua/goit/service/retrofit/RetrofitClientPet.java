package ua.goit.service.retrofit;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import ua.goit.model.Pet;

import java.util.List;

//public interface RetrofitClientPet extends RetrofitClient<Long, Pet> {
public interface RetrofitClientPet{

    @Multipart
    @POST("pet/{petId}/uploadImage")
    Call<ResponseBody> uploadPetImage(@Path("petId") Long id, @Part MultipartBody.Part filePart, @Part MultipartBody.Part additionalMetadata);

    @Multipart
    @POST("pet/{petId}/uploadImage")
    Call<ResponseBody> uploadPetImage(@Path("petId") Long id, @Part MultipartBody.Part filePart);

    @POST("pet")
    @Headers({"Content-Type: application/json"})
    Call<Pet> addEntity(@Body Pet pet);

    @PUT("pet")
    @Headers({"Content-Type: application/json"})
    Call<Pet> updateEntity(@Body Pet pet);

    @GET("pet/findByStatus")
    @Headers({"Content-Type: application/json"})
    Call<List<Pet>> getPetByStatus(@Query("status") String[] status);

    @GET("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> getEntity(@Path("petId") Long id);

    @FormUrlEncoded
    @POST("pet/{petId}")
    Call<ResponseBody> updatePetById(@Path("petId") Long id, @Field("name") String name, @Field("status") String status);

    @DELETE("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> deleteEntity(@Path("petId") Long id);
}
