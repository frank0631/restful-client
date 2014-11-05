package com.augmate.dreamfactory;

import com.google.gson.annotations.Expose;
import retrofit.RestAdapter;
import java.util.List;
import java.util.Random;

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
        //restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        DreamFactoryService service = restAdapter.create(DreamFactoryService.class);

        Login frank = new Login();
        frank.email="trivauser@frank0631.com";
        frank.password="RawPasswordsSuck";

        Session session = service.session(frank);

        Random randomGenerator = new Random();
        Record randomScore=new Record();
        randomScore.setScore(randomGenerator.nextInt(100));
        randomScore.setUser(randomGenerator.nextInt(100));
        service.addScores(session.getSessionId(),randomScore);

        RecordScores currentRecords = service.getScores(session.getSessionId());
        for (Record record : currentRecords.getRecord())
            System.out.println(record.toString());



    }

    public interface DreamFactoryService {
        @Headers({"X-DreamFactory-Application-Name: triva"})
        @GET("/user")
        List<Login> listUsers();

        @Headers({"X-DreamFactory-Application-Name: triva"})
        @POST("/user/session")
        public Session session(@Body Login user);

        @Headers({"X-DreamFactory-Application-Name: triva"})
        @GET("/db/TriviaScore")
        RecordScores getScores(@Header("X-DreamFactory-Session-Token") String sessionid);

        @Headers({"X-DreamFactory-Application-Name: triva"})
        @POST("/db/TriviaScore")
        Response addScores(@Header("X-DreamFactory-Session-Token") String sessionid, @Body Record record);

    }
}

