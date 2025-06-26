package com.example.challenge4;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SportsAdapter adapter;
    private List<Sport> sportsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        initData();
        setupRecyclerView();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void initData() {
        sportsList = new ArrayList<>();
        // Thêm dữ liệu các môn thể thao (sử dụng drawable icons mặc định)
        sportsList.add(new Sport("Football", R.drawable.ic_sports_football));
        sportsList.add(new Sport("Basketball", R.drawable.ic_sports_basketball));
        sportsList.add(new Sport("Tennis", R.drawable.ic_sports_tennis));
        sportsList.add(new Sport("Soccer", R.drawable.ic_sports_soccer));
        sportsList.add(new Sport("Baseball", R.drawable.ic_sports_baseball));
        sportsList.add(new Sport("Golf", R.drawable.ic_sports_golf));
        sportsList.add(new Sport("Volleyball", R.drawable.ic_sports_volleyball));
        sportsList.add(new Sport("Hockey", R.drawable.ic_sports_hockey));
        sportsList.add(new Sport("Cricket", R.drawable.ic_sports_cricket));
        sportsList.add(new Sport("Rugby", R.drawable.ic_sports_rugby));
        sportsList.add(new Sport("Swimming", R.drawable.ic_pool));
        sportsList.add(new Sport("Running", R.drawable.ic_directions_run));
    }

    private void setupRecyclerView() {
        adapter = new SportsAdapter(this, sportsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}