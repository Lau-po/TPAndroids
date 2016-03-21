package fr.univ_lille1.iuta.place.palette;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import static fr.univ_lille1.iuta.place.palette.R.array;
import static fr.univ_lille1.iuta.place.palette.R.layout;

public class MainActivity extends AppCompatActivity {
    Map<String,Integer> colorMap = new HashMap<String,Integer>();
    String[] colorNames;
    boolean pressed;
    int lastcolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        colorNames  = getResources().getStringArray(array.color_names);
        for(int i = 0; i < colorNames.length ; i++){
            colorMap.put(colorNames[i],getResources().getColor(getResources().getIdentifier(colorNames[i],"color",getPackageName())));
        }
        ArrayAdapter aaCNames = ArrayAdapter.createFromResource(this,array.color_names, android.R.layout.simple_spinner_item);
        final Spinner spCNames = (Spinner) findViewById(R.id.spinner);
        spCNames.setAdapter(aaCNames);
        final TextView showColor = (TextView) findViewById(R.id.demo);
        spCNames.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showColor.setBackgroundColor(colorMap.get(spCNames.getSelectedItem().toString()));
                showColor.setText(spCNames.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final TextView tvRouge;
        tvRouge = (TextView) findViewById(R.id.EditRouge);
        final TextView tvBleu;
        tvRouge.setText("128");
        tvBleu = (TextView) findViewById(R.id.EditBleu);
        tvBleu.setText("128");
        final TextView tvVert;
        tvVert = (TextView) findViewById(R.id.EditVert);
        final SeekBar sbRouge = (SeekBar) findViewById(R.id.Rouge);
        tvVert.setText("128");
        sbRouge.setProgress(128);
        sbRouge.setMax(255);
        final SeekBar sbBleu = (SeekBar) findViewById(R.id.Bleu);
        sbBleu.setProgress(128);
        sbBleu.setMax(255);
        final SeekBar sbVert = (SeekBar) findViewById(R.id.Vert);
        sbVert.setProgress(128);
        sbVert.setMax(255);
        final SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pressed = false;
                if (seekBar.equals(sbBleu)) {
                    tvBleu.setText("" + progress);
                }
                if (seekBar.equals(sbRouge)) {
                    tvRouge.setText(""+progress);
                }
                if (seekBar.equals(sbVert)) {
                    tvVert.setText(""+progress);

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
        sbRouge.setOnSeekBarChangeListener(seekBarListener);
        sbBleu.setOnSeekBarChangeListener(seekBarListener);
        sbVert.setOnSeekBarChangeListener(seekBarListener);
        Button btnLookup = (Button) findViewById(R.id.lookup);
        btnLookup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastcolor = Color.rgb(sbRouge.getProgress(),sbVert.getProgress(),sbBleu.getProgress());
                int diff = ((sbRouge.getProgress()-Color.red(colorMap.get("Brown"))^2)+(sbVert.getProgress()-Color.green(colorMap.get("Brown"))^2)+(sbBleu.getProgress()-Color.blue(colorMap.get("Brown"))^2));
                    ;
                String colorn = "Brown";
                int colorv = lastcolor;
                for (Map.Entry<String, Integer> entry : colorMap.entrySet())
                {
                    if(((sbRouge.getProgress()-Color.red(entry.getValue())^2)+(sbVert.getProgress()-Color.green(entry.getValue())^2)+(sbBleu.getProgress()-Color.blue(entry.getValue())^2)) <= diff){
                        colorn = entry.getKey();
                        colorv = entry.getValue();
                        diff = ((sbRouge.getProgress()-Color.red(entry.getValue())^2)+(sbVert.getProgress()-Color.green(entry.getValue())^2)+(sbBleu.getProgress()-Color.blue(entry.getValue())^2));

                        }
                }
                lastcolor = colorv;
                v.setBackgroundColor(lastcolor);
                showColor.setText(colorn);
                showColor.setBackgroundColor(colorv);
                pressed = true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("RED",((SeekBar) findViewById(R.id.Rouge)).getProgress());
        outState.putInt("GREEN",((SeekBar) findViewById(R.id.Vert)).getProgress());
        outState.putInt("BLUE",((SeekBar) findViewById(R.id.Bleu)).getProgress());
        outState.putInt("LASTCOLOR",lastcolor);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ((SeekBar) findViewById(R.id.Rouge)).setProgress(savedInstanceState.getInt("RED"));
        ((SeekBar) findViewById(R.id.Vert)).setProgress(savedInstanceState.getInt("GREEN"));
        ((SeekBar) findViewById(R.id.Bleu)).setProgress(savedInstanceState.getInt("BLUE"));
        if(savedInstanceState.getInt("LASTCOLOR") != 0) {
            lastcolor = savedInstanceState.getInt("LASTCOLOR");
            ((Button) findViewById(R.id.lookup)).setBackgroundColor(lastcolor);
        }
    }
}
