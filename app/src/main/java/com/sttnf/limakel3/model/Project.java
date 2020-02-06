package com.sttnf.limakel3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {
    @Expose
    @SerializedName("id") private int id;
    @Expose
    @SerializedName("nama") private String nama;
    @Expose
    @SerializedName("deskripsi") private String deskripsi;
    @Expose
    @SerializedName("tanggal_mulai") private String tanggal_mulai;
    @Expose
    @SerializedName("tanggal_akhir") private String tanggal_akhir;
    @Expose
    @SerializedName("jumlah_sprint") private String jumlah_sprint;
    @Expose
    @SerializedName("budget") private String budget;
    @Expose
    @SerializedName("status") private String status;
    @Expose
    @SerializedName("persen") private String persen;
    @Expose
    @SerializedName("semester_id") private String semester_id;
    @Expose
    @SerializedName("scrummaster_id") private String scrummaster_id;
    @Expose
    @SerializedName("tim_id") private String tim_id;
    @Expose
    @SerializedName("created_by") private String created_by;
    @Expose
    @SerializedName("created_at") private String created_at;
    @Expose
    @SerializedName("updated_at") private String updated_at;
    @Expose
    @SerializedName("success") private Boolean success;
    @Expose
    @SerializedName("message") private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getTanggal_akhir() {
        return tanggal_akhir;
    }

    public void setTanggal_akhir(String tanggal_akhir) {
        this.tanggal_akhir = tanggal_akhir;
    }

    public String getJumlah_sprint() {
        return jumlah_sprint;
    }

    public void setJumlah_sprint(String jumlah_sprint) {
        this.jumlah_sprint = jumlah_sprint;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPersen() {
        return persen;
    }

    public void setPersen(String persen) {
        this.persen = persen;
    }

    public String getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(String semester_id) {
        this.semester_id = semester_id;
    }

    public String getScrummaster_id() {
        return scrummaster_id;
    }

    public void setScrummaster_id(String scrummaster_id) {
        this.scrummaster_id = scrummaster_id;
    }

    public String getTim_id() {
        return tim_id;
    }

    public void setTim_id(String tim_id) {
        this.tim_id = tim_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}