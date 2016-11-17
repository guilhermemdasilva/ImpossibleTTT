package com.guilermetell.impossiblettt;

import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button topLeftBtn;
    Button topMidBtn;
    Button topRightBtn;
    Button midLeftBtn;
    Button midMidBtn;
    Button midRightBtn;
    Button bottomLeftBtn;
    Button bottomMidBtn;
    Button bottomRightBtn;
    Button resetBtn;
    boolean isXturn = true;

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
        resetBtn = (Button) findViewById((R.id.resetbutton));
        topLeftBtn.setOnClickListener(this);
        topMidBtn.setOnClickListener(this);
        topRightBtn.setOnClickListener(this);
        midLeftBtn.setOnClickListener(this);
        midMidBtn.setOnClickListener(this);
        midRightBtn.setOnClickListener(this);
        bottomLeftBtn.setOnClickListener(this);
        bottomMidBtn.setOnClickListener(this);
        bottomRightBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isXturn = true;
                topLeftBtn.setBackground(ContextCompat.getDrawable(MainActivity.this, R.color.white));
                topLeftBtn.setTag(null);
                topMidBtn.setBackground(ContextCompat.getDrawable(MainActivity.this, R.color.white));
                topMidBtn.setTag(null);
                topRightBtn.setBackground(ContextCompat.getDrawable(MainActivity.this, R.color.white));
                topRightBtn.setTag(null);

                midLeftBtn.setBackground(ContextCompat.getDrawable(MainActivity.this, R.color.white));
                midLeftBtn.setTag(null);
                midMidBtn.setBackground(ContextCompat.getDrawable(MainActivity.this, R.color.white));
                midMidBtn.setTag(null);
                midRightBtn.setBackground(ContextCompat.getDrawable(MainActivity.this, R.color.white));
                midRightBtn.setTag(null);

                bottomLeftBtn.setBackground(ContextCompat.getDrawable(MainActivity.this, R.color.white));
                bottomLeftBtn.setTag(null);
                bottomMidBtn.setBackground(ContextCompat.getDrawable(MainActivity.this, R.color.white));
                bottomMidBtn.setTag(null);
                bottomRightBtn.setBackground(ContextCompat.getDrawable(MainActivity.this, R.color.white));
                bottomRightBtn.setTag(null);

                enableButtons();
            }
        });
        new DoArtificialIntelligence().execute();
    }

    private class DoArtificialIntelligence extends AsyncTask<String, String, String> {

        protected String doInBackground(String... params) {
            return "";
        }
    }

    public void disableButtons() {
        topLeftBtn.setEnabled(false);
        topMidBtn.setEnabled(false);
        topRightBtn.setEnabled(false);
        midLeftBtn.setEnabled(false);
        midMidBtn.setEnabled(false);
        midRightBtn.setEnabled(false);
        bottomLeftBtn.setEnabled(false);
        bottomMidBtn.setEnabled(false);
        bottomRightBtn.setEnabled(false);
    }

    public void enableButtons() {
        topLeftBtn.setEnabled(true);
        topMidBtn.setEnabled(true);
        topRightBtn.setEnabled(true);
        midLeftBtn.setEnabled(true);
        midMidBtn.setEnabled(true);
        midRightBtn.setEnabled(true);
        bottomLeftBtn.setEnabled(true);
        bottomMidBtn.setEnabled(true);
        bottomRightBtn.setEnabled(true);
    }

    public void checkWin() {

        //horizontal
        if ((topLeftBtn.getTag() != null && topMidBtn.getTag() != null && topRightBtn.getTag() != null &&
            ((Integer)topLeftBtn.getTag()).intValue() == ((Integer)topMidBtn.getTag()).intValue() && ((Integer)topLeftBtn.getTag()).intValue() == ((Integer)topRightBtn.getTag()).intValue()) ||
            (midLeftBtn.getTag() != null && midMidBtn.getTag() != null && midRightBtn.getTag() != null &&
            ((Integer)midLeftBtn.getTag()).intValue() == ((Integer)midMidBtn.getTag()).intValue() && ((Integer)midLeftBtn.getTag()).intValue() == ((Integer)midRightBtn.getTag()).intValue()) ||
            (bottomLeftBtn.getTag() != null && bottomMidBtn.getTag() != null && bottomRightBtn.getTag() != null &&
            ((Integer)bottomLeftBtn.getTag()).intValue() == ((Integer)bottomMidBtn.getTag()).intValue() && ((Integer)bottomLeftBtn.getTag()).intValue() == ((Integer)bottomRightBtn.getTag()).intValue()) ||

        //vertical
            (topLeftBtn.getTag() != null && midLeftBtn.getTag() != null && bottomLeftBtn.getTag() != null &&
            ((Integer)topLeftBtn.getTag()).intValue() == ((Integer)midLeftBtn.getTag()).intValue() && ((Integer)topLeftBtn.getTag()).intValue() == ((Integer)bottomLeftBtn.getTag()).intValue()) ||
            (topMidBtn.getTag() != null && midMidBtn.getTag() != null && bottomMidBtn.getTag() != null &&
            ((Integer)topMidBtn.getTag()).intValue() == ((Integer)midMidBtn.getTag()).intValue() && ((Integer)topMidBtn.getTag()).intValue() == ((Integer)bottomMidBtn.getTag()).intValue()) ||
            (topRightBtn.getTag() != null && midRightBtn.getTag() != null && bottomRightBtn.getTag() != null &&
            ((Integer)topRightBtn.getTag()).intValue() == ((Integer)midRightBtn.getTag()).intValue() && ((Integer)topRightBtn.getTag()).intValue() == ((Integer)bottomRightBtn.getTag()).intValue()) ||

        //diagonal
            (topLeftBtn.getTag() != null && midMidBtn.getTag() != null && bottomRightBtn.getTag() != null &&
            ((Integer)topLeftBtn.getTag()).intValue() == ((Integer)midMidBtn.getTag()).intValue() && ((Integer)topLeftBtn.getTag()).intValue() == ((Integer)bottomRightBtn.getTag()).intValue()) ||
            (topRightBtn.getTag() != null && midMidBtn.getTag() != null && bottomLeftBtn.getTag() != null &&
            ((Integer)topRightBtn.getTag()).intValue() == ((Integer)midMidBtn.getTag()).intValue() && ((Integer)topRightBtn.getTag()).intValue() == ((Integer)bottomLeftBtn.getTag()).intValue())) {

            Toast.makeText(this, "GAME ENDED!", Toast.LENGTH_LONG).show();
            disableButtons();
        }


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.topleft:
                if(isXturn) {
                    topLeftBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.x_img));
                    topLeftBtn.setTag(R.drawable.x_img);
                } else {
                    topLeftBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.o_img));
                    topLeftBtn.setTag(R.drawable.o_img);
                }
                topLeftBtn.setEnabled(false);
                isXturn = !isXturn;
                break;
            case R.id.topmid:
                if(isXturn) {
                    topMidBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.x_img));
                    topMidBtn.setTag(R.drawable.x_img);
                } else {
                    topMidBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.o_img));
                    topMidBtn.setTag(R.drawable.o_img);
                }
                topMidBtn.setEnabled(false);
                isXturn = !isXturn;
                break;
            case R.id.topright:
                if(isXturn) {
                    topRightBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.x_img));
                    topRightBtn.setTag(R.drawable.x_img);
                } else {
                    topRightBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.o_img));
                    topRightBtn.setTag(R.drawable.o_img);
                }
                topRightBtn.setEnabled(false);
                isXturn = !isXturn;
                break;
            case R.id.midleft:
                if(isXturn) {
                    midLeftBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.x_img));
                    midLeftBtn.setTag(R.drawable.x_img);
                } else {
                    midLeftBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.o_img));
                    midLeftBtn.setTag(R.drawable.o_img);
                }
                midLeftBtn.setEnabled(false);
                isXturn = !isXturn;
                break;
            case R.id.midmid:
                if(isXturn) {
                    midMidBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.x_img));
                    midMidBtn.setTag(R.drawable.x_img);
                } else {
                    midMidBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.o_img));
                    midMidBtn.setTag(R.drawable.o_img);
                }
                midMidBtn.setEnabled(false);
                isXturn = !isXturn;
                break;
            case R.id.midright:
                if(isXturn) {
                    midRightBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.x_img));
                    midRightBtn.setTag(R.drawable.x_img);
                } else {
                    midRightBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.o_img));
                    midRightBtn.setTag(R.drawable.o_img);
                }
                midRightBtn.setEnabled(false);
                isXturn = !isXturn;
                break;
            case R.id.bottomleft:
                if(isXturn) {
                    bottomLeftBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.x_img));
                    bottomLeftBtn.setTag(R.drawable.x_img);
                } else {
                    bottomLeftBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.o_img));
                    bottomLeftBtn.setTag(R.drawable.o_img);
                }
                bottomLeftBtn.setEnabled(false);
                isXturn = !isXturn;
                break;
            case R.id.bottommid:
                if(isXturn) {
                    bottomMidBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.x_img));
                    bottomMidBtn.setTag(R.drawable.x_img);
                } else {
                    bottomMidBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.o_img));
                    bottomMidBtn.setTag(R.drawable.o_img);
                }
                bottomMidBtn.setEnabled(false);
                isXturn = !isXturn;
                break;
            case R.id.bottomright:
                if(isXturn) {
                    bottomRightBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.x_img));
                    bottomRightBtn.setTag(R.drawable.x_img);
                } else {
                    bottomRightBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.o_img));
                    bottomRightBtn.setTag(R.drawable.o_img);
                }
                bottomRightBtn.setEnabled(false);
                isXturn = !isXturn;
                break;
        }
        checkWin();
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
