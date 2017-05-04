package android.myapplicationdev.com.p03_class_journal;

/**
 * Created by 15017569 on 5/4/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddDG extends AppCompatActivity {
    TextView tvWeek;
    ImageView iv;
    RadioGroup rg;
    RadioButton rb;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Intent i = new Intent();
        DailyGrade dailygrades = (DailyGrade) i.getSerializableExtra("c347");

        tvWeek = (TextView) findViewById(R.id.tvWeek);
        tvWeek.setText(dailygrades.getWeek());

        iv = (ImageView)findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.dg);

        Intent intentReceived = getIntent();
        String weeks = intentReceived.getStringExtra("week");
        tvWeek.setText("Week: " + weeks);


        rg = (RadioGroup) findViewById(R.id.rg);
        int selectedButtonId = rg.getCheckedRadioButtonId();
        // Get the radio button object from the Id we had gotten above
        rb = (RadioButton) findViewById(selectedButtonId);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("grade", rb.getText().toString());
                setResult(RESULT_OK, i);
                finish();

            }
        });





    }
}