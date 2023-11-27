package vn.udn.vku.nmtri.handmade.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import vn.udn.vku.nmtri.handmade.R;
import vn.udn.vku.nmtri.handmade.activities.ViewAllActivity;
import vn.udn.vku.nmtri.handmade.models.PopularModel;
import vn.udn.vku.nmtri.handmade.models.RecommendedModel;

public class RecommendedAdapters extends RecyclerView.Adapter<RecommendedAdapters.ViewHolder> {
    private Context context;
    private List<RecommendedModel> recommendedModelList;

    public RecommendedAdapters(Context context, List<RecommendedModel> recommendedModelList) {
        this.context = context;
        this.recommendedModelList = recommendedModelList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Glide.with(context).load(recommendedModelList.get(position).getImg_url()).into(holder.imageView);
        holder.name.setText(recommendedModelList.get(position).getName());
        holder.description.setText(recommendedModelList.get(position).getDescription());
        holder.rating.setText(recommendedModelList.get(position).getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAllActivity.class);
                intent.putExtra("type",recommendedModelList.get(position).getType());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return recommendedModelList.size(); }

    public void setRecommendedModelList(List<PopularModel> popularModelList) {
        this.recommendedModelList = recommendedModelList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, description,rating;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.rec_img);
            name = itemView.findViewById(R.id.rec_name);
            description = itemView.findViewById(R.id.rec_des);
            rating = itemView.findViewById(R.id.rec_rating);


        }
    }
}