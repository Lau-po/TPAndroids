package ovh.poulin.tab;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class TabEtu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_etu);
        final Spinner spTerminal = ( Spinner ) findViewById (R.id.terminal);
        final Spinner spStudent = ( Spinner ) findViewById (R.id.student);
        ArrayAdapter adTerminal = ArrayAdapter . createFromResource ( this, R.array.tablets ,android.R.layout.simple_spinner_item ) ;
        ArrayAdapter adStudent = ArrayAdapter . createFromResource ( this, R.array.students ,android.R.layout.simple_spinner_item ) ;
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setDescText(spTerminal, spStudent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spTerminal.setOnItemSelectedListener(listener);
        spStudent.setOnItemSelectedListener(listener);
        spTerminal.setAdapter(adTerminal) ;
        spStudent.setAdapter(adStudent) ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab_etu, menu);
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

    public void setDescText(Spinner term, Spinner stu){
        TextView tvDesc;
        tvDesc = (TextView) findViewById(R.id.description);
        tvDesc.setText(term.getSelectedItem().toString() + "  ->  " +stu.getSelectedItem().toString());
    }
}
