package androidadvance.com.androidsurveyexample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class GrideActivity extends AppCompatActivity implements SurvayFragment.OnFragmentInteractionListener, MyRecyclerViewAdapter.ItemClickListener,AboutFragment.OnFragmentInteractionListener,OrderFragment.OnFragmentInteractionListener,GridFragment.OnFragmentInteractionListener {
    MyRecyclerViewAdapter adapter;
    private static final int SURVEY_REQUEST = 1337;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gride);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        GridFragment firstFragmen = new GridFragment();
        firstFragmen.setArguments(getIntent().getExtras());
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction transactio =
                fragManager.beginTransaction();
        transactio.replace(R.id.con, firstFragmen).addToBackStack( "2" );
        transactio.commit();
        // set up the RecyclerView

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
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onItemClick(View view, int position) {

    }
}

