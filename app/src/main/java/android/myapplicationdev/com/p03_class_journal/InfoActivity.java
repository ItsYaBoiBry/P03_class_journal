package android.myapplicationdev.com.p03_class_journal;

/**
 * Created by 15017569 on 5/4/2017.
 */

import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    Button btnEmail, btnAdd, btnInfo;
    ListView lv;
    DGAdapter aa = null;
    ArrayList<DailyGrade> dailygrades = new ArrayList<DailyGrade>();;
    String moduleCode;
    String moduleName;
    int requestCodes = 1;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);

        btnEmail = (Button) findViewById(R.id.buttonEmail);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnInfo = (Button) findViewById(R.id.buttonInfo);

        lv = (ListView) this.findViewById(R.id.lvGrades);
        Intent i = getIntent();
        // Get the String array named "info" we passed in
        final String[] info = i.getStringArrayExtra("info");

        // Get the TextView object

        aa = new DGAdapter(this, R.layout.row, dailygrades);
        lv.setAdapter(aa);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent email = new Intent(Intent.ACTION_SEND);
                String msg = "";
                for(int i = 0; i < dailygrades.size(); i++){
                    msg += "Week " + (i) +": DG: " + dailygrades.get(i).getDgGrade() +"\n";
                }
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "-");
                email.putExtra(Intent.EXTRA_TEXT,
                        "Hi faci, \n I am ... \n Please see my remarks so far, thank you!" +
                                "\n\n" + msg);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = dailygrades.size() + 1;
                Intent weeks = new Intent(InfoActivity.this, AddDailyGrade.class);
                weeks.putExtra("week", dailygrades.size() + 1 + "");
                DailyGrade dailyGrade = new DailyGrade(info[0],"B",(dailygrades.size()+1));
                weeks.putExtra("c347",dailyGrade);
                startActivityForResult(weeks, requestCodes);
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);

                rpIntent.setData(Uri.parse("http://www.rp.edu.sg/Module_Synopses/C347_Android_Programming_II.aspx"));
                startActivity(rpIntent);

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data != null) {
                String like = data.getStringExtra("grade");

                if (requestCode == requestCodes) {
                    dailygrades.add(new DailyGrade(like,"C349" ,size));
                    aa.notifyDataSetChanged();
                }

            }
        }
    }

}