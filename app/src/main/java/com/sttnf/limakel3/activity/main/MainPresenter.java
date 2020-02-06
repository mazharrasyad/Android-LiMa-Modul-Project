package com.sttnf.limakel3.activity.main;

import androidx.annotation.NonNull;

import com.sttnf.limakel3.api.ApiClient;
import com.sttnf.limakel3.api.ApiInterface;
import com.sttnf.limakel3.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }
    
    // Request to server
    void getData() {
        view.showLoading();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Project>> call = apiInterface.getProjects();
        call.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(@NonNull Call<List<Project>> call, Response<List<Project>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null){
                    view.onGetResult((response.body()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Project>> call, Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
    
}
