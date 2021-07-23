package com.sudipasarkar.kisanseva;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<SchemeModal> getAllNews(@Url String url);
    @GET
    Call<SchemeModal>getNewsBYCategory(@Url String url);
}
