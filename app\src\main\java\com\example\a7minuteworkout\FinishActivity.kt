**Folder Name:** com.example.a7minuteworkout.finish

**File Name:** FinishActivity.kt

**Documented Code:**

```kotlin
package com.example.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.a7minuteworkout.databinding.ActivityFinishBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FinishActivity : AppCompatActivity() {
    private var binding: ActivityFinishBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)  // binds the activity layout to the binding object
        setContentView(binding?.root)  // sets the activity content view to the binding root (i.e., the layout)

        // Set toolbar and enable back navigation
        setSupportActionBar(binding?.finishToolbar)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.finishToolbar?.setNavigationOnClickListener{
            onBackPressed()  // handles back navigation by calling the onBackPressed() function
        }

        // Set 'Finish' button click listener
        binding?.btnFinish?.setOnClickListener{
            finish()  // finishes the activity
        }

        // Get access to the HistoryDao from the database
        val dao = (application as WorkOutApp).db.historyDao()
        addDateToDatabase(dao)
    }

    // Function to add a date to the database
    private fun addDateToDatabase(historyDao: HistoryDao) {
        // Get current date and time
        val c = Calendar.getInstance()
        val dateTime = c.time
        Log.e("Date: " , ""+dateTime)

        // Format the date to a readable string
        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss" , Locale.getDefault())
        val date = sdf.format(dateTime)
        Log.e("Formatted date : " , ""+date)

        // Launch a coroutine to insert the date into the database
        lifecycleScope.launch{
            historyDao.insert(HistoryEntity(date))  // inserts the formatted date into the database using the given HistoryEntity
        }
    }
}
```