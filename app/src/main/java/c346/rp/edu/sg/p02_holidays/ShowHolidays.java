package c346.rp.edu.sg.p02_holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowHolidays extends AppCompatActivity {

    ListView lvHolidays;
    ArrayAdapter aa;
    TextView tvTypeShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_holidays);

        lvHolidays = (ListView)this.findViewById(R.id.lvHolidays);
        tvTypeShow = (TextView)findViewById(R.id.tvTypeShow);

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        ArrayList<Holidays> holidays = (ArrayList<Holidays>)i.getSerializableExtra("holidays");

        tvTypeShow.setText(type);

        aa = new HolidaysAdapter(this,R.layout.row_holidays, holidays);
        lvHolidays.setAdapter(aa);

    }
}
