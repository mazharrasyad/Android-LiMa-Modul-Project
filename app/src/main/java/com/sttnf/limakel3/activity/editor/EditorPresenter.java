package com.sttnf.limakel3.activity.editor;

import androidx.annotation.NonNull;

import com.sttnf.limakel3.api.ApiClient;
import com.sttnf.limakel3.api.ApiInterface;
import com.sttnf.limakel3.model.Project;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorPresenter {
    private EditorView view;

    public EditorPresenter(EditorView view) {
        this.view = view;
    }

    void saveProject(final String nama, final String deskripsi, final String tanggal_mulai, final String tanggal_akhir,
                             final String jumlah_sprint, final String budget, final String status, final String persen,
                             final String semester_id, final String scrummaster_id, final String tim_id, final String created_by){
        view.showProgress();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Project> call = apiInterface.saveProject(nama, deskripsi, tanggal_mulai, tanggal_akhir,
                jumlah_sprint, budget, status, persen, semester_id, scrummaster_id, tim_id, created_by);

        call.enqueue(new Callback<Project>() {
            @Override
            public void onResponse(@NonNull Call<Project> call, @NonNull Response<Project> response) {
                view.hideProgress();

                if(response.isSuccessful()){
                    Boolean success = response.body().getSuccess();
                    if(success){
                        view.onAddSuccess(response.body().getMessage());
                    } else {
                        view.onAddError(response.body().getMessage());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Project> call, @NonNull Throwable t) {
                view.hideProgress();
                view.onAddError(t.getLocalizedMessage());
            }
        });
    }
}
