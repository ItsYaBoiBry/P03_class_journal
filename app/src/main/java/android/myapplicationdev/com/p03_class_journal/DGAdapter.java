package android.myapplicationdev.com.p03_class_journal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by 15017569 on 5/4/2017.
 */

public class DGAdapter extends ArrayAdapter{
    private ArrayList<DailyGrade> dailygrades;
    private Context context;
    private TextView tvWeek, tvGrade;
    private ImageView ivDG;


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvWeek = (TextView) rowView.findViewById(R.id.weekTv);
        tvGrade = (TextView) rowView.findViewById(R.id.tvDailyGrade);
        ivDG = (ImageView) rowView.findViewById(R.id.imageView);

        DailyGrade currentCa = dailygrades.get(position);

        tvWeek.setText(currentCa.getWeek());
        tvGrade.setText(currentCa.getDgGrade());
        ivDG.setImageResource(R.drawable.dg);
        return rowView;
    }
    public DGAdapter(Context context, int resource, ArrayList<DailyGrade> objects){
        super(context, resource, objects);

        dailygrades = objects;
        this.context = context;
    }
}

