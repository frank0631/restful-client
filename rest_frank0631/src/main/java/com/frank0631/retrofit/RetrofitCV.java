package com.frank0631.retrofit;

import com.google.gson.annotations.Expose;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Response;
import retrofit.http.*;
import retrofit.mime.TypedFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class RetrofitCV {

    public static void main(String[] args){

    try{


        String API_URL = "localhost:9009/";
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        //restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        CVBackendService service = restAdapter.create(CVBackendService.class);

        //Create chain of calls that preprocess the OCR Image


    }
    catch(Exception ex){
        ex.printStackTrace();
    }


    }

    public interface CVBackendService {

        @Multipart
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/upload/file")
        public String FileUpload(@Field("name") String name,
                                 @Part("file") TypedFile file);

        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/upload/image")
        public String ImageUpload(@Field("name") String name,
                                  @Part("file") TypedFile file);

        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/blur")
        public void blur(@Field("src-img") String srcname,
                         @Field("blur-img") String blurname,
                         @Query(value = "block") Integer block,
                         @Query(value = "sigma") Integer sigma);

        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/sharp")
        public void sharp(@Field("src-img") String srcname,
                          @Field("blur-img") String blurname,
                          @Field("sharp-img") String sharpname,
                          @Query(value = "alpha") Double alpha,
                          @Query(value = "beta") Double beta,
                          @Query(value = "gamma") Double gamma);

        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/sobel")
        public void sobel(@Field("src-img") String srcname,
                          @Field("sobel-img") String sobelname,
                          @Query(value = "alpha") Double alpha,
                          @Query(value = "beta") Double beta,
                          @Query(value = "gamma") Double gamma);

        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/scharr")
        public void scharr(@Field("src-img") String srcname,
                           @Field("scharr-img") String scharrname,
                           @Query(value = "alpha") Double alpha,
                           @Query(value = "beta") Double beta,
                           @Query(value = "gamma") Double gamma);

        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/thresh")
        public void thresh(@Field("src-img") String srcname,
                           @Field("thresh-img") String threshname,
                           @Query(value = "otsu") Boolean otsu,
                           @Query(value = "block") Integer block,
                           @Query(value = "c") Integer c,
                           @Query(value = "inv") Boolean invert);

        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/canny")
        public void canny(@Field("src-img") String srcname,
                          @Field("canny-img") String cannyname,
                          @Query(value = "threshold1") Double threshold1,
                          @Query(value = "threshold2") Double threshold2,
                          @Query(value = "block") Integer apertureSize,
                          @Query(value = "L2") Boolean L2Gradient);

        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/prob_hough")
        public void prob_hough(@Field("src-img") String srcname,
                               @Field("hough-img") String houghname,
                               @Query(value = "rho") Double rho,
                               @Query(value = "degrees") Integer degrees,
                               @Query(value = "threshold") Integer threshold,
                               @Query(value = "min-line-size") Integer minLineSize,
                               @Query(value = "line-gap") Integer lineGap);

        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/polar_hough")
        public void polar_hough(@Field("src-img") String srcname,
                                @Field("hough-img") String houghname,
                                @Query(value = "rho") Double rho,
                                @Query(value = "degrees") Integer degrees,
                                @Query(value = "threshold") Integer threshold);

    }
}
