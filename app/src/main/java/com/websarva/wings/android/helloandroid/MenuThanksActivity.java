package com.websarva.wings.android.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_thanks);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //インテントオブジェクトを取得
        Intent intent = getIntent();
        //リスト画面から渡されたデータを取得
        String menuName = intent.getStringExtra("menuName");
        String menuPrice = intent.getStringExtra("menuPrice");
        //定食名と金額を表示させるTextViewを取得
        TextView tvMenuName = findViewById(R.id.tvMenuName);
        TextView tvMenuPrice = findViewById(R.id.tvMenuPrice);
        //TextViewに定食名と金額を表示
        tvMenuName.setText(menuName);
        tvMenuPrice.setText(menuPrice);
    }

    //戻るボタンをタップしたときの処理
    public void onBackButtonClick(View view) {
        finish();
    }
}