package br.com.andersonacs.sample.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.andersonacs.sample.retrofit.R;
import br.com.andersonacs.sample.retrofit.model.User;

/**
 * Created by andersonacs on 14/03/15.
 */
public class UserAdapter  extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> mListUser = new ArrayList<>();

    public UserAdapter(List<User> mListUser) {
        this.mListUser = mListUser;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.itam_contacts, viewGroup, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        User user = mListUser.get(position);

        holder.textViewUserId.setText("".concat(user.getObjectId()));
        holder.textViewUserName.setText("".concat(user.getUsername()));
        holder.textViewUserDateCreated.setText("".concat(user.getCreatedAt()));
    }

    @Override
    public int getItemCount() {
        return this.mListUser.size();
    }
}