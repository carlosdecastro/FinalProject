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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokesCategoryAdapter.ListItemClickListener {

    private ProgressBar progressBar;
    private Context context;
    private InterstitialAd mInterstitialAd;
    private RecyclerView categoryRV;
    private JokesCategoryAdapter jokesCategoryAdapter;
    private List<String> categoryData;
    private String mCategory;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        context = root.getContext();

        categoryRV = root.findViewById(R.id.rvJokesCategory);
        progressBar = root.findViewById(R.id.joke_progress_bar);

        //Define de categories for the free version
        categoryData = Arrays.asList(getString(R.string.category_animals), getString(R.string.category_musicians), getString(R.string.category_kids), getString(R.string.category_doctors));

        categoryRV.setLayoutManager(new GridLayoutManager(context, 2));

        jokesCategoryAdapter = new JokesCategoryAdapter(context, categoryData, this);
        categoryRV.setAdapter(jokesCategoryAdapter);


        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(getString(R.string.AdUnitId));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        // When the user closes the Interstitial Ad it launches the request for retrieve a joke
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                tellJoke(mCategory);
            }
        });

        return root;
    }


    public void tellJoke(String category) {

            categoryRV.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);

            new JokeAsyncTask().execute(new Pair<Context, String>(context, category));

    }

    @Override
    public void onListItemClick(String clickedCategory) {

        mCategory = clickedCategory;

        // When the user clicks on a item the Interstitial Ad is loaded and shown
        if (mInterstitialAd.isLoaded())
            mInterstitialAd.show();

    }
}
