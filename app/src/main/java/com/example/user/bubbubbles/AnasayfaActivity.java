package com.example.user.bubbubbles;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnasayfaActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    @BindView(R.id.meslek_rlt)
    RelativeLayout meslekRlt;
    @BindView(R.id.superKahraman)
    ImageView superKahraman;
    @BindView(R.id.superKahraman_rlt)
    RelativeLayout superKahramanRlt;
    @BindView(R.id.yetenek_rlt)
    RelativeLayout yetenekRlt;
    @BindView(R.id.not_connected_text)
    TextView notConnectedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        ButterKnife.bind(this);
        ConnectivityManager connectivityManager = (ConnectivityManager)
                AnasayfaActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(AnasayfaActivity.this);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setTitle(R.string.quit);
            builder.setMessage(R.string.really_quit);
            builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();                         //Stop the activity
                }

            })
                    .setNegativeButton(R.string.no, null)
                    .show();
            notConnectedText.setText(R.string.noconnection_String);
        }

      /*  database = FirebaseDatabase.getInstance();
        myRef = database.getReference("database");
        String key = myRef.child("superKahraman").push().getKey();
        Question soru=new Question("En sevdiğin yemek nedir ?","Tavuk döner","Şeker","Elma","Tost",key);
        myRef.child("superKahraman").child(key).setValue(soru);
*/


    }

    @OnClick({R.id.meslek_rlt, R.id.superKahraman, R.id.superKahraman_rlt, R.id.yetenek_rlt, R.id.cardBos})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.meslek_rlt:
                Intent intent = new Intent(AnasayfaActivity.this, LetStartActivity.class);
                intent.putExtra("kategori", "meslek");
                startActivity(intent);
                break;
            case R.id.superKahraman_rlt:
                Intent intent2 = new Intent(AnasayfaActivity.this, LetStartActivity.class);
                intent2.putExtra("kategori", "superKahraman");
                startActivity(intent2);
                break;
            case R.id.yetenek_rlt:
                Toast.makeText(this, "Su an aktif degil !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cardBos:
                Toast.makeText(this, "Su an aktif degil !!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
