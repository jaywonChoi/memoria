package com.example.scitmaster.memoria;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EditSub extends Activity {
    EditText title;
    EditText context;
    Button save;    //수정 ->alert뜨게 하고 수정하기
    Button delete;  //삭제 -> alert
    int itemid;
    private String putTitle;
    private String putContext;
    private static final String TAG = "editcontext";

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editcontext);

        title = (EditText)findViewById(R.id.edit_title);
        context = (EditText)findViewById(R.id.edit_context);
        save = (Button)findViewById(R.id.edit_save);
        delete = (Button)findViewById(R.id.edit_delete);


        databaseHelper = new DatabaseHelper(this);

        Intent putIntent = getIntent();
        itemid = putIntent.getIntExtra("id",-1);
        Log.d(TAG,"id="+itemid);
        putTitle = putIntent.getStringExtra("title");
        putContext = putIntent.getStringExtra("context");
        Log.d(TAG,"title="+putTitle);
        Log.d(TAG,"context="+putContext);
        Log.d(TAG,"edit_title"+title);
        title.setText(putTitle);
        context.setText(putContext);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder d1 = new AlertDialog.Builder(EditSub.this);
                d1.setTitle("수정");
                d1.setMessage("수정하시겠습니까?");        //내용
                d1.setIcon(R.mipmap.alert); //아이콘

                d1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String getContext = context.getText().toString();
                        String getTitle = title.getText().toString();
                        if(!getContext.equals("")&& !getTitle.equals("")) {
                            //수정
                            databaseHelper.updateName(getTitle, getContext, itemid);
                            Intent intent = new Intent(EditSub.this,ListSub.class);
                            startActivity(intent);
                            finish();
                        }

                        else{
                            Toast.makeText(EditSub.this,"내용과 제목을 적어주세요.",Toast.LENGTH_SHORT).show();
                        }



                    }
                });//null->OnClick메소드 이벤트 처리

                d1.setNegativeButton("취소",null);
                d1.show();


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder d2 = new AlertDialog.Builder(EditSub.this);
                d2.setTitle("삭제");
                d2.setMessage("삭제하시겠습니까?");
                d2.setIcon(R.mipmap.delete_paper);

                d2.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String getContext = context.getText().toString();
                        String getTitle = title.getText().toString();
                        databaseHelper.deleteName(itemid,getTitle,getContext);
                        title.setText("");
                        context.setText("");
                        Toast.makeText(EditSub.this,"삭제가 되었습니다.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EditSub.this,ListSub.class);
                        startActivity(intent);
                        finish();
                    }
                });


                d2.setNegativeButton("취소",null);
                d2.show();
            }
        });

    }
}
