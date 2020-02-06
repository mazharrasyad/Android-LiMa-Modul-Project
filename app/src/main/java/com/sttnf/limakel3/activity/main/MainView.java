package com.sttnf.limakel3.activity.main;

import com.sttnf.limakel3.model.Project;

import java.util.List;

public interface MainView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Project> projects);
    void onErrorLoading(String message);
}