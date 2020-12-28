package com.qidong.myapplication.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public class GetRequest_Interface {
    @GET("")
    Call<ResponseBody> getcall(@Field("name") String name) {
        return null;
    }
}
