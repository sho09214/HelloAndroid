package com.websarva.wings.android.helloandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

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
        //リストビューに表示するリストデータ用listオブジェクト作成
        List<String> menuList = new ArrayList<>();
        //リストデータの登録
        menuList.add("唐揚げ定食");
        menuList.add("ハンバーグ定食");
        menuList.add("生姜焼き定食");
        menuList.add("ステーキ定食");
        menuList.add("野菜炒め定食");
        menuList.add("とんかつ定食");
        menuList.add("ミンチカツ定食");
        menuList.add("チキンカツ定食");
        menuList.add("コロッケ定食");
        menuList.add("回鍋肉定食");
        menuList.add("麻婆豆腐定食");
        menuList.add("青椒肉絲定食");
        menuList.add("八宝菜定食");
        menuList.add("酢豚定食");
        menuList.add("豚の角煮定食");
        menuList.add("焼き鳥定食");
        menuList.add("焼き魚定食");
        menuList.add("焼き肉定食");
        //アダプタオブジェクト作成
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                menuList
        );
        //リストビューにアダプタオブジェクトを設定
        lvMenu.setAdapter(adapter);
        //リストビューにリスナを設定
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    //リストがタップされたときの処理が記述されたメンバクラス
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            //注文確認ダイアログフラグメントオブジェクトを作成
            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
            //ダイアログ表示
            dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
        }
    }
}