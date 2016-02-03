package poulin.ovh.democycle;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String KEY_CUMUL = "cumul";
    private final static String KEY_INVERSE = "inverse";
    double inverse = 1;
    double cumul = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    public void doCalculate(View view) {
        TextView tvInverse;
        TextView tvCumul;
        EditText etIncrement;

        tvInverse = (TextView) findViewById(R.id.inverse);
        tvCumul = (TextView) findViewById(R.id.cumul);
        etIncrement = (EditText) findViewById(R.id.increment);
        if (!etIncrement.getText().toString().equals("")) {
            cumul = Double.parseDouble((String) tvCumul.getText()) + Double.parseDouble(etIncrement.getText().toString());
            inverse = 1 / cumul;
            tvCumul.setText("" + cumul);
            tvInverse.setText("" + inverse);
        } else {
            Toast.makeText(this, "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
        }
    }

    public void doInit(View view) {
        TextView tvInverse;
        TextView tvCumul;
        double inverse, cumul;
        tvInverse = (TextView) findViewById(R.id.inverse);
        tvCumul = (TextView) findViewById(R.id.cumul);
        cumul = 1;
        inverse = 1;
        tvInverse.setText(""+1);
        tvCumul.setText("" + 1);
    }

    public void doContact(View view) {
        Intent contactPickerIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(contactPickerIntent, 1001);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        TextView tvInverse;
        TextView tvCumul;
        tvInverse = (TextView) findViewById(R.id.inverse);
        tvCumul = (TextView) findViewById(R.id.cumul);
        tvCumul.setText("" + cumul);
        tvInverse.setText("" + inverse);
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_CUMUL, ((TextView)findViewById(R.id.cumul)).getText().toString());
        outState.putString(KEY_INVERSE, ((TextView) findViewById(R.id.inverse)).getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState.containsKey(KEY_CUMUL) && savedInstanceState.containsKey(KEY_INVERSE)) {
            cumul = Double.parseDouble(savedInstanceState.getString(KEY_CUMUL).toString());
            inverse = Double.parseDouble(savedInstanceState.getString(KEY_INVERSE).toString());
        }else{
            Toast.makeText(this, "Aucune valeur dans le bundle", Toast.LENGTH_SHORT).show();
        }
        super.onRestoreInstanceState(savedInstanceState);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
