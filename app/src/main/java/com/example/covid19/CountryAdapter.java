package com.example.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    private List<CountryModel> countries;
    private Context context;


    public CountryAdapter(List<CountryModel> countries,Context context){
        this.countries=countries;
        this.context=context;
    }


    @NonNull
    @Override
    public CountryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        return new MyViewHolder( mView );
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.MyViewHolder holder, int position) {

        holder.country.setText( countries.get( position ).getCounry() );
        Glide.with( context ).load( countries.get( position ).getFlag() ).into( holder.flag );

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView flag;
        private TextView country;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            flag=itemView.findViewById( R.id.country_item_image );
            country=itemView.findViewById( R.id.country_item_country_name );
        }
    }


}
