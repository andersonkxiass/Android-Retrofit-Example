package br.com.andersonacs.sample.retrofit.restclient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by anderson.acs on 3/12/2015.
 */
public class RestClient {

    private static RestClient mRestClient = null;
    private static RestAdapter restAdapter;
    private static RequestInterceptor requestInterceptor;

    public static RestClient getInstance(){

        if(mRestClient == null ){

            mRestClient = new RestClient();
            setup();
        }

        return mRestClient;
    }

    private static void setup(){


        requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestInterceptor.RequestFacade request) {

                request.addHeader("X-Parse-Application-Id", "");
                request.addHeader("X-Parse-REST-API-Key", "");
            }
        };

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(" https://api.parse.com/1/")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(requestInterceptor)
                .build();
    }

    public RestAdapter getRestAdapter(){
        return restAdapter;
    }
}