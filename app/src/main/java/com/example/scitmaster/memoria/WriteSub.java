package com.example.scitmaster.memoria;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WriteSub extends Activity {

    DatabaseHelper databaseHelper;

    EditText txtid; //제목
    EditText edit_text;//내용
    Button save;//저장

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_activity);    //쓰기 만들기

        databaseHelper = new DatabaseHelper(this);

        txtid = (EditText) findViewById(R.id.txtid);    //제목
        edit_text = (EditText) findViewById(R.id.edit_text);    //내용
        save = (Button) findViewById(R.id.save);



        AddData();

    }
    public void AddData() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = txtid.getText().toString();
                String context = edit_text.getText().toString();
                boolean insertData;
                if (!(title.equals("")) && !(context.equals(""))) {
                     insertData = databaseHelper.addData(title, context);
                    txtid.setText("");
                    edit_text.setText("");
                    Toast.makeText(WriteSub.this, "저장 성공", Toast.LENGTH_LONG).show();
                    finish();
                } else if(title.equals("") && context.equals("")) {

                    Toast.makeText(WriteSub.this, "제목과 내용을 적어주세요", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
