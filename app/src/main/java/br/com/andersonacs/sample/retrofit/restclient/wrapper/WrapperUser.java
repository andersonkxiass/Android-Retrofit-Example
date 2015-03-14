package br.com.andersonacs.sample.retrofit.restclient.wrapper;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.andersonacs.sample.retrofit.model.User;

/**
 * Created by anderson.acs on 3/12/2015.
 */
public class WrapperUser {

    @SerializedName(value="results")
    List<User> results;

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }
}