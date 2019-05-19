package com.example.misa_demo_retrofit;

import com.example.misa_demo_retrofit.model.PersonPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/photos")
    Call<List<PersonPhoto>> getAllPhotos();

}
