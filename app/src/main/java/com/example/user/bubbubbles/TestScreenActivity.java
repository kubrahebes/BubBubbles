package com.example.user.bubbubbles;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.bubbubbles.adapters.QuestionAdapter;
import com.example.user.bubbubbles.models.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wenchao.cardstack.CardStack;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestScreenActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    String secilenKategori;
    Question value;
    QuestionAdapter questionAdapter;
    @BindView(R.id.rl)
    TextView rl;
    @BindView(R.id.bitis)
    Button bitis;

    private ProgressDialog mProgress;
    private CardStack mCardStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_screen);
        ButterKnife.bind(this);


        mCardStack = (CardStack) findViewById(R.id.container);

        mCardStack.setContentResource(R.layout.networking_card_content);
        Intent intent = getIntent();
        mProgress = new ProgressDialog(TestScreenActivity.this);
        mProgress.setTitle("Processing...");
        mProgress.setMessage("Please wait...");
        mProgress.setCancelable(true);
        mProgress.setIndeterminate(true);
        mProgress.show();
        secilenKategori = intent.getStringExtra("secilenKategori");
     //   Toast.makeText(this, secilenKategori, Toast.LENGTH_SHORT).show();
        if (secilenKategori.equals("meslek")) {
            rl.setText("Mesleğini Keşfet ");
        } else if (secilenKategori.equals("superKahraman")) {
            rl.setText("SUPER KAHRAMAN");
        } else {
            rl.setText("YETENEGINI KESFET");
        }
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("database").child(secilenKategori);
        getdata();
    }

    /**
     * get data from the firebase
     */
    public void getdata() {

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mProgress.cancel();
                ArrayList<Question> financeGoalList = new ArrayList<>();
                for (DataSnapshot verigetir : dataSnapshot.getChildren()) {
                    //  mProgress.cancel();
                    value = verigetir.getValue(Question.class);
                   // Toast.makeText(TestScreenActivity.this, value.getQuestion(), Toast.LENGTH_SHORT).show();
                    financeGoalList.add(value);

                }
                setdata(financeGoalList);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(TestScreenActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });


    }


    /**
     * Set Adapter
     */
    public void setdata(final ArrayList<Question> list) {


        ArrayList<Question> goal = new ArrayList<>();

        questionAdapter = new QuestionAdapter(this, goal);
        for (int i = 0; i < list.size(); i++) {
            questionAdapter.add(new Question(list.get(i).getQuestion(), list.get(i).getAnswer1(), list.get(i).getAnswer2(), list.get(i).getAnswer3(), list.get(i).getAnswer4(), list.get(i).getId()));
        }
        mCardStack.setAdapter(questionAdapter);
        // mCardStack.setEnableLoop(!mCardStack.isEnableLoop());


        if (mCardStack.getAdapter() != null) {
            Log.i("MyActivity", "Card Stack size: " + mCardStack.getAdapter().getCount());
        }

        mCardStack.setListener(new CardStack.CardEventListener() {
            @Override
            public boolean swipeEnd(int direction, float distance) {
                Log.d("direction", String.valueOf(direction));
                Log.d("distance", String.valueOf(distance));

                if (distance > 100) {
                    if (direction == 0 || direction == 2) {

                        //   int dislikeUpdate = list.get(mCardStack.getCurrIndex()).getDislike();
                        // dislikeUpdate++;
                        // myRef.child(list.get(mCardStack.getCurrIndex()).getId()).child("dislike")
                        //       .setValue(dislikeUpdate);

                        //} else {
                        //  int likeUpdate = list.get(mCardStack.getCurrIndex()).getLike();
                        //likeUpdate++;
                        // myRef.child(list.get(mCardStack.getCurrIndex()).getId()).child("like")
                        //       .setValue(likeUpdate);

                    }
                }

                return true;
            }

            @Override
            public boolean swipeStart(int i, float v) {
                return false;
            }

            @Override
            public boolean swipeContinue(int i, float v, float v1) {
                return false;
            }

            @Override
            public void discarded(int i, int i1) {

            }

            @Override
            public void topCardTapped() {

            }
        });

    }

    @OnClick(R.id.bitis)
    public void onViewClicked() {

        Intent intent = new Intent(TestScreenActivity.this, SonucActivity.class);
        intent.putExtra("kategori",secilenKategori);
        startActivity(intent);
    }
}
