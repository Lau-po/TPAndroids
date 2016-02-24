package ovh.poulin.change;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tvResult; Spinner spEntry, spOut; EditText etEntry; Button btConvert;

    AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(view == findViewById(R.id.spOut)){

            }else{

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvResult = (TextView) findViewById(R.id.tvresult);
        spEntry = (Spinner) findViewById(R.id.spEntry);
        spOut = (Spinner) findViewById(R.id.spOut);
        etEntry = (EditText) findViewById(R.id.etEntry);
        btConvert = (Button) findViewById(R.id.convert);
        ArrayAdapter spaEntry = ArrayAdapter.createFromResource(this, R.array.currencies, android.R.layout.simple_spinner_item);
        ArrayAdapter spaOut = ArrayAdapter.createFromResource(this, R.array.currencies, android.R.layout.simple_spinner_item);
        spOut.setAdapter(spaOut);
        spOut.setOnItemSelectedListener(listener);
        spEntry.setAdapter(spaEntry);
        setContentView(R.layout.activity_main);
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
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
