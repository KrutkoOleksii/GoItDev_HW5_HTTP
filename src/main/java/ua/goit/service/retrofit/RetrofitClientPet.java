package ua.goit.service.retrofit;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;

import ua.goit.model.ApiResponse;
import ua.goit.model.Pet;

import java.util.List;

public interface RetrofitClientPet{

    @Multipart
    @POST("pet/{petId}/uploadImage")
    Call<ApiResponse> uploadPetImage(@Path("petId") Long id, @Part MultipartBody.Part filePart, @Part MultipartBody.Part additionalMetadata);

    @Multipart
    @POST("pet/{petId}/uploadImage")
    Call<ApiResponse> uploadPetImage(@Path("petId") Long id, @Part MultipartBody.Part filePart);

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
    Call<ApiResponse> updatePetById(@Path("petId") Long id, @Field("name") String name, @Field("status") String status);

    @DELETE("pet/{petId}")
    @Headers({"Content-Type: application/json"})
    Call<ApiResponse> deleteEntity(@Path("petId") Long id);
}
