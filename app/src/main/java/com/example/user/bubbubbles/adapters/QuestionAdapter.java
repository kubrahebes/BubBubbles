package com.example.user.bubbubbles.adapters;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.bubbubbles.R;
import com.example.user.bubbubbles.models.Question;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 04.03.2018.
 */

public class QuestionAdapter extends ArrayAdapter<Question> {


    public QuestionAdapter(Activity context, ArrayList<Question> androidFlavors) {

        super(context, 0, androidFlavors);
    }

     static int sayaca, sayacb, sayacd, sayacc;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        pref = getContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        sayaca = pref.getInt("SayacA", 0);
        sayacb = pref.getInt("SayacB", 0);
        sayacc = pref.getInt("SayacC", 0);
        sayacd = pref.getInt("SayacD", 0);
       // Toast.makeText(getContext(), ""+sayacc, Toast.LENGTH_SHORT).show();
        convertView = LayoutInflater.from(getContext()).inflate(
                R.layout.networking_card_content, parent, false);
        holder = new ViewHolder(convertView);
        convertView.setTag(holder);
        Question currentGoal = getItem(position);



        holder.tvsoru.setText(currentGoal.getQuestion());
        holder.radio1.setText(currentGoal.getAnswer1());
        holder.radio2.setText(currentGoal.getAnswer2());
        holder.radio3.setText(currentGoal.getAnswer3());
        holder.radio4.setText(currentGoal.getAnswer4());
        if (currentGoal.getId().equals("1")) {

        } else if (currentGoal.getId().equals("2")) {


        } else if (currentGoal.getId().equals("3")) {

        } else if (currentGoal.getId().equals("4")) {

        } else if (currentGoal.getId().equals("5")) {

        } else if (currentGoal.getId().equals("6")) {

        } else if (currentGoal.getId().equals("7")) {


        }
        //int selectedId = holder.radiogroup.getCheckedRadioButtonId();

        holder.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        sayaca++;
                        editor.putInt("SayacA", sayaca);
                        editor.commit();
                       // Toast.makeText(getContext(), "Radio1", Toast.LENGTH_SHORT).show();
                        // do operations specific to this selection
                        break;
                    case R.id.radio2:
                        sayacb++;
                        editor.putInt("SayacB", sayacb);
                        editor.commit();
                    //    Toast.makeText(getContext(), "Radio2", Toast.LENGTH_SHORT).show();
                        // do operations specific to this selection
                        break;
                    case R.id.radio3:
                        sayacc++;
                       // Toast.makeText(getContext(), "" + sayacc, Toast.LENGTH_SHORT).show();
                        editor.putInt("SayacC", sayacc);
                       // editor.putInt("SayacD", sayacd);
                        editor.commit();
                        // do operations specific to this selection
                        break;
                    case R.id.radio4:
                      //  Toast.makeText(getContext(), "Radio4", Toast.LENGTH_SHORT).show();
                        sayacd++;
                        editor.putInt("SayacD", sayacd);
                        editor.commit();
                        // do operations specific to this selection
                        break;
                }
            }
        });


        return convertView;
    }

    static

    public class ViewHolder {
        @BindView(R.id.imgicon)
        ImageView imgicon;
        @BindView(R.id.tvsoru)
        TextView tvsoru;
        @BindView(R.id.radio2)
        RadioButton radio2;

        @BindView(R.id.radio1)
        RadioButton radio1;
        @BindView(R.id.radio3)
        RadioButton radio3;

        @BindView(R.id.radio4)

        RadioButton radio4;
        @BindView(R.id.card)
        RelativeLayout card;
        @BindView(R.id.cardView)
        CardView cardView;
        @BindView(R.id.radiogroup)
        RadioGroup radiogroup;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
