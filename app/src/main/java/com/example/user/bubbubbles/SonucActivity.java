package com.example.user.bubbubbles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SonucActivity extends AppCompatActivity {
    int sayaca;
    int sayacb;
    int sayacd;
    int sayacc;
    String cinsiyet;
    @BindView(R.id.sonuctxt)
    TextView sonucText;
    @BindView(R.id.anaSayfaDon)
    Button anasayfayaDon;
    @BindView(R.id.baslik)
    TextView baslik;
    @BindView(R.id.imgSonuc)
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
      //  cinsiyet = pref.getString("cinsiyet", "");
      //  Toast.makeText(this, "" + cinsiyet, Toast.LENGTH_SHORT).show();
      //  int dizi[] = {sayaca, sayacb, sayacc, sayacd};
        // Toast.makeText(this, ""+dizi[1], Toast.LENGTH_SHORT).show();
        if (secilenKategori.equals("meslek")) {
            if (sayaca > sayacb && sayaca > sayacc && sayaca > sayacd) {
                sonucText.setText(R.string.avukat);
                icon.setBackgroundResource(R.drawable.avukat);
                baslik.setText("AVUKAT");
            } else if (sayacb > sayaca && sayacb > sayacc && sayacb > sayacd) {
                sonucText.setText(R.string.bilimAdami);
                baslik.setText("BILIM ADAMI");
                icon.setBackgroundResource(R.drawable.doktor);
            } else if (sayacc > sayaca && sayacc > sayacb && sayacc > sayacd) {
                sonucText.setText(R.string.girisimci);
                icon.setBackgroundResource(R.drawable.girisimci);
                baslik.setText("GIRISIMCI");
            } else if (sayacd > sayaca && sayacd > sayacb && sayacd > sayacc) {
                sonucText.setText(R.string.muhendis);
                icon.setBackgroundResource(R.drawable.muhendis);
                baslik.setText("MUHENDIS");
            } else if (sayaca == 0 & sayacb == 0 && sayacc == 0 && sayacd == 0) {
                sonucText.setText("Testi Cozmedin :/");
                baslik.setText("");
                icon.setVisibility(View.GONE);
            } else if (sayaca == sayacb || sayacb == sayacd) {
                sonucText.setText(R.string.doktor);
                baslik.setText("DOKTOR");
                icon.setBackgroundResource(R.drawable.doktor_2);
            } else if (sayaca == sayacd || sayacc == sayacd) {
                sonucText.setText(R.string.ogretmen);
                baslik.setText("OGRETMEN");
                icon.setBackgroundResource(R.drawable.ogretmen);
            } else if (sayaca == sayacc || sayacb == sayacc) {
                sonucText.setText(R.string.muhendis);
                icon.setBackgroundResource(R.drawable.muhendis);
                baslik.setText("MUHENDIS");
            } else if (sayaca == sayacb && sayaca == sayacc || sayacc == sayacd && sayacc == sayaca) {
                sonucText.setText(R.string.bilimAdami);
                baslik.setText("BILIM ADAMI");
                icon.setBackgroundResource(R.drawable.doktor);
            } else if (sayacb == sayacc && sayacb == sayacd || sayacd == sayaca && sayacd == sayacb) {
                sonucText.setText(R.string.girisimci);
                icon.setBackgroundResource(R.drawable.girisimci);
                baslik.setText("GIRISIMCI");
            } else {
                sonucText.setText(R.string.ogretmen);
                baslik.setText("OGRETMEN");
                icon.setBackgroundResource(R.drawable.ogretmen);
            }
        } else if (secilenKategori.equals("kiz")) {


            if (sayaca > sayacb && sayaca > sayacc && sayaca > sayacd) {
                sonucText.setText(R.string.moana);
                baslik.setText("MOANA");
                icon.setBackgroundResource(R.drawable.moana);
            } else if (sayacb > sayaca && sayacb > sayacc && sayacb > sayacd) {
                sonucText.setText(R.string.elsa);
                baslik.setText("ELSA");
                icon.setBackgroundResource(R.drawable.elsa);
            } else if (sayacc > sayaca && sayacc > sayacb && sayacc > sayacd) {
                sonucText.setText(R.string.pamukPrenses);
                baslik.setText("PAMUK PRENSES");
                icon.setBackgroundResource(R.drawable.pamukprenses);
            } else if (sayacd > sayaca && sayacd > sayacb && sayacd > sayacc) {
                baslik.setText("ELENA");
                sonucText.setText(R.string.elena);
                icon.setBackgroundResource(R.drawable.elena);

            } else if (sayaca == 0 & sayacb == 0 && sayacc == 0 && sayacd == 0) {
                sonucText.setText("Testi Cozmedin :/");
                baslik.setText("");
                icon.setVisibility(View.GONE);

            } else if (sayaca == sayacb || sayacb == sayacd) {
                sonucText.setText(R.string.Pokahontas);
                baslik.setText("POKAHONTAS");
                icon.setBackgroundResource(R.drawable.moana);
            } else if (sayaca == sayacd || sayacc == sayacd) {
                sonucText.setText(R.string.kediKadin);
                baslik.setText("KEDI KADIN");
                icon.setBackgroundResource(R.drawable.elsa);
            } else if (sayaca == sayacc || sayacb == sayacc) {
                sonucText.setText(R.string.elena);
                icon.setBackgroundResource(R.drawable.elena);
                baslik.setText("ELENA");
            } else if (sayaca == sayacb && sayaca == sayacc || sayacc == sayacd && sayacc == sayaca) {
                sonucText.setText(R.string.pamukPrenses);
                baslik.setText("PAMUK PRENSES");
                icon.setBackgroundResource(R.drawable.pamukprenses);
            } else if (sayacb == sayacc && sayacb == sayacd || sayacd == sayaca && sayacd == sayacb) {
                sonucText.setText(R.string.girisimci);
                icon.setBackgroundResource(R.drawable.girisimci);
                baslik.setText("GIRISIMCI");
            } else {
                sonucText.setText(R.string.pamukPrenses);
                baslik.setText("PAMUK PRENSES");
                icon.setBackgroundResource(R.drawable.pamukprenses);
            }
        } else {

            if (sayaca > sayacb && sayaca > sayacc && sayaca > sayacd) {
                sonucText.setText(R.string.orumcekAdam);
                baslik.setText("ORUMCEK ADAM");
                icon.setBackgroundResource(R.drawable.orumcek);
            } else if (sayacb > sayaca && sayacb > sayacc && sayacb > sayacd) {
                sonucText.setText(R.string.joker);
                baslik.setText("JOKER");
                icon.setBackgroundResource(R.drawable.joker);
            } else if (sayacc >sayaca && sayacc > sayacb && sayacc > sayacd) {
                sonucText.setText(R.string.batman);
                baslik.setText("BATMAN");
                icon.setBackgroundResource(R.drawable.batman);
            } else if (sayacd > sayaca && sayacd > sayacb && sayacd > sayacc) {
                baslik.setText("IRONMAN");
                sonucText.setText(R.string.ironman);
                icon.setBackgroundResource(R.drawable.dem_radam);

            } else if (sayaca == 0 & sayacb == 0 && sayacc == 0 && sayacd == 0) {
                sonucText.setText("Testi Cozmedin :/");
                baslik.setText("");
                icon.setVisibility(View.GONE);

            } else if (sayaca == sayacb || sayacb == sayacd) {
                sonucText.setText(R.string.ironman);
                baslik.setText("IRONMAN");
                icon.setBackgroundResource(R.drawable.dem_radam);
            } else if (sayaca == sayacd || sayacc == sayacd) {
                sonucText.setText(R.string.orumcekAdam);
                baslik.setText("ORUMCEK ADAM");
                icon.setBackgroundResource(R.drawable.orumcek);
            } else if (sayaca == sayacc || sayacb == sayacc) {
                sonucText.setText(R.string.batman);
                icon.setBackgroundResource(R.drawable.batman);
                baslik.setText("BATMAN");
            } else if (sayaca == sayacb && sayaca == sayacc || sayacc == sayacd && sayacc == sayaca) {
                sonucText.setText(R.string.joker);
                baslik.setText("JOKER");
                icon.setBackgroundResource(R.drawable.joker);
            } else if (sayacb == sayacc && sayacb == sayacd || sayacd == sayaca && sayacd == sayacb) {
                sonucText.setText(R.string.joker);
                icon.setBackgroundResource(R.drawable.joker);
                baslik.setText("JOKER");
            } else {
                sonucText.setText(R.string.orumcekAdam);
                baslik.setText("ORUMCEK ADAM");
                icon.setBackgroundResource(R.drawable.orumcek);
            }


            //  Toast.makeText(this, "" + dizi[0], Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.anaSayfaDon)
    public void onViewClicked() {

        Intent intent = new Intent(SonucActivity.this, AnasayfaActivity.class);
        startActivity(intent);
        finish();
    }
}
