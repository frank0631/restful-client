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

    public static void main(String[] args) {

        try {


            String API_URL = "http://localhost:9009";
            RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
            //restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
            CVBackendService service = restAdapter.create(CVBackendService.class);

            File imgfile = new File("ocr_square/20141216_143906_432.jpg");
            TypedFile imgtyped = new TypedFile("image/jpeg", imgfile);
            String soupname = "ocr_1";

            //Create chain of calls that preprocess the OCR Image
            service.ImageUpload(soupname + ".jpg", imgtyped);
            service.blur(soupname + ".jpg", soupname + "_blur.jpg", null, null);
            service.sharp(soupname + ".jpg", soupname + "_blur.jpg", soupname + "_sharp.jpg", null, null, null);

            //service.thresh(soupname + "_sharp.jpg", soupname + "_otsu.jpg", true, null, null, true);
            service.thresh(soupname + "_sharp.jpg", soupname + "_thresh.jpg", false, 45, 30, false);
            //service.invert(soupname + "_otsu.jpg", soupname + "_otsu.jpg");
            service.invert(soupname + "_thresh.jpg", soupname + "_thresh.jpg");

            service.canny(soupname + "_thresh.jpg", soupname + "_canny.jpg", 30.0, 100.0, 3, true);
            //service.sobel(soupname + "_thresh.jpg", soupname + "_sobel.jpg", 2.0, 1.0, 0.0);
            //service.scharr(soupname + "_thresh.jpg", soupname + "_scharr.jpg", 2.0, 1.0, 0.0);

            service.scale(soupname + "_thresh.jpg",soupname + "_thumb.jpg",.33);
            service.shapes(soupname + "_thumb.jpg",soupname + "_shapes.jpg",0,100,0.001);
            //service.polar_hough(soupname + "_shapes.jpg", soupname + "_hough_polar.jpg", 2.0, 180, 200, 1);

            service.prob_hough(soupname + "_shapes.jpg", soupname + "_hough_prob.jpg", 1.0, 45, 100, 100, 50, 1);
            //service.shapes(soupname + "_hough_prob.jpg",soupname + "_refined_shapes.jpg",0,100,0.005);
            // service.find_squares(soupname + "_shapes.jpg", soupname + "_intersections.jpg",  1.0, 45, 100, 100, 40, 4, 5);


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public interface CVBackendService {

        @Multipart
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/upload/file")
        public Response FileUpload(@Part("name") String name,
                                   @Part("file") TypedFile file);

        @Multipart
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/upload/image")
        public Response ImageUpload(@Part("name") String name,
                                    @Part("file") TypedFile file);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/blur")
        public Response blur(@Field("src-img") String srcname,
                             @Field("blur-img") String blurname,
                             @Query(value = "block") Integer block,
                             @Query(value = "sigma") Integer sigma);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/sharp")
        public Response sharp(@Field("src-img") String srcname,
                              @Field("blur-img") String blurname,
                              @Field("sharp-img") String sharpname,
                              @Query(value = "alpha") Double alpha,
                              @Query(value = "beta") Double beta,
                              @Query(value = "gamma") Double gamma);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/sobel")
        public Response sobel(@Field("src-img") String srcname,
                              @Field("sobel-img") String sobelname,
                              @Query(value = "alpha") Double alpha,
                              @Query(value = "beta") Double beta,
                              @Query(value = "gamma") Double gamma);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/scharr")
        public Response scharr(@Field("src-img") String srcname,
                               @Field("scharr-img") String scharrname,
                               @Query(value = "alpha") Double alpha,
                               @Query(value = "beta") Double beta,
                               @Query(value = "gamma") Double gamma);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/thresh")
        public Response thresh(@Field("src-img") String srcname,
                               @Field("thresh-img") String threshname,
                               @Query(value = "otsu") Boolean otsu,
                               @Query(value = "block") Integer block,
                               @Query(value = "c") Integer c,
                               @Query(value = "inv") Boolean invert);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/canny")
        public Response canny(@Field("src-img") String srcname,
                              @Field("canny-img") String cannyname,
                              @Query(value = "threshold1") Double threshold1,
                              @Query(value = "threshold2") Double threshold2,
                              @Query(value = "block") Integer apertureSize,
                              @Query(value = "L2") Boolean L2Gradient);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/prob_hough")
        public Response prob_hough(@Field("src-img") String srcname,
                                   @Field("hough-img") String houghname,
                                   @Query(value = "rho") Double rho,
                                   @Query(value = "degrees") Integer degrees,
                                   @Query(value = "threshold") Integer threshold,
                                   @Query(value = "min-line-size") Integer minLineSize,
                                   @Query(value = "line-gap") Integer lineGap,
                                   @Query(value = "line-thick") Integer thickness);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/polar_hough")
        public Response polar_hough(@Field("src-img") String srcname,
                                    @Field("hough-img") String houghname,
                                    @Query(value = "rho") Double rho,
                                    @Query(value = "degrees") Integer degrees,
                                    @Query(value = "threshold") Integer threshold,
                                    @Query(value = "line-thick") Integer thickness);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/invert")
        public Response invert(@Field("src-img") String srcname,
                               @Field("inv-img") String invname);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/shapes")
        public Response shapes(@Field("src-img") String srcname,
                               @Field("shapes-img") String shapesname,
                               @Query(value = "only-sides") Integer sides,
                               @Query(value = "max-sides") Integer max,
                               @Query(value = "area-percent") Double area);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/cv/scale")
        public Response scale(@Field("src-img") String srcname,
                              @Field("scale-img") String scalename,
                              @Query(value = "percent") Double percent);

        @FormUrlEncoded
        @Headers({"X-Spring-Application-Name: cv-backend"})
        @POST("/api/find_squares")
        public Response find_squares(@Field("src-img") String srcname,
                                     @Field("hough-img") String houghname,
                                     @Query(value = "rho") Double rho,
                                     @Query(value = "degrees") Integer degrees,
                                     @Query(value = "threshold") Integer threshold,
                                     @Query(value = "min-line-size") Integer minLineSize,
                                     @Query(value = "line-gap") Integer lineGap,
                                     @Query(value = "line-thick") Integer lineThickness,
                                     @Query(value = "circle-thick") Integer circlethickness);
    }
}
