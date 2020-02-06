package com.sttnf.limakel3.activity.editor;

public interface EditorView {
    void showProgress();
    void hideProgress();
    void onAddSuccess(String message);
    void onAddError(String message);
}
