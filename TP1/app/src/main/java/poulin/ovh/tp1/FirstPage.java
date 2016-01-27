package poulin.ovh.tp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FirstPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_page, menu);
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

    public void doOk(View view ) {
        TextView tvNom;
        TextView tvMessage;
        String msg;
        tvNom = (TextView) findViewById(R.id.nom);
        tvMessage =(TextView) findViewById(R.id.message);
        msg = getString(R.string.bienvenue)+" "+tvNom.getText()+"!";
        tvMessage.setTextColor(getResources().getColor(R.color.Blue));
        tvMessage.setText(msg);
    }

    public void doInit(View view){
        ((TextView)findViewById(R.id.nom)).setText("");
        ((TextView)findViewById(R.id.message)).setTextColor(getResources().getColor(R.color.Red));
        ((TextView)findViewById(R.id.message)).setText(getString(R.string.bienvenue));
    }
}
