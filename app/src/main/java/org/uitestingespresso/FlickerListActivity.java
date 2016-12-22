package org.uitestingespresso;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import org.uitestingespresso.adapter.FlickerListAdapter;
import org.uitestingespresso.model.FlickerResponse;
import org.uitestingespresso.testing.SimpleIdlingResource;
import org.uitestingespresso.utils.ApiInterface;
import org.uitestingespresso.utils.RetrofitAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickerListActivity extends AppCompatActivity {

    ArrayList<FlickerResponse.ItemsBean> itemsBeanArrayList=new ArrayList<>();
    TextView title;
    RecyclerView listView;
    FlickerListAdapter flickerListAdapter;

    // The Idling Resource which will be null in production.
    @Nullable
    private SimpleIdlingResource mIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        setContentView(R.layout.activity_flicker_list);
        title=(TextView) findViewById(R.id.title);
        listView=(RecyclerView)findViewById(R.id.photoList);

        flickerListAdapter=new FlickerListAdapter(getApplicationContext(),itemsBeanArrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(linearLayoutManager);
        listView.setAdapter(flickerListAdapter);
        ApiInterface apiInterface= RetrofitAdapter.getApiService();
        Call<FlickerResponse> flickerResponseCall=apiInterface.getFlikerImages("mount,rainier","any","json");
        mIdlingResource.setIdleState(false);
        flickerResponseCall.enqueue(new Callback<FlickerResponse>() {
            @Override
            public void onResponse(Call<FlickerResponse> call, Response<FlickerResponse> response) {
                itemsBeanArrayList.addAll(response.body().getItems());
                flickerListAdapter.notifyDataSetChanged();
                mIdlingResource.setIdleState(true);
            }

            @Override
            public void onFailure(Call<FlickerResponse> call, Throwable t) {
                Toast.makeText(FlickerListActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Only called from test, creates and returns a new {@link SimpleIdlingResource}.
     */

    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }
}
