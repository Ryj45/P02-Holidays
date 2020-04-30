package c346.rp.edu.sg.p02_holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowHolidays extends AppCompatActivity {

    ListView lvHolidays;
    ArrayAdapter aa;
    TextView tvTypeShow;
    ArrayList<Holidays> holidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_holidays);

        lvHolidays = (ListView)this.findViewById(R.id.lvHolidays);
        tvTypeShow = (TextView)findViewById(R.id.tvTypeShow);

        Intent i = getIntent();
        String type = i.getStringExtra("type");

        ArrayList<Holidays> secular = new ArrayList<>();
        secular.add(new Holidays("New Year's Day", "1 Jan 2017", R.drawable.new_years_day));
        secular.add(new Holidays("Labour Day", "1 May 2017", R.drawable.labour_day));

        ArrayList<Holidays> ethnicReligion = new ArrayList<>();
        ethnicReligion.add(new Holidays("Chinese New Year", "28-29 Jan 2017",R.drawable.chinese_new_year));
        ethnicReligion.add(new Holidays("Good Friday", "14 April 2017", R.drawable.good_friday));

        tvTypeShow.setText(type);

        int index = i.getIntExtra("index", 0);

        if (index == 0) {
            holidays = secular;

        }else{
            holidays = ethnicReligion;
        }

        aa = new HolidaysAdapter(this, R.layout.row_holidays, holidays);
        lvHolidays.setAdapter(aa);

        lvHolidays.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holidays selectedHoliday = holidays.get(position);
                Toast.makeText(ShowHolidays.this, selectedHoliday.getName() + "Date: " + selectedHoliday.getDate(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
