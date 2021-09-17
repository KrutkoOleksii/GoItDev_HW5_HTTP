package ua.goit.service.retrofit;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import ua.goit.model.Pet;

import java.util.List;

//public interface RetrofitClientPet extends RetrofitClient<Long, Pet> {
public interface RetrofitClientPet{

    @Multipart
    @POST("pet/{petId}/uploadImage")
    @Headers({"Content-Type: application/json"})
    //Call<ResponseBody> uploadPetImage(@Path("petId") Integer id, @Part("additionalMetadata") String additionalMetadata, @Part("file") RequestBody image);
    Call<ResponseBody> uploadPetImage(@Path("petId") Long id, @Part MultipartBody.Part additionalMetadata, @Part MultipartBody.Part filePart);

    //@Override
    @POST("pet")
    @Headers({"Content-Type: application/json"})
    Call<Pet> addEntity(@Body Pet pet);

    //@Override
    @PUT("pet")
    @Headers({"Content-Type: application/json"})
    Call<Pet> updateEntity(@Body Pet pet);

    @GET("pet/findByStatus")
    @Headers({"Content-Type: application/json"})
    Call<List<Pet>> getPetByStatus(@Query("status") String[] status);

    //@Override
    @GET("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> getEntity(@Path("petId") Long id);

    @Multipart
    @POST("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> updatePetById(@Path("petId") Long id, @Part("name") RequestBody name, @Part("status") RequestBody status);

    //@Override
    @DELETE("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<Pet> deleteEntity(@Path("petId") Long id);
}
