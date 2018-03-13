package com.example.user.bubbubbles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LetStartActivity extends AppCompatActivity {
    String gecis;
    @BindView(R.id.basla)
    Button basla;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_let_start);
        ButterKnife.bind(this);
        pref = LetStartActivity.this.getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        editor.putInt("SayacA",0);
        editor.putInt("SayacB",0);
        editor.putInt("SayacC",0);
        editor.putInt("SayacD",0);
        editor.commit();

    }

    @OnClick(R.id.basla)
    public void onViewClicked() {
        String gelenKategori = getKategori();
        Intent intent = new Intent(LetStartActivity.this, TestScreenActivity.class);
        intent.putExtra("secilenKategori", gelenKategori);
        startActivity(intent);
        finish();
    }

    public String getKategori() {
        Intent intent = getIntent();
        final String secilenKategori = intent.getStringExtra("kategori");
        if (secilenKategori.equals("meslek")) {
            gecis = "meslek";

        } else if (secilenKategori.equals("superKahraman")) {
            gecis = "superKahraman";

        } else {
            gecis = "kiz";
        }
        return gecis;
    }
}
