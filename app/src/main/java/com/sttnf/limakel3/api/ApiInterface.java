package com.sttnf.limakel3.api;

import com.sttnf.limakel3.model.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("save.php")
    Call<Project> saveProject(
            @Field("nama") String nama,
            @Field("deskripsi") String deskripsi,
            @Field("tanggal_mulai") String tanggal_mulai,
            @Field("tanggal_akhir") String tanggal_akhir,
            @Field("jumlah_sprint") String jumlah_sprint,
            @Field("budget") String budget,
            @Field("status") String status,
            @Field("persen") String persen,
            @Field("semester_id") String semester_id,
            @Field("scrummaster_id") String scrummaster_id,
            @Field("tim_id") String tim_id,
            @Field("created_by") String created_by
    );

    @GET("projects.php")
    Call<List<Project>> getProjects();
}