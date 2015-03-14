package br.com.andersonacs.sample.retrofit.restclient.service;

import br.com.andersonacs.sample.retrofit.model.User;
import br.com.andersonacs.sample.retrofit.restclient.wrapper.WrapperUser;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.mime.TypedInput;

/**
 * Created by anderson.acs on 3/12/2015.
 */
public interface ParseUserService {

    @GET("/users")
    public void listUsers(Callback<WrapperUser> response);

    @POST("/users")
    public String signUp(@Body User user);

    @GET("/login")
    public User login(@Query("username") String username, @Query("password") String password);

    @Headers("Content-Type: application/json")
    @POST("/requestPasswordReset")
    public void requestPasswordReset(@Body TypedInput jsonBody, Callback<Object> callback);

}