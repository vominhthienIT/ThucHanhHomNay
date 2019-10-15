package com.example.student.minhthien_tuan03;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_themtacgia,btn_danhsach,btn_quanlysach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
        evt_ClickThem();
    }

    private void connect() {
        btn_themtacgia=(Button)findViewById(R.id.btn_themtacgia);
        btn_danhsach=(Button)findViewById(R.id.btn_danhsach);
        btn_quanlysach=(Button)findViewById(R.id.btn_quanlysach);
    }

    private void evt_ClickThem() {
        btn_themtacgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alertdialog=new AlertDialog.Builder(MainActivity.this);
                final TextView tv_tentgia = new TextView(MainActivity.this);
                final EditText edit_tentacgia = new EditText(MainActivity.this);
                final TextView tv_matacgia = new TextView(MainActivity.this);
                final EditText edit_matacgia = new EditText(MainActivity.this);

                final LinearLayout linearLayoutAll=new LinearLayout(MainActivity.this);
                LinearLayout.LayoutParams paramsAll = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                linearLayoutAll.setLayoutParams(paramsAll);
                linearLayoutAll.setOrientation(LinearLayout.VERTICAL);

                final LinearLayout linearLayout=new LinearLayout(MainActivity.this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                linearLayout.setLayoutParams(params);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);


                final LinearLayout linearLayout2=new LinearLayout(MainActivity.this);
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                linearLayout2.setLayoutParams(params2);
                linearLayout2.setOrientation(LinearLayout.HORIZONTAL);

                tv_matacgia.setText("Mã tác giả:");
                tv_matacgia.setTextSize(20);
                tv_tentgia.setText("Tên tác giả");
                tv_tentgia.setTextSize(20);

                linearLayout2.addView(tv_matacgia);
                linearLayout2.addView(edit_matacgia);
                linearLayout.addView(tv_tentgia);
                linearLayout.addView(edit_tentacgia);

                linearLayoutAll.addView(linearLayout);
                linearLayoutAll.addView(linearLayout2);

                alertdialog.setView(linearLayoutAll);
                alertdialog.setTitle("Thêm Mới Tác Giả");
                alertdialog.setNegativeButton("Xóa Trắng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edit_matacgia.setText("");
                        edit_tentacgia.setText("");
                    }
                });
                alertdialog.setPositiveButton("Lưu tác giả", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (edit_matacgia.getText().toString().equalsIgnoreCase("")||edit_tentacgia.getText().toString().equalsIgnoreCase("")){
                            Toast.makeText(MainActivity.this,"Lưu không thành công",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(MainActivity.this,"Lưu thành công",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alertdialog.show();

            }
        });
    }
}
