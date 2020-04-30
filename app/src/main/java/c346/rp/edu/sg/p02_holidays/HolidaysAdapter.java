package c346.rp.edu.sg.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HolidaysAdapter extends ArrayAdapter<Holidays> {
    private ArrayList<Holidays> holidays;
    private Context context;
    private ImageView ivholiday;
    private TextView tvName;
    private TextView tvDate;

    public HolidaysAdapter(Context context, int resource, ArrayList<Holidays> objects){
        super(context, resource, objects);
        holidays = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_holidays, parent, false);
        tvName = (TextView)rowView.findViewById(R.id.tvName);
        tvDate = (TextView)rowView.findViewById(R.id.tvDate);
        ivholiday = (ImageView)rowView.findViewById(R.id.ivHoliday);

        Holidays currentHoliday = holidays.get(position);

        tvName.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());
        String imgHoliday = currentHoliday.getName();
        ivholiday.setImageResource(position);

        return rowView;
    }
}
