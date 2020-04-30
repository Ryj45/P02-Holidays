package c346.rp.edu.sg.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TypeAdapter extends ArrayAdapter<Type> {
    private ArrayList<Type> types;
    private Context context;
    private TextView tvType;

    public TypeAdapter(Context context, int resource, ArrayList<Type> objects){
        super(context, resource, objects);
        types = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_type, parent, false);
        tvType = (TextView)rowView.findViewById(R.id.tvType);
        Type currentType = types.get(position);
        tvType.setText(currentType.getType());
        return rowView;
    }
}
