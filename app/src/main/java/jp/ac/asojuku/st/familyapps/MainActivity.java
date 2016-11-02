package jp.ac.asojuku.st.familyapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardList);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llManager = new LinearLayoutManager(this);

        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llManager);

        ArrayList<RouletteData> roulette = new ArrayList<RouletteData>();
        for (int i = 0; i < MenuData.commentArray.length; i++) {
            roulette.add(new RouletteData(
                    MenuData.commentArray[i]
            ));
        }

        final RecyclerView.Adapter adapter = new RouletteAdapter(roulette, this);
        recyclerView.setAdapter(adapter);
        recyclerView.smoothScrollToPosition(roulette.size() - 1);

    }
}