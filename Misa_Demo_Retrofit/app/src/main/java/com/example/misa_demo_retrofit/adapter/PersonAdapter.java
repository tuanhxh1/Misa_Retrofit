package com.example.misa_demo_retrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.misa_demo_retrofit.MainActivity;
import com.example.misa_demo_retrofit.R;
import com.example.misa_demo_retrofit.model.PersonPhoto;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import java.util.List;


public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private List<PersonPhoto> mListPerson;
    private Context mContext;

    public PersonAdapter(List<PersonPhoto> mListPerson, Context mContext) {
        this.mListPerson = mListPerson;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_person, viewGroup, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder personViewHolder, int i) {
        personViewHolder.tvPerson.setText(mListPerson.get(i).getmTitle());

//        Picasso.Builder builder = new Picasso.Builder(mContext);
//        builder.downloader(new OkHttp3Downloader(mContext));
//        builder.build().load(mListPerson.get(i).getmThumbnailUrl())
//                .placeholder((R.drawable.ic_launcher_background))
//                .error(R.drawable.ic_launcher_background)
//                .into(personViewHolder.imgPerson);
        Glide.with(mContext).load(mListPerson.get(i).getmThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(personViewHolder.imgPerson);
    }

    @Override
    public int getItemCount() {
        return mListPerson.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView tvPerson;
        private ImageView imgPerson;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            tvPerson = mView.findViewById(R.id.tvPerson);
            imgPerson = mView.findViewById(R.id.imgPerson);
        }
    }
}
