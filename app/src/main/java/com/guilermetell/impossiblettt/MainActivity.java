package com.guilermetell.impossiblettt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button topLeftBtn;
    Button topMidBtn;
    Button topRightBtn;
    Button midLeftBtn;
    Button midMidBtn;
    Button midRightBtn;
    Button bottomLeftBtn;
    Button bottomMidBtn;
    Button bottomRightBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topLeftBtn = (Button) findViewById(R.id.topleft);
        topMidBtn = (Button) findViewById(R.id.topmid);
        topRightBtn = (Button) findViewById(R.id.topright);
        midLeftBtn = (Button) findViewById(R.id.midleft);
        midMidBtn = (Button) findViewById(R.id.midmid);
        midRightBtn = (Button) findViewById(R.id.midright);
        bottomLeftBtn = (Button) findViewById(R.id.bottomleft);
        bottomMidBtn = (Button) findViewById(R.id.bottommid);
        bottomRightBtn = (Button) findViewById(R.id.bottomright);
        midMidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midMidBtn.setBackgroundResource(R.drawable.x_img);
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
}
