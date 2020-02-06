package com.sttnf.limakel3.activity.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sttnf.limakel3.R;
import com.sttnf.limakel3.model.Project;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<Project> projects;
    private ItemClickListener itemClickListener;

    public MainAdapter(Context context, List<Project> projects, ItemClickListener itemClickListener) {
        this.context = context;
        this.projects = projects;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_project,
                parent, false);

        return new RecyclerViewAdapter(view, itemClickListener);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
        Project project = projects.get(position);
        holder.tv_nama.setText(project.getNama());
        holder.tv_deskripsi.setText(project.getDeskripsi());
        holder.tv_tanggal_mulai.setText(project.getTanggal_mulai());
        holder.tv_tanggal_akhir.setText(project.getTanggal_akhir());
        holder.tv_jumlah_sprint.setText(project.getJumlah_sprint());
        holder.tv_budget.setText(project.getBudget());
        holder.tv_status.setText(project.getStatus());
        holder.tv_persen.setText(project.getPersen());
        holder.tv_semester_id.setText(project.getSemester_id());
        holder.tv_scrummaster_id.setText(project.getScrummaster_id());
        holder.tv_tim_id.setText(project.getTim_id());
        holder.tv_created_by.setText(project.getCreated_by());
        holder.card_item.setCardBackgroundColor(android.R.color.background_light);
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_nama, tv_deskripsi, tv_tanggal_mulai,
                tv_tanggal_akhir, tv_jumlah_sprint, tv_budget,
                tv_status, tv_persen, tv_semester_id,
                tv_scrummaster_id, tv_tim_id, tv_created_by;
        CardView card_item;
        ItemClickListener itemClickListener;

        RecyclerViewAdapter(View itemView, ItemClickListener itemClickListener){
            super(itemView);
            this.itemClickListener = itemClickListener;

            tv_nama = itemView.findViewById(R.id.id_nama);
            tv_deskripsi = itemView.findViewById(R.id.id_deskripsi);
            tv_tanggal_mulai = itemView.findViewById(R.id.id_tanggal_mulai);
            tv_tanggal_akhir = itemView.findViewById(R.id.id_tanggal_akhir);
            tv_jumlah_sprint = itemView.findViewById(R.id.id_jumlah_sprint);
            tv_budget = itemView.findViewById(R.id.id_budget);
            tv_status = itemView.findViewById(R.id.id_status);
            tv_persen = itemView.findViewById(R.id.id_persen);
            tv_semester_id = itemView.findViewById(R.id.id_semester_id);
            tv_scrummaster_id = itemView.findViewById(R.id.id_scrummaster_id);
            tv_tim_id = itemView.findViewById(R.id.id_tim_id);
            tv_created_by = itemView.findViewById(R.id.id_created_by);
            card_item = itemView.findViewById(R.id.card_item);

            this.itemClickListener = itemClickListener;
            card_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}