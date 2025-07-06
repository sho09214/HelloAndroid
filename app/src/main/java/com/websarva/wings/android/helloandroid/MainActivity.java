package com.websarva.wings.android.helloandroid;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // テーブルコンテナ（表示/非表示を制御する対象）
        final LinearLayout tableContainer = findViewById(R.id.tableContainer);

        // データテーブル
        final TableLayout dataTable = findViewById(R.id.dataTable);

        // サンプルデータを追加
        addSampleData(dataTable);

        // トグルボタンの設定
        Button toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 表示/非表示を切り替え
                if (tableContainer.getVisibility() == View.VISIBLE) {
                    tableContainer.setVisibility(View.GONE);
                } else {
                    tableContainer.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void addSampleData(TableLayout tableLayout) {
        // 既存のデータをクリア（必要に応じて）
        tableLayout.removeAllViews();

        // サンプルデータを追加
        for (int i = 1; i <= 20; i++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams rowParams = new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            );
            row.setLayoutParams(rowParams);

            // 交互に背景色を設定
            if (i % 2 == 0) {
                row.setBackgroundColor(Color.WHITE);
            } else {
                row.setBackgroundColor(Color.parseColor("#f8f8f8"));
            }

            // 列1
            TextView column1 = new TextView(this);
            column1.setText("データ" + i + "-1");
            TableRow.LayoutParams params1 = new TableRow.LayoutParams(
                    0,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1f
            );
            column1.setLayoutParams(params1);
            column1.setPadding(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
            row.addView(column1);

            // 列2
            TextView column2 = new TextView(this);
            column2.setText("データ" + i + "-2");
            TableRow.LayoutParams params2 = new TableRow.LayoutParams(
                    0,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1f
            );
            column2.setLayoutParams(params2);
            column2.setPadding(dpToPx(8), dpToPx(8), dpToPx(8), dpToPx(8));
            row.addView(column2);

            tableLayout.addView(row);
        }
    }

    // dpからpxへの変換メソッド
    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}
