package com.example.tour_guide;

import com.example.tour_guide.models.FoodDrinks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import POJO.POJOATM;
import POJO.POJOEducation;
import POJO.POJOEmergency;
import POJO.POJOFandD;
import POJO.POJOHotel;
import POJO.POJOService;
import POJO.POJOShopping;
import POJO.POJOTourist;
import POJO.POJOTransport;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class APIClient {
    public static TryCatchInterface tryCatchInterface;

    public static TryCatchInterface getTryCatchInterface() {
        if (tryCatchInterface == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(80, TimeUnit.SECONDS)
                    .connectTimeout(80, TimeUnit.SECONDS)
                    .build();
            Gson gson = new GsonBuilder()
                    .setLenient().create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://mapi.trycatchtech.com/v3/mumbai/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
            tryCatchInterface = retrofit.create(TryCatchInterface.class);
        }
        return tryCatchInterface;
    }

    public interface TryCatchInterface {

        @GET("tourist_categories_data_list")
        Call<ArrayList<POJOTransport>> getNewData(@Query("id") int id, @Query("cat_name") int cat_name);

        @GET("food_drink_categories_data_list")
        Call<ArrayList<POJOFandD>> getNewDataFandD(@Query("Username") int username, @Query("Email") int email, @Query("Name") int name);

//        add snake aoi
        @GET("food_drink_data_list_by_category?category_id=1")
        Call<ArrayList<FoodDrinks>> getNewDataSN1(@Query("Category_id") int categoryId);

        @GET("hotels_categories_data_list")
        Call<ArrayList<POJOHotel>> getNewDataHO(@Query("Username") int username, @Query("Email") int email, @Query("Name") int name);

        @GET("shopping_categories_data_list")
        Call<ArrayList<POJOShopping>> getNewData3(@Query("Username") int username, @Query("Email") int email, @Query("Name") int name);

        @GET("education_categories_data_list")
        Call<ArrayList<POJOEducation>> getNewData4(@Query("Username") int username, @Query("Email") int email, @Query("Name") int name);

        @GET("public_services_categories_data_list")
        Call<ArrayList<POJOService>> getNewData5(@Query("Username") int username, @Query("Email") int email, @Query("Name") int name);

        @GET("atm_and_banks_categories_data_list")
        Call<ArrayList<POJOATM>> getNewData7(@Query("Username") int username, @Query("Email") int email, @Query("Name") int name);

        @GET("emergency_data_list")
        Call<ArrayList<POJOEmergency>> getNewData8(@Query("Username") int username, @Query("Email") int email, @Query("Name") int name);

        @GET("tourist_categories_data_list")
        Call<ArrayList<POJOTourist>> getNewData9(@Query("id") int id, @Query("cat_name") int cat_name);

    }
}
