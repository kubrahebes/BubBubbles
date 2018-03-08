package com.example.user.bubbubbles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SonucActivity extends AppCompatActivity {
    int sayaca, sayacb, sayacd, sayacc;
    @BindView(R.id.sonuctxt)
    TextView sonucText;
    @BindView(R.id.anaSayfaDon)

    Button anasayfayaDon;
    @BindView(R.id.image)
    ImageView icon;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String secilenKategori;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        secilenKategori = intent.getStringExtra("kategori");

        pref = SonucActivity.this.getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        sayaca = pref.getInt("SayacA", 0);
        sayacb = pref.getInt("SayacB", 0);
        sayacc = pref.getInt("SayacC", 0);
        sayacd = pref.getInt("SayacD", 0);
        int dizi[] = {sayaca, sayacb, sayacc, sayacd};
        // Toast.makeText(this, ""+dizi[1], Toast.LENGTH_SHORT).show();
        if (secilenKategori.equals("meslek")) {
            if (sayaca > sayacb && sayaca > sayacc && sayaca > sayacd) {
                sonucText.setText(R.string.avukat);
                icon.setBackgroundResource(R.drawable.avukat);
            } else if (sayacb > sayaca && sayacb > sayacc && sayacb > sayacd) {
                sonucText.setText(R.string.bilimAdami);
                icon.setBackgroundResource(R.drawable.doktor);
            } else if (sayacc > sayaca && sayacc > sayacb && sayacc > sayacd) {
                sonucText.setText(R.string.girisimci);
            } else if (sayacd > sayaca && sayacd > sayacb && sayacd > sayacc) {
                sonucText.setText(R.string.muhendis);
                icon.setBackgroundResource(R.drawable.muhendis);

            } else if (sayaca == 0 & sayacb == 0 && sayacc == 0 && sayacd == 0) {
                sonucText.setText("Testi Cozmedin :/");
            }
        } else if (sayaca == sayacb) {
            sonucText.setText(R.string.doktor);
        } else if (sayaca == sayacc) {
            sonucText.setText(R.string.ogretmen);
        }
        else if (secilenKategori.equals("superKahraman")) {
            if (sayaca > sayacb && sayaca > sayacc && sayaca > sayacd) {
                sonucText.setText("Moana");
            } else if (sayacb > sayaca && sayacb > sayacc && sayacb > sayacd) {
                sonucText.setText("Elsa");
            } else if (sayacc > sayaca && sayacc > sayacb && sayacc > sayacd) {
                sonucText.setText("Pamuk Prenses ");
            } else {
                sonucText.setText("Elena");
            }
        } else if (sayaca == 0 & sayacb == 0 && sayacc == 0 && sayacd == 0) {
            sonucText.setText("Testi Cozmedin :/");
        } else if (sayaca == sayacb) {
            sonucText.setText("");
        } else if (sayaca == sayacc) {

        } else if (sayacd == sayacc) {

        }


        Toast.makeText(this, "" + dizi[0], Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.anaSayfaDon)
    public void onViewClicked() {

        Intent intent = new Intent(SonucActivity.this, AnasayfaActivity.class);
        startActivity(intent);
    }
}
