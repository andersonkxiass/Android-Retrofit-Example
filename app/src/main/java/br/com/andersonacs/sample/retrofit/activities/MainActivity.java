package br.com.andersonacs.sample.retrofit.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import br.com.andersonacs.sample.retrofit.R;
import br.com.andersonacs.sample.retrofit.adapter.UserAdapter;
import br.com.andersonacs.sample.retrofit.restclient.RestClient;
import br.com.andersonacs.sample.retrofit.restclient.service.ParseUserService;
import br.com.andersonacs.sample.retrofit.restclient.wrapper.WrapperUser;
import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.cardList)
    RecyclerView recList;

    ParseUserService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        recList.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .color(R.color.white)
                        .size(getResources().getDimensionPixelSize(R.dimen.divider))
                        .margin(getResources().getDimensionPixelSize(R.dimen.leftmargin),
                                getResources().getDimensionPixelSize(R.dimen.rightmargin))
                        .build());

        RestAdapter mRestAdapter =  RestClient.getInstance().getRestAdapter();

        service = mRestAdapter.create(ParseUserService.class);


        /**
         *
         * List Users OK
         */

        service.listUsers(new Callback<WrapperUser>() {

            @Override
            public void success(WrapperUser users, Response response) {

                UserAdapter userAdapter = new UserAdapter(users.getResults());
                recList.setAdapter(userAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
            }
        });
    }
}
