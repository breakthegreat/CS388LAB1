package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var counter = 0
    var goals = 0
    var steps = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val upgradeButton = findViewById<Button>(R.id.upgrade)
        val goal = findViewById<TextView>(R.id.goal)



        button.setOnClickListener {
            counter++;
            textView.text = counter.toString()
            Toast.makeText(it.context, "Adding 1!", Toast.LENGTH_SHORT).show()
            if((counter % 10) == 0){
                goals++
                goal.text = "You've reached : "+  counter+ " clicks!\n Goals Streak : " + goals.toString() + "\n"

            }


            if(counter >= 10){

                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    Toast.makeText(it.context, "Adding 2 each click !", Toast.LENGTH_SHORT).show()

                    button.setOnClickListener {
                        counter += 2
                        steps+=2
                        textView.text = counter.toString()
                        if((steps % 10) == 0){
                            goals++
                            if(counter%10 == 0){

                                goal.text = "You've reached : "+  counter+ " clicks!\n Goals Streak : " + goals.toString() + "\n"

                            }



                        }


                    }
                    upgradeButton.visibility = View.INVISIBLE

                }

            }



        }

    }
}