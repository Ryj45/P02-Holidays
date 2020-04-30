package c346.rp.edu.sg.p02_holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvType;
    ArrayAdapter aa;
    ArrayList<Type> types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvType = (ListView)this.findViewById(R.id.lvType);

        types = new ArrayList<Type>();
        ArrayList<Holidays> secular = new ArrayList<>();
        secular.add(new Holidays("New Year's Day", "1 Jan 2017"));
        secular.add(new Holidays("Labour Day", "1 May 2017"));
        types.add(new Type("Secular", secular));

        ArrayList<Holidays> ethnicReligion = new ArrayList<>();
        ethnicReligion.add(new Holidays("Chinese New Year", "28-29 Jan 2017"));
        ethnicReligion.add(new Holidays("Good Friday", "14 April 2017"));
        types.add(new Type("Ethnic & Religion", ethnicReligion));

        aa = new TypeAdapter(this, R.layout.row_type, types);
        lvType.setAdapter(aa);

        lvType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Type selectedType = types.get(position);
                Intent i = new Intent(MainActivity.this, ShowHolidays.class);
                i.putExtra("type", selectedType.getType());
                i.putExtra("holidays", selectedType.getHolidaysArray());
                startActivity(i);
            }
        });
    }
}
