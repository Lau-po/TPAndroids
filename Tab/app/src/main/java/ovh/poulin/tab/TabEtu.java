package ovh.poulin.tab;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class TabEtu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_etu);
        final ListView lvTerminal = ( ListView ) findViewById (R.id.list);
        ListAdapter adTerminal = new myAdapter();
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // setDescText(spTerminal, spStudent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        lvTerminal.setOnItemSelectedListener(listener);
        lvTerminal.setAdapter(adTerminal) ;
    }

    class myAdapter extends BaseAdapter implements ListAdapter {

        @Override
        public int getCount() {
            return getResources().getStringArray(R.array.tablets).length;
        }

        @Override
        public Object getItem(int position) {
            return getResources().getStringArray(R.array.tablets)[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

            convertView=inflater.inflate(R.layout.list_row,parent,false);

            Spinner spinner=(Spinner) convertView.findViewById(R.id.spinner1);
            TextView tvTab=(TextView) convertView.findViewById(R.id.value);
            tvTab.setText(getResources().getStringArray(R.array.tablets)[position]);

            ArrayAdapter adStudent = ArrayAdapter . createFromResource ( getApplicationContext(), R.array.students ,android.R.layout.simple_spinner_item ) ;
            adStudent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adStudent);
            return convertView;
        }
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

    /*public void setDescText(Spinner term, Spinner stu){
        TextView tvDesc;
        tvDesc = (TextView) findViewById(R.id.description);
        tvDesc.setText(term.getSelectedItem().toString() + "  ->  " +stu.getSelectedItem().toString());
    }*/
}
