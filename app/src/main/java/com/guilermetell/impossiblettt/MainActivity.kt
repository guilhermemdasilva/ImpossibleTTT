package com.guilermetell.impossiblettt

import android.os.AsyncTask
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var topLeftBtn: Button
    lateinit var topMidBtn: Button
    lateinit var topRightBtn: Button
    lateinit var midLeftBtn: Button
    lateinit var midMidBtn: Button
    lateinit var midRightBtn: Button
    lateinit var bottomLeftBtn: Button
    lateinit var bottomMidBtn: Button
    lateinit var bottomRightBtn: Button
    lateinit var resetBtn: Button
    internal var isXturn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        topLeftBtn = findViewById(R.id.topleft) as Button
        topMidBtn = findViewById(R.id.topmid) as Button
        topRightBtn = findViewById(R.id.topright) as Button
        midLeftBtn = findViewById(R.id.midleft) as Button
        midMidBtn = findViewById(R.id.midmid) as Button
        midRightBtn = findViewById(R.id.midright) as Button
        bottomLeftBtn = findViewById(R.id.bottomleft) as Button
        bottomMidBtn = findViewById(R.id.bottommid) as Button
        bottomRightBtn = findViewById(R.id.bottomright) as Button
        resetBtn = findViewById(R.id.resetbutton) as Button
        topLeftBtn.setOnClickListener(this)
        topMidBtn.setOnClickListener(this)
        topRightBtn.setOnClickListener(this)
        midLeftBtn.setOnClickListener(this)
        midMidBtn.setOnClickListener(this)
        midRightBtn.setOnClickListener(this)
        bottomLeftBtn.setOnClickListener(this)
        bottomMidBtn.setOnClickListener(this)
        bottomRightBtn.setOnClickListener(this)
        resetBtn.setOnClickListener {
            isXturn = true
            topLeftBtn.background = ContextCompat.getDrawable(this@MainActivity, R.color.white)
            topLeftBtn.tag = null
            topMidBtn.background = ContextCompat.getDrawable(this@MainActivity, R.color.white)
            topMidBtn.tag = null
            topRightBtn.background = ContextCompat.getDrawable(this@MainActivity, R.color.white)
            topRightBtn.tag = null

            midLeftBtn.background = ContextCompat.getDrawable(this@MainActivity, R.color.white)
            midLeftBtn.tag = null
            midMidBtn.background = ContextCompat.getDrawable(this@MainActivity, R.color.white)
            midMidBtn.tag = null
            midRightBtn.background = ContextCompat.getDrawable(this@MainActivity, R.color.white)
            midRightBtn.tag = null

            bottomLeftBtn.background = ContextCompat.getDrawable(this@MainActivity, R.color.white)
            bottomLeftBtn.tag = null
            bottomMidBtn.background = ContextCompat.getDrawable(this@MainActivity, R.color.white)
            bottomMidBtn.tag = null
            bottomRightBtn.background = ContextCompat.getDrawable(this@MainActivity, R.color.white)
            bottomRightBtn.tag = null

            enableButtons()
        }
        DoArtificialIntelligence().execute()
    }

    private inner class DoArtificialIntelligence : AsyncTask<String, String, String>() {

        override fun doInBackground(vararg params: String): String {
            return ""
        }
    }

    fun disableButtons() {
        topLeftBtn.isEnabled = false
        topMidBtn.isEnabled = false
        topRightBtn.isEnabled = false
        midLeftBtn.isEnabled = false
        midMidBtn.isEnabled = false
        midRightBtn.isEnabled = false
        bottomLeftBtn.isEnabled = false
        bottomMidBtn.isEnabled = false
        bottomRightBtn.isEnabled = false
    }

    fun enableButtons() {
        topLeftBtn.isEnabled = true
        topMidBtn.isEnabled = true
        topRightBtn.isEnabled = true
        midLeftBtn.isEnabled = true
        midMidBtn.isEnabled = true
        midRightBtn.isEnabled = true
        bottomLeftBtn.isEnabled = true
        bottomMidBtn.isEnabled = true
        bottomRightBtn.isEnabled = true
    }

    fun checkWin() {

        //horizontal
        if (topLeftBtn.tag != null && topMidBtn.tag != null && topRightBtn.tag != null &&
                (topLeftBtn.tag as Int).toInt() == (topMidBtn.tag as Int).toInt() && (topLeftBtn.tag as Int).toInt() == (topRightBtn.tag as Int).toInt() ||
                midLeftBtn.tag != null && midMidBtn.tag != null && midRightBtn.tag != null &&
                        (midLeftBtn.tag as Int).toInt() == (midMidBtn.tag as Int).toInt() && (midLeftBtn.tag as Int).toInt() == (midRightBtn.tag as Int).toInt() ||
                bottomLeftBtn.tag != null && bottomMidBtn.tag != null && bottomRightBtn.tag != null &&
                        (bottomLeftBtn.tag as Int).toInt() == (bottomMidBtn.tag as Int).toInt() && (bottomLeftBtn.tag as Int).toInt() == (bottomRightBtn.tag as Int).toInt() ||

                //vertical
                topLeftBtn.tag != null && midLeftBtn.tag != null && bottomLeftBtn.tag != null &&
                        (topLeftBtn.tag as Int).toInt() == (midLeftBtn.tag as Int).toInt() && (topLeftBtn.tag as Int).toInt() == (bottomLeftBtn.tag as Int).toInt() ||
                topMidBtn.tag != null && midMidBtn.tag != null && bottomMidBtn.tag != null &&
                        (topMidBtn.tag as Int).toInt() == (midMidBtn.tag as Int).toInt() && (topMidBtn.tag as Int).toInt() == (bottomMidBtn.tag as Int).toInt() ||
                topRightBtn.tag != null && midRightBtn.tag != null && bottomRightBtn.tag != null &&
                        (topRightBtn.tag as Int).toInt() == (midRightBtn.tag as Int).toInt() && (topRightBtn.tag as Int).toInt() == (bottomRightBtn.tag as Int).toInt() ||

                //diagonal
                topLeftBtn.tag != null && midMidBtn.tag != null && bottomRightBtn.tag != null &&
                        (topLeftBtn.tag as Int).toInt() == (midMidBtn.tag as Int).toInt() && (topLeftBtn.tag as Int).toInt() == (bottomRightBtn.tag as Int).toInt() ||
                topRightBtn.tag != null && midMidBtn.tag != null && bottomLeftBtn.tag != null &&
                        (topRightBtn.tag as Int).toInt() == (midMidBtn.tag as Int).toInt() && (topRightBtn.tag as Int).toInt() == (bottomLeftBtn.tag as Int).toInt()) {

            Toast.makeText(this, "GAME ENDED!", Toast.LENGTH_LONG).show()
            disableButtons()
        }


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.topleft -> {
                if (isXturn) {
                    topLeftBtn.background = ContextCompat.getDrawable(this, R.drawable.x_img)
                    topLeftBtn.tag = R.drawable.x_img
                } else {
                    topLeftBtn.background = ContextCompat.getDrawable(this, R.drawable.o_img)
                    topLeftBtn.tag = R.drawable.o_img
                }
                topLeftBtn.isEnabled = false
                isXturn = !isXturn
            }
            R.id.topmid -> {
                if (isXturn) {
                    topMidBtn.background = ContextCompat.getDrawable(this, R.drawable.x_img)
                    topMidBtn.tag = R.drawable.x_img
                } else {
                    topMidBtn.background = ContextCompat.getDrawable(this, R.drawable.o_img)
                    topMidBtn.tag = R.drawable.o_img
                }
                topMidBtn.isEnabled = false
                isXturn = !isXturn
            }
            R.id.topright -> {
                if (isXturn) {
                    topRightBtn.background = ContextCompat.getDrawable(this, R.drawable.x_img)
                    topRightBtn.tag = R.drawable.x_img
                } else {
                    topRightBtn.background = ContextCompat.getDrawable(this, R.drawable.o_img)
                    topRightBtn.tag = R.drawable.o_img
                }
                topRightBtn.isEnabled = false
                isXturn = !isXturn
            }
            R.id.midleft -> {
                if (isXturn) {
                    midLeftBtn.background = ContextCompat.getDrawable(this, R.drawable.x_img)
                    midLeftBtn.tag = R.drawable.x_img
                } else {
                    midLeftBtn.background = ContextCompat.getDrawable(this, R.drawable.o_img)
                    midLeftBtn.tag = R.drawable.o_img
                }
                midLeftBtn.isEnabled = false
                isXturn = !isXturn
            }
            R.id.midmid -> {
                if (isXturn) {
                    midMidBtn.background = ContextCompat.getDrawable(this, R.drawable.x_img)
                    midMidBtn.tag = R.drawable.x_img
                } else {
                    midMidBtn.background = ContextCompat.getDrawable(this, R.drawable.o_img)
                    midMidBtn.tag = R.drawable.o_img
                }
                midMidBtn.isEnabled = false
                isXturn = !isXturn
            }
            R.id.midright -> {
                if (isXturn) {
                    midRightBtn.background = ContextCompat.getDrawable(this, R.drawable.x_img)
                    midRightBtn.tag = R.drawable.x_img
                } else {
                    midRightBtn.background = ContextCompat.getDrawable(this, R.drawable.o_img)
                    midRightBtn.tag = R.drawable.o_img
                }
                midRightBtn.isEnabled = false
                isXturn = !isXturn
            }
            R.id.bottomleft -> {
                if (isXturn) {
                    bottomLeftBtn.background = ContextCompat.getDrawable(this, R.drawable.x_img)
                    bottomLeftBtn.tag = R.drawable.x_img
                } else {
                    bottomLeftBtn.background = ContextCompat.getDrawable(this, R.drawable.o_img)
                    bottomLeftBtn.tag = R.drawable.o_img
                }
                bottomLeftBtn.isEnabled = false
                isXturn = !isXturn
            }
            R.id.bottommid -> {
                if (isXturn) {
                    bottomMidBtn.background = ContextCompat.getDrawable(this, R.drawable.x_img)
                    bottomMidBtn.tag = R.drawable.x_img
                } else {
                    bottomMidBtn.background = ContextCompat.getDrawable(this, R.drawable.o_img)
                    bottomMidBtn.tag = R.drawable.o_img
                }
                bottomMidBtn.isEnabled = false
                isXturn = !isXturn
            }
            R.id.bottomright -> {
                if (isXturn) {
                    bottomRightBtn.background = ContextCompat.getDrawable(this, R.drawable.x_img)
                    bottomRightBtn.tag = R.drawable.x_img
                } else {
                    bottomRightBtn.background = ContextCompat.getDrawable(this, R.drawable.o_img)
                    bottomRightBtn.tag = R.drawable.o_img
                }
                bottomRightBtn.isEnabled = false
                isXturn = !isXturn
            }
        }
        checkWin()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
