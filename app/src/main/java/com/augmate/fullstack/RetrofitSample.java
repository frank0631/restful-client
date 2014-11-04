package com.augmate.fullstack;

import com.google.gson.annotations.Expose;
import retrofit.RestAdapter;
import java.util.List;

import retrofit.client.Response;
import retrofit.http.*;

public class RetrofitSample {

    public static class Login{
        @Expose
        String email;
        @Expose
        String password;
    }

    public static void main(String[] args){

        String API_URL = "http://dreamfactory.frank0631.bitnamiapp.com/rest";
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        DreamFactoryService service = restAdapter.create(DreamFactoryService.class);

        Login frank = new Login();
        frank.email="trivauser@frank0631.com";
        frank.password="RawPasswordsSuck";

        Response token = service.session(frank);
        System.out.println(token.toString());

    }

    public interface DreamFactoryService {
        @Headers({"X-DreamFactory-Application-Name: triva"})
        @GET("/user")
        List<Login> listUsers();

        @Headers({"X-DreamFactory-Application-Name: triva"})
        @POST("/user/session")
        public Response session(@Body Login user);
    }
}

