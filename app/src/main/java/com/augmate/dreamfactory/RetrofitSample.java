package com.augmate.dreamfactory;

import com.google.gson.annotations.Expose;
import retrofit.RestAdapter;
import java.io.File;
import java.util.List;
import java.util.Random;
import retrofit.client.Response;
import retrofit.http.*;
import retrofit.mime.TypedFile;

public class RetrofitSample {

    public static class Login{
        @Expose
        String email;
        @Expose
        String password;
    }

    public static void main(String[] args){

    try{
    
        String API_URL = "http://dreamfactory.frank0631.bitnamiapp.com/rest";
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        //restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        DreamFactoryService service = restAdapter.create(DreamFactoryService.class);

        Login frank = new Login();
        frank.email="trivia@frank0631.com";
        frank.password="RawPasswordsSuck";

        Session session = service.session(frank);

        // Random randomGenerator = new Random();
        // Record randomScore=new Record();
        // randomScore.setScore(randomGenerator.nextInt(100));
        // randomScore.setUser(randomGenerator.nextInt(100));
        // service.addScores(session.getSessionId(),randomScore);
        // RecordScores currentRecords = service.getScores(session.getSessionId());
        // for (Record record : currentRecords.getRecord())
        //     System.out.println(record.toString());
        
        TypedFile fbsTf = new TypedFile("image/jpeg",new File("fluffy-baby-seal.jpg"));
        service.uploadImg(session.getSessionId(),fbsTf,"fluffy-baby-seal");
        System.out.println(service.listImg(session.getSessionId()));
        
    }
    catch(Exception ex){
        ex.printStackTrace();
    }


    }

    public interface DreamFactoryService {
        @Headers({"X-DreamFactory-Application-Name: trivia"})
        @GET("/user")
        public List<Login> listUsers();

        @Headers({"X-DreamFactory-Application-Name: trivia"})
        @POST("/user/session")
        public Session session(@Body Login user);

        @Headers({"X-DreamFactory-Application-Name: trivia"})
        @GET("/mongo/TriviaScore")
        public RecordScores getScores(@Header("X-DreamFactory-Session-Token") String sessionid);

        @Headers({"X-DreamFactory-Application-Name: trivia"})
        @POST("/mongo/TriviaScore")
        public Response addScores(@Header("X-DreamFactory-Session-Token") String sessionid, 
                @Body Record record);
        
        @Headers({"X-DreamFactory-Application-Name: trivia"})
        @GET("/Images/ocr")
        public Response listImg(@Header("X-DreamFactory-Session-Token") String sessionid);
                
        @GET("/Images/ocr/{filepath}")
        public TypedFile getImg(@Header("X-DreamFactory-Session-Token") String sessionid, 
                @Path("filepath") String id);
        
        @Headers({"X-DreamFactory-Application-Name: trivia"})
        @POST("/Images/ocr/{filepath}")
        public Response uploadImg(@Header("X-DreamFactory-Session-Token") String sessionid, 
                @Body TypedFile file, @Path("filepath") String id);

    }
}

