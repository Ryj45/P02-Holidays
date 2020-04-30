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


        types.add(new Type("Secular"));

        types.add(new Type("Ethnic & Religion"));

        aa = new TypeAdapter(this, R.layout.row_type, types);
        lvType.setAdapter(aa);

        lvType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Type selectedType = types.get(position);
                Intent i = new Intent(MainActivity.this, ShowHolidays.class);
                i.putExtra("index", position);
                i.putExtra("type", selectedType.getType());
                startActivity(i);
            }
        });
    }
}
