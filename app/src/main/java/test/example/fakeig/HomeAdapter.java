package test.example.fakeig;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Viewholder> {

    Context context;
    ArrayList<SnapModel> snapModels = new ArrayList<>();

    public HomeAdapter(Context context, ArrayList<SnapModel> snapModels) {
        this.context = context;
        this.snapModels = snapModels;
    }

    public ArrayList<SnapModel> getSnapModels() {
        return snapModels;
    }

    public void setSnapModels(ArrayList<SnapModel> snapModels) {
        this.snapModels = snapModels;
    }

    @NonNull
    @Override
    public HomeAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(context).inflate(R.layout.snap_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.Viewholder holder, int position) {
        SnapModel model = snapModels.get(position);

        int imageId = getImagesId(model.getImages());
        holder.name.setText(model.getName());
        Glide.with(context).load(imageId).into(holder.profile);
    }

    private int getImagesId(String url) {
        return context.getResources().getIdentifier(url, "drawable", context.getOpPackageName());
    }

    @Override
    public int getItemCount() {
        return snapModels.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView profile;
        TextView name;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profile_item);
            name = itemView.findViewById(R.id.name_item);
        }
    }
}
