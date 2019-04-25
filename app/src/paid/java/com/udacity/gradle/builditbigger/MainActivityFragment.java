package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokesCategoryAdapter.ListItemClickListener {

    private ProgressBar progressBar;
    private Context context;
    private RecyclerView categoryRV;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        context = root.getContext();

        categoryRV = root.findViewById(R.id.rvJokesCategory);
        progressBar = root.findViewById(R.id.joke_progress_bar);


        // Define the categories for de paid version
        List<String> categoryData = Arrays.asList(getString(R.string.category_animals),
                getString(R.string.category_musicians),
                getString(R.string.category_kids),
                getString(R.string.category_doctors),
                getString(R.string.category_knockknock),
                getString(R.string.category_marriage));


        categoryRV.setLayoutManager(new GridLayoutManager(context, 2));

        JokesCategoryAdapter jokesCategoryAdapter = new JokesCategoryAdapter(context, categoryData, this);
        categoryRV.setAdapter(jokesCategoryAdapter);


        return root;
    }


    @Override
    public void onListItemClick(String clickedCategory) {

        categoryRV.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        new JokeAsyncTask().execute(new Pair<Context, String>(context, clickedCategory));


    }
}
