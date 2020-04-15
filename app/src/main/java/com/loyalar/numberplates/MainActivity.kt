package com.loyalar.numberplates

import android.content.Context
import android.os.Bundle
import android.text.InputType
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.input.input
import com.loyalar.numberplates.Logic.NumberPlate
import com.loyalar.numberplates.Logic.TinyDB

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val dialog: MaterialDialog = MaterialDialog(this).show {
                title(text = "")
                message(text = "")
                customView(viewRes = R.layout.add_dialog, horizontalPadding = true)
                positiveButton(R.string.add) { dialog ->
                    
                    dialog.dismiss()
                }
                negativeButton (R.string.cancel) { dialog ->
                    dialog.dismiss()
                }
            }
            dialog.show()

        }

        val numberPlatesArray = ArrayList<Any?>()
        val tinyDB = TinyDB(this)

        tinyDB.putListObject(getString(R.string.numberplate_array), numberPlatesArray)
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
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
