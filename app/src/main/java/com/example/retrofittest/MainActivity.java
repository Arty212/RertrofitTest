package com.example.retrofittest;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.retrofittest.API.model.DeputyModelResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView mList;
    private SwipeRefreshLayout mSwipe;
    private ArrayAdapter<DeputyModelResponse> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = findViewById(R.id.list);
        mAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        mList.setAdapter(mAdapter);

        mSwipe = findViewById(R.id.swipe);
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadDeputy();
            }
        });

        loadDeputy();
    }

    private void loadDeputy() {
        mSwipe.setRefreshing(true);
        Call<List<DeputyModelResponse>> call = DataManager.getInstance().getDeputy(false);
        call.enqueue(new Callback<List<DeputyModelResponse>>() {
            @Override
            public void onResponse(Call<List<DeputyModelResponse>> call, Response<List<DeputyModelResponse>> response) {
                mSwipe.setRefreshing(false);
                if (response.body() != null) {
                    mAdapter.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<DeputyModelResponse>> call, Throwable t) {
                mSwipe.setRefreshing(false);
                ShowSnackbar("Что-то пошло не так.... =(((((");
            }
        });
    }

    private void ShowSnackbar(String text) {
        Snackbar.make(mList, text, Snackbar.LENGTH_LONG).show();
    }


}
