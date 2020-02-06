package com.sttnf.limakel3.activity.editor;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.sttnf.limakel3.R;
import com.sttnf.limakel3.api.ApiClient;
import com.sttnf.limakel3.api.ApiInterface;
import com.sttnf.limakel3.model.Project;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorActivity extends AppCompatActivity implements EditorView {
    EditText et_nama, et_deskripsi, et_tanggal_mulai, et_tanggal_akhir,
        et_jumlah_sprint, et_budget, et_status, et_persen, et_semester_id,
            et_scrummaster_id, et_tim_id, et_created_by;

    ProgressDialog progressDialog;
    ApiInterface apiInterface;

    EditorPresenter presenter;

//    SpectrumPalette palette;
//    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        et_nama = findViewById(R.id.id_nama);
        et_deskripsi = findViewById(R.id.id_deskripsi);
        et_tanggal_mulai = findViewById(R.id.id_tanggal_mulai);
        et_tanggal_akhir = findViewById(R.id.id_tanggal_akhir);
        et_jumlah_sprint = findViewById(R.id.id_jumlah_sprint);
        et_budget = findViewById(R.id.id_budget);
        et_status = findViewById(R.id.id_status);
        et_persen = findViewById(R.id.id_persen);
        et_semester_id = findViewById(R.id.id_semester_id);
        et_scrummaster_id = findViewById(R.id.id_scrummaster_id);
        et_tim_id = findViewById(R.id.id_tim_id);
        et_created_by = findViewById(R.id.id_created_by);

//        palette = findViewById(R.id.palette);
//
//        palette.setOnColorSelectedListener(
//                clr -> color = clr
//        );
//
////      Default Color Setup
//        palette.setSelectedColor(getResources().getColor(R.color.white));
//        color = getResources().getColor(R.color.white);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        presenter = new EditorPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.save:
                //Save

                String nama = et_nama.getText().toString().trim();
                String deskripsi = et_deskripsi.getText().toString().trim();
                String tanggal_mulai = et_tanggal_mulai.getText().toString().trim();
                String tanggal_akhir = et_tanggal_akhir.getText().toString().trim();
                String jumlah_sprint = et_jumlah_sprint.getText().toString().trim();
                String budget = et_budget.getText().toString().trim();
                String status = et_status.getText().toString().trim();
                String persen = et_persen.getText().toString().trim();
                String semester_id = et_semester_id.getText().toString().trim();
                String scrummaster_id = et_scrummaster_id.getText().toString().trim();
                String tim_id = et_tim_id.getText().toString().trim();
                String created_by = et_created_by.getText().toString().trim();
//                int color = this.color;

                if(nama.isEmpty()){
                    et_nama.setError("Tolong masukkan nama");
                } else if(deskripsi.isEmpty()){
                    et_deskripsi.setError("Tolong masukkan deskripsi");
                } else if(tanggal_mulai.isEmpty()){
                    et_tanggal_mulai.setError("Tolong masukkan tanggal mulai");
                } else if(tanggal_akhir.isEmpty()){
                    et_tanggal_akhir.setError("Tolong masukkan tanggal akhir");
                } else if(jumlah_sprint.isEmpty()){
                    et_jumlah_sprint.setError("Tolong masukkan jumlah sprint");
                } else if(budget.isEmpty()){
                    et_budget.setError("Tolong masukkan budget");
                } else if(status.isEmpty()){
                    et_status.setError("Tolong masukkan status");
                } else if(persen.isEmpty()){
                    et_persen.setError("Tolong masukkan persen");
                } else if(semester_id.isEmpty()){
                    et_semester_id.setError("Tolong masukkan semester");
                } else if(scrummaster_id.isEmpty()){
                    et_scrummaster_id.setError("Tolong masukkan scrummaster");
                } else if(tim_id.isEmpty()){
                    et_tim_id.setError("Tolong masukkan tim");
                } else if(created_by.isEmpty()){
                    et_created_by.setError("Tolong masukkan created by");
                } else {
                    presenter.saveProject(nama, deskripsi, tanggal_mulai, tanggal_akhir,
                            jumlah_sprint, budget, status, persen, semester_id, scrummaster_id, tim_id, created_by);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void onAddSuccess(String message) {
        Toast.makeText(EditorActivity.this,
                message,
                Toast.LENGTH_SHORT).show();
        finish(); // back to main activity
    }

    @Override
    public void onAddError(String message) {
        Toast.makeText(EditorActivity.this,
                message,
                Toast.LENGTH_SHORT).show();
        // if error, still in this act
    }
}
