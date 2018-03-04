package com.example.user.bubbubbles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        ButterKnife.bind(this);


      /*  database = FirebaseDatabase.getInstance();
        myRef = database.getReference("database");
        String key = myRef.child("superKahraman").push().getKey();
        Question soru=new Question("En sevdiğin yemek nedir ?","Tavuk döner","Şeker","Elma","Tost",key);
        myRef.child("superKahraman").child(key).setValue(soru);
*/


    }

    @OnClick({R.id.meslek_rlt, R.id.superKahraman, R.id.superKahraman_rlt, R.id.yetenek_rlt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.meslek_rlt:
                Intent intent=new Intent(AnasayfaActivity.this,LetStartActivity.class);
                intent.putExtra("kategori","meslek");
                startActivity(intent);
                break;
            case R.id.superKahraman_rlt:
                Intent intent2=new Intent(AnasayfaActivity.this,LetStartActivity.class);
                intent2.putExtra("kategori","superKahraman");
                startActivity(intent2);
                break;
            case R.id.yetenek_rlt:
                Intent intent3=new Intent(AnasayfaActivity.this,LetStartActivity.class);
                intent3.putExtra("kategori","yetenek");
                startActivity(intent3);
                break;
        }
    }
}
