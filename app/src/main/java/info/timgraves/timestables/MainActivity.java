package info.timgraves.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    ArrayList<Integer> timesValues = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateList(1);

        SeekBar setTableBar = (SeekBar)findViewById(R.id.setTableBar);
        setTableBar.setMax(19);
        setTableBar.setProgress(0);

        setTableBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                updateList(i + 1);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void updateList(int j) {

        timesValues.clear();

        for (int i = 1; i <= 10; i++) {
            timesValues.add(j * i);
        }

        ListView timesTable = (ListView)findViewById(R.id.timesTable);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, timesValues);
        timesTable.setAdapter(arrayAdapter);


    }
}
