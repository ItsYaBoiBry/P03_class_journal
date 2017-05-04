package android.myapplicationdev.com.p03_class_journal;

/**
 * Created by 15017569 on 5/4/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter{
    private ArrayList<Module> modules;
    private Context context;
    private TextView tvModule;
    private  TextView tvCode;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.modulerow, parent, false);


        tvModule = (TextView) rowView.findViewById(R.id.textViewModule);
        tvCode = (TextView) rowView.findViewById(R.id.textViewCode);

        Module currentType = modules.get(position);


        tvModule.setText(currentType.getModuleName());
        tvCode.setText(currentType.getModuleCode());
        return rowView;
    }
    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);

        modules = objects;
        this.context = context;
    }
}