package jp.ac.asojuku.st.familyapps;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class RouletteAdapter extends RecyclerView.Adapter<RouletteViewHolder> {
    private ArrayList<RouletteData> rouletteDataSet;
    private Activity activity;

    public RouletteAdapter(ArrayList<RouletteData> roulette, Activity activity) {
        this.activity = activity;
        this.rouletteDataSet = roulette;
    }
    //新しいViewを作成する
    //レイアウトマネージャーにより起動される
    @Override
    public RouletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //parentはRecyclerView
        //public View inflate (int resource, ViewGroup root, boolean attachToRoot)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);

        return new RouletteViewHolder(view);
    }
    //Viewの内容を交換する（リサイクルだから）
    //レイアウトマネージャーにより起動される
    @Override
    public void onBindViewHolder(final RouletteViewHolder holder, final int listPosition) {

        holder.textViewComment.setText(rouletteDataSet.get(listPosition).getComment());
        holder.base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("mailto:zigbee3608@gmail.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT,"今日の朝ごはん");
                intent.putExtra(Intent.EXTRA_TEXT,rouletteDataSet.get(listPosition).getComment());
                activity.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return rouletteDataSet.size();
    }

}

