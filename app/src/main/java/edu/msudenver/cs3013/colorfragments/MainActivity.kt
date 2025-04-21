package edu.msudenver.cs3013.colorfragments

import android.util.Log
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), ChoiceFragment.ChoiceListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (savedInstanceState == null) {
            var cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container)
            val choiceFragment = ChoiceFragment()
            supportFragmentManager.beginTransaction()
                .add(cfv.id, choiceFragment)
                .commit()
        }
    }

    override fun onSelected(choice: Int) {
        Log.d("MainActivity", "onSelected called with choice: $choice") // Debugging log
        val fcv = findViewById<FragmentContainerView>(R.id.lowerfragment_container)
        findViewById<FragmentContainerView>(
            R.id.lowerfragment_container).let { frameLayout ->
            val colorFragment = ColorFragment.newInstance(choice)
            supportFragmentManager.beginTransaction()
                .replace(fcv.id, colorFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}