package com.websarva.wings.android.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.*;

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

        //画面部品ListViewを取得
        ListView lvMenu = findViewById(R.id.lvMenu);
        //SimpleAdapterで使用するListオブジェクトを用意
        List<Map<String, String>> menuList = new ArrayList<>();
        //「唐揚げ定食」のデータを格納する Mapオブジェクトの用意とmenuListへの格納
        Map<String, String> menu = new HashMap<>();
        menu.put("name", "唐揚げ定食");
        menu.put("price", "800円");
        menuList.add(menu);

        //「ハンバーグ定食」のデータを格納する Mapオブジェクトの用意とmenuListへの格納
        menu = new HashMap<>();
        menu.put("name", "ハンバーグ");
        menu.put("price", "850円");
        menuList.add(menu);

        //「生姜焼き定食」のデータを格納する Mapオブジェクトの用意とmenuListへの格納
        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", "850円");
        menuList.add(menu);

        //SimpleAdapter第４引数from用データの用意
        String[] from = {"name", "price"};
        //SimpleAdapter第５引数to用データの用意
        int[] to = {android.R.id.text1, android.R.id.text2};
        //SimpleAdapterを生成
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, menuList, android.R.layout.simple_list_item_2, from, to);
        //アダプタの登録
        lvMenu.setAdapter(adapter);

        //リストタップのリスナクラス登録
        lvMenu.setOnItemClickListener(new listItemClickListener());
    }

    //リストがタップされたときの処理が記述されたメンバクラス
    private class listItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //タップされた行のデータを取得。SimpleAdapterでは１行分のデータはMap型
            Map<String, String> menu = (Map<String, String>) parent.getItemAtPosition(position);
            //定食名と金額を取得
            String menuName = menu.get("name");
            String menuPrice = menu.get("price");
            //インテントオブジェクトを生成
            Intent intent = new Intent(MainActivity.this, MenuThanksActivity.class);
            //第２画面に送るデータを格納
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice);
            //第２画面の起動
            startActivity(intent);
        }
    }
}