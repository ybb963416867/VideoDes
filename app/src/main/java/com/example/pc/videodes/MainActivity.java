package com.example.pc.videodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button  res= (Button) findViewById(R.id.res);
        Button  des= (Button) findViewById(R.id.des);
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Log.e("ybb",getInnerSDCardPath());
//                File externalStorageDirectory = Environment.getExternalStorageDirectory();
//                File[] files = externalStorageDirectory.listFiles(new FileFilter() {
//                    @Override
//                    public boolean accept(File pathname) {
//                        if (pathname.getName().endsWith(".mp4")){
//                            return  true;
//                        };
//                        return false;
//                    }
//                });
//                for (File file : files) {
//                    Log.e("ybb",file.getAbsolutePath()+"......"+file.getName());
//                }

               /* CustomFileCipherUtil.encrypt("/storage/emulated/0/aaaaa.mp4", new CustomFileCipherUtil.CipherListener() {
                    @Override
                    public void onProgress(long current, long total) {
                        Log.e("ybb",current+"........"+total+".........");
                    }
                });*/
                CustomFileCipherUtil.aesEncrypt("/storage/emulated/0/bbb.mp4", new CustomFileCipherUtil.CipherListener() {
                    @Override
                    public void onProgress(long current, long total) {
                        Log.e("ybb",current+"....."+total);
                        if (current==total-1)
                            Toast.makeText(MainActivity.this,"加密成功",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                CustomFileCipherUtil.decrypt("/storage/emulated/0/aaaaa.mp4", new CustomFileCipherUtil.CipherListener() {
//                    @Override
//                    public void onProgress(long current, long total) {
//                        Log.e("ybb",current+"........"+total+".........");
//                    }
//                });

                CustomFileCipherUtil.desCrypt("/storage/emulated/0/bbb.mp4", new CustomFileCipherUtil.CipherListener() {
                    @Override
                    public void onProgress(long current, long total) {
                        Log.e("ybb",current+"....."+total);
                        if (current==total-1)
                            Toast.makeText(MainActivity.this,"解密成功",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

//    public String getInnerSDCardPath() {
//        return ;
//    }
}
