package com.example.scitmaster.memoria;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String str[] = {"◆ Number Game", "◆ Check PlayCard"};
    int check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = 0;
        if(check == 0) {
            startActivity(new Intent(this, Splash.class));
        }
        check = 1;
    }


    //클릭리스너
    public void ClickListener(View v){
        switch (v.getId()){
            case R.id.write:
                //클릭 후 내용 쓰기로 이동하기
                Intent intent = new Intent(this,WriteSub.class);
                startActivity(intent);
                break;
            case R.id.list:
                //클릭 후 리스트 보여지기
                Intent intent1 = new Intent(this,ListSub.class);
                startActivity(intent1);
                break;
            case R.id.game:
                //게임을 누르면 게임 2개가 있는 sub페이지로

               final AlertDialog.Builder d1 = new AlertDialog.Builder(this);
               d1.setTitle("다음 게임목록 중 선택해주세요");

               d1.setItems(str, new DialogInterface.OnClickListener() {         //리스트로 보여줌
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       switch (i){
                           case 0:
                               Toast.makeText(MainActivity.this,"◆ Number Game",Toast.LENGTH_SHORT).show();
                               Intent intent2 = new Intent(MainActivity.this,GameSub.class);
                               startActivity(intent2);
                               break;
                           case 1:
                               Toast.makeText(MainActivity.this,"◆ Check PlayCard",Toast.LENGTH_SHORT).show();
                               Intent intent4 = new Intent(MainActivity.this,GameSub2.class);
                               startActivity(intent4);
                               break;
                       }
                   }
               });
               d1.setNegativeButton("취소",null);
               d1.show();
                break;
            case R.id.video:
                Intent intent3 = new Intent(this,Videosub.class);
                startActivity(intent3);
                break;



        }
    }
}
