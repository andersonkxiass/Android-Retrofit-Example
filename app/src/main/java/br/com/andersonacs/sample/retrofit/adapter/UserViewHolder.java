package br.com.andersonacs.sample.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.andersonacs.sample.retrofit.R;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by andersonacs on 14/03/15.
 */
public class UserViewHolder extends RecyclerView.ViewHolder {


    @InjectView(R.id.txt_user_name)
    TextView textViewUserName;
    @InjectView(R.id.txt_user_id)
    TextView textViewUserId;
    @InjectView(R.id.txt_date_created)
    TextView textViewUserDateCreated;

    public UserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
