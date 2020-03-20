package com.iulian.spinner_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

//made quick to solve an issue with sorting arrays in kotlin
class MainActivity : AppCompatActivity(),AdapterView. OnItemSelectedListener{

    var map = mutableMapOf("question1" to 0, "question2" to 0, "question3" to 0, "question4" to 0)
    var questions:ArrayList<String> = ArrayList(map.keys)

    var spinner:Spinner? = null
    var spinner1:Spinner? = null

    var selected:String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //create spinner 1
        createSpinner1()
        //create spinner 2
        createSpinner2()

    }

    fun createSpinner1(){

        spinner = this.spinner_sample
        spinner!!.setOnItemSelectedListener(this)

        // Create questions array
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, questions)
        // Set layout to use when the list of choices appear
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.setAdapter(spinnerAdapter)
    }

    fun createSpinner2(){

        spinner1 = this.spinner_sample1
        spinner1!!.setOnItemSelectedListener(this)

        // Create questions array
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, questions)
        // Set layout to use when the list of choices appear
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner1!!.setAdapter(spinnerAdapter)

    }

    override fun onItemSelected(arg0: AdapterView<*>, view: View, position: Int, id: Long) {

        //reset the first element that is auto selected by the adapter - find a better way
        map.put(questions[position] , 0)
        // clean all map before selecting new all the time
        //reset the listArray before selecting - find a better way
        for (i in 0..3) {
            map.put(questions[i] , 0)
        }
        if(arg0.id == R.id.spinner_sample)

        {
            // create a method to deal with all of this and apply it to all the spinners
            // mark the selected question in the map
            map.put(questions[position], 1)
            //output values
            println("map key: " + map.values)
            //filter map values == 0
            val filteredKeysMap = map.filterValues { it == 0 }
            //output map keys
            println("map key: " + filteredKeysMap.keys)
            //recreate the arrayList here from filteredKeysMap.keys
            var test:ArrayList<String> = ArrayList(filteredKeysMap.keys)
            println("map key: " + test.size)
            // add filter by map key: in logcat
            // done in one hour or two so please refactor since this is a POC
            //make sure you have populated the main array with values based on keys from ilteredKeysMap.keys
            // your method should return an listArray as a single source of truth
        }
        else if(arg0.id == R.id.spinner_sample1)
        {
            // use the same method you have done to deal with spinners

        }

    }


    override fun onNothingSelected(arg0: AdapterView<*>) {
        println("nothing ")
    }
}