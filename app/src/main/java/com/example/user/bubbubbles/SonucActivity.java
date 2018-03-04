package com.example.user.bubbubbles;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SonucActivity extends AppCompatActivity {
    int sayaca, sayacb, sayacd, sayacc;
    @BindView(R.id.sonuctxt)
    TextView sonucText;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        ButterKnife.bind(this);
        pref = SonucActivity.this.getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        sayaca = pref.getInt("SayacA", 0);
        sayacb = pref.getInt("SayacB", 0);
        sayacc = pref.getInt("SayacC", 0);
        sayacd = pref.getInt("SayacD", 0);
        int dizi[]={sayaca,sayacb,sayacc,sayacd};
       // Toast.makeText(this, ""+dizi[1], Toast.LENGTH_SHORT).show();


        Toast.makeText(this, ""+dizi[0], Toast.LENGTH_SHORT).show();
    }
}
