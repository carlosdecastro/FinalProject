package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import com.example.android.libjavajokesprovider.Joker;

/** An endpoint class we are exposing */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a category and send a joke back */
    @ApiMethod(name = "retrieveJoke")
    public MyBean retrieveJoke(@Named("category") String category) {
        MyBean response = new MyBean();

        Joker myJoker = new Joker();
        String joke = myJoker.getJoke(category);

        response.setData(joke);

        return response;
    }

}
