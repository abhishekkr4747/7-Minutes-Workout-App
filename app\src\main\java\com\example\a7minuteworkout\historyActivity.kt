**Folder Name:** com.example.a7minuteworkout

**File Name:** historyActivity.kt

**Line by Line Documented Code:**

```kotlin
package com.example.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a7minuteworkout.databinding.ActivityHistoryBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class historyActivity : AppCompatActivity() {

    private var binding: ActivityHistoryBinding? = null // Declare binding variable to access the UI elements

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater) // Inflate the layout using the binding variable
        setContentView(binding?.root) // Set the root view of the activity from the binding variable

        setSupportActionBar(binding?.toolbarHistory) // Set the toolbar as the app bar for the activity
        if(supportActionBar != null) { // Check if the support action bar is not null
            supportActionBar?.setDisplayHomeAsUpEnabled(true) // Enable the back button in the action bar
            supportActionBar?.title = "HISTORY" // Set the title of the action bar
        }
        binding?.toolbarHistory?.setNavigationOnClickListener { // Set the navigation click listener for the back button
            onBackPressed() // Go back to the previous activity
        }

        val dao = (application as WorkOutApp).db.historyDao() // Get the HistoryDao instance from the database
        getAllCompletedDates(dao) // Call the getAllCompletedDates function to fetch the completed dates from the database
    }

    private fun getAllCompletedDates(historyDao: HistoryDao) { // Function to fetch all the completed dates from the database

        lifecycleScope.launch { // Launch a coroutine scope for asynchronous operations
            historyDao.fetchAllDates().collect { allCompletedDatesList-> // Collect the flow of all completed dates from the database
               if(allCompletedDatesList.isNotEmpty()) { // Check if the list of completed dates is not empty
                   binding?.tvHistory?.visibility = View.VISIBLE // Make the history text view visible
                   binding?.rvHistory?.visibility = View.VISIBLE // Make the history recycler view visible
                   binding?.tvNoDataAvailable?.visibility = View.INVISIBLE // Make the no data available text view invisible

                   binding?.rvHistory?.layoutManager = LinearLayoutManager(this@historyActivity) // Set the layout manager for the recycler view

                   val dates = ArrayList<String>() // Create an array list to store the completed dates
                   for(date in allCompletedDatesList) { // Iterate over the list of completed dates
                       dates.add(date.date) // Add the date to the array list
                   }

                   val historyAdapter = HistoryAdapter(dates) // Create an instance of the history adapter
                   binding?.rvHistory?.adapter = historyAdapter // Set the adapter for the recycler view
                   
               }else { // If the list of completed dates is empty
                   binding?.tvHistory?.visibility = View.INVISIBLE // Make the history text view invisible
                   binding?.rvHistory?.visibility = View.INVISIBLE // Make the history recycler view invisible
                   binding?.tvNoDataAvailable?.visibility = View.VISIBLE // Make the no data available text view visible
               }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null // Clear the binding variable when the activity is destroyed
    }
}
```