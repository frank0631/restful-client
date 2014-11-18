package com.augmate.jersey;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public final class JerseyDF {

    public static void main(final String[] args) {


        //Jersey
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://dreamfactory.frank0631.bitnamiapp.com/rest");
        WebTarget resourceWebTarget  = target.path("triva");
        WebTarget userWebTarget  = target.path("user");

        Invocation.Builder invocationBuilder;
        invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON);
        invocationBuilder.header("X-DreamFactory-Application-Name ", "triva");

        Response response = invocationBuilder.get();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

}