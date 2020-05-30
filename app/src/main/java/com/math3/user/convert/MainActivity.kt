package com.math3.user.convert

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val exchange: Array<Array<Double> > = arrayOf(arrayOf(1.0, 78.55, 74.0, 87.06, 2.63),arrayOf(0.013, 1.0, 0.9, 1.11, 0.034),arrayOf(0.014, 1.11, 1.0, 1.23, 0.037),arrayOf(0.011, 0.9, 0.81, 1.0, 0.3),arrayOf(0.38, 29.62, 26.91, 33.0, 1.0));

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinnerTop = findViewById<Spinner>(R.id.spinnerFirst);
        val spinnerBottom = findViewById<Spinner>(R.id.spinnerSecond);
        spinnerBottom.setSelection(1);
        val editText = findViewById<EditText>(R.id.editText);
        val textView = findViewById<TextView>(R.id.textView);
        val linearLayoutBottom = findViewById<LinearLayout>(R.id.linearLayoutButtom);
        linearLayoutBottom.setVisibility(View.INVISIBLE);

        spinnerTop.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                itemSelected: View, selectedItemPosition: Int, selectedId: Long
            ) {
                val s:String=editText.getText().toString();
                if(s.equals("")){
                    linearLayoutBottom.setVisibility(View.INVISIBLE);
                }else {
                    linearLayoutBottom.setVisibility(View.VISIBLE);
                    val checkTop: Int = spinnerTop.getSelectedItemId().toString().toInt();
                    val checkBottom: Int = spinnerBottom.getSelectedItemId().toString().toInt();

                    val sum: Int = (s.toString()).toInt();

                    textView.setText(((sum.toFloat()) / exchange[checkTop][checkBottom]).toString());
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        spinnerBottom.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                itemSelected: View, selectedItemPosition: Int, selectedId: Long
            ) {
                val s:String=editText.getText().toString();
                if(s.equals("")){
                    linearLayoutBottom.setVisibility(View.INVISIBLE);
                }else {
                    linearLayoutBottom.setVisibility(View.VISIBLE);
                    val checkTop: Int = spinnerTop.getSelectedItemId().toString().toInt();
                    val checkBottom: Int = spinnerBottom.getSelectedItemId().toString().toInt();

                    val sum: Int = (s.toString()).toInt();

                    textView.setText(((sum.toFloat()) / exchange[checkTop][checkBottom]).toString());

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        editText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
                if(s.toString().equals("")){
                    linearLayoutBottom.setVisibility(View.INVISIBLE);
                }else {
                    linearLayoutBottom.setVisibility(View.VISIBLE);
                    val checkTop: Int = spinnerTop.getSelectedItemId().toString().toInt();
                    val checkBottom: Int = spinnerBottom.getSelectedItemId().toString().toInt();

                    val sum: Int = (s.toString()).toInt();

                    textView.setText(((sum.toFloat()) / exchange[checkTop][checkBottom]).toString());
                }

                // действия, когда вводится какой то текст
                // s - то, что вводится, для преобразования в строку - s.toString()
            }

            override fun afterTextChanged(editable: Editable) {

                // действия после того, как что то введено
                // editable - то, что введено. В строку - editable.toString()
            }

            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {

                // действия перед тем, как что то введено
            }
        })
    }
}