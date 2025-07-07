package com.websarva.wings.android.helloandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        //ListViewオブジェクトを取得
        ListView lvMenu = findViewById(R.id.lvMenu);
        //ListViewにリスナを設定
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    //リストがタップされたときの処理が記述されたメンバクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //タップされた定食名を取得
            String item = (String) parent.getItemAtPosition(position);
            //トーストで表示する文字列を生成
            String show = "あなたが選んだ定食：" + item;
            //トーストの表示
            Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
        }
    }
}