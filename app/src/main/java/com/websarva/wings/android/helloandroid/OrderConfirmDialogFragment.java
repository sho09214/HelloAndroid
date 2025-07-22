package com.websarva.wings.android.helloandroid;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class OrderConfirmDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState){
        //ダイアログビルダーを生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログのタイトルを設定
        builder.setTitle(R.string.dialog_title);
        //ダイアログのメッセージを設定
        builder.setMessage(R.string.dialog_msg);
        //Positive Buttonを設定
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        //Negative Buttonを設定
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        //Neutral Buttonを設定
        builder.setNeutralButton(R.string.dialog_btn_nu, new DialogButtonClickListener());
        //ダイアログオブジェクトを生成し、リターン
        AlertDialog dialog = builder.create();
        return dialog;
    }

    //ダイアログのアクションボタンがタップされたときの処理が記述されたメンバクラス
    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //トーストメッセージ用文字列変数を用意
            String msg = "";
            //タップされたアクションボタンで分岐
            switch (which) {
                //Positive Buttonの場合
                case DialogInterface.BUTTON_POSITIVE:
                    //注文用メッセージを格納
                    msg = getString(R.string.dialog_ok_toast);
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    //キャンセル用のメッセージを格納
                    msg = getString(R.string.dialog_ng_toast);
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    msg = getString(R.string.dialog_nu_toast);
                    break;
            }
            //トースト表示
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}

