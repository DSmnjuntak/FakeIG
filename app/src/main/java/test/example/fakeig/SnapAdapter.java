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

public class SnapAdapter extends RecyclerView.Adapter<SnapAdapter.Viewholder> {

    Context context;
    ArrayList<SnapModel> snapModels = new ArrayList<>();

    public SnapAdapter(Context context, ArrayList<SnapModel> snapModels) {
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
    public SnapAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(context).inflate(R.layout.snap_account, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SnapAdapter.Viewholder holder, int position) {
        SnapModel model = snapModels.get(position);

        int imageId = getImagesId(model.getImages());
        holder.name.setText(model.getName());
        Glide.with(context).load(imageId).into(holder.profile);
    }

    private int getImagesId(String url) {
        return context.getResources().getIdentifier(url, "drawable", context.getPackageName());
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

            profile = itemView.findViewById(R.id.img_account_photo);
            name = itemView.findViewById(R.id.tv_account_name);
        }
    }
}
