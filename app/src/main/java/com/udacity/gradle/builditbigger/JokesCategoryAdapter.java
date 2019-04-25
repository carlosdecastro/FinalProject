package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;


//The adapter for the recyclerView

public class JokesCategoryAdapter extends RecyclerView.Adapter<JokesCategoryAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ListItemClickListener mOnClickListener;


    //The listener returns the category clicked
    public interface ListItemClickListener {
        void onListItemClick (String clickedCategory);
    }

    public JokesCategoryAdapter(Context context, List<String> data, ListItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mOnClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.joke_category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.categoryIcon.setImageResource(getCategoryJokeIcon(mData.get(position)));
        holder.categoryText.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    //Select the icon for each category
    private int getCategoryJokeIcon(String category) {

        switch (category) {
            case "ANIMALS":
                return R.drawable.ic_category_one;
            case "MUSICIANS":
                return R.drawable.ic_category_two;
            case "KIDS":
                return R.drawable.ic_category_three;
            case "DOCTORS":
                return R.drawable.ic_category_four;
            case "KNOCKKNOCK":
                return R.drawable.ic_category_five;
            case "MARRIAGE":
                return R.drawable.ic_category_six;

        }

        return R.drawable.ic_category_one;

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView categoryIcon;
        private TextView categoryText;

        ViewHolder(View itemView) {
            super(itemView);
            categoryIcon = itemView.findViewById(R.id.ivIcon);
            categoryText = itemView.findViewById(R.id.tvCategory);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(mData.get(clickedPosition));
        }
    }

}

