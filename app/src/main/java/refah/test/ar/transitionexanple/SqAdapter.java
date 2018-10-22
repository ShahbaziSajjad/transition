package refah.test.ar.transitionexanple;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class SqAdapter extends RecyclerView.Adapter<SqAdapter.ViewHolder> {
    private List<RespinseData> data;
    private Context context;


    public SqAdapter(Context context) {
        this.data = new ArrayList<>();
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));
        this.data.add(new RespinseData("http://www.planwallpaper.com/static/images/kartandtinki1_photo-wallpapers_02.jpg","deed"));

        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position<this.data.size()){
            return 1;
        }else {
            return 2;
        }
    }

    @Override
    public SqAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sq_item, null);
            ButterKnife.bind(this,view);
            return new SqAdapter.ViewHolder(view,viewType);
        }else {
            View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.sq_load_more, null);
            ButterKnife.bind(this,view1);
            return new SqAdapter.ViewHolder(view1,viewType);
        }

    }

    @Override
    public void onBindViewHolder(SqAdapter.ViewHolder holder, int position) {
        if (holder.viewType==1) {
            holder.name.setText(data.get(position).getTitle());
            Glide.with(context)
                    .load(data.get(position).getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.image);
        }else {
            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
            anim.setDuration(1000);
            anim.setRepeatCount(0);
            anim.setRepeatMode(Animation.REVERSE);
            holder.image.startAnimation(anim);
        }
    }

    @Override
    public int getItemCount() {
        return (data.size() + 1);
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        int viewType;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            this.viewType=viewType;
            if (viewType==1) {
                name = ButterKnife.findById(itemView, R.id.name);
            }
            image = ButterKnife.findById(itemView, R.id.image);
        }
    }


}