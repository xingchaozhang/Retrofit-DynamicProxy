package com.enjoy.enjoyclass04.api;


import com.enjoy.enjoyclass04.retrofit.annotation.Field;
import com.enjoy.enjoyclass04.retrofit.annotation.Field2;
import com.enjoy.enjoyclass04.retrofit.annotation.GET;
import com.enjoy.enjoyclass04.retrofit.annotation.POST;
import com.enjoy.enjoyclass04.retrofit.annotation.Query;

import okhttp3.Call;

public interface EnjoyWeatherApi {

    // 方法的参数支持多个注解
    @POST("/v3/weather/weatherInfo")
    Call postWeather(@Field("city") @Field2("city") String city, @Field("key") String key);


    @GET("/v3/weather/weatherInfo")
    Call getWeather(@Query("city") String city, @Query("key") String key);
}
