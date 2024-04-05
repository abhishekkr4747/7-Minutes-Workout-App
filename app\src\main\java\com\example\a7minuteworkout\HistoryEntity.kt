**Folder Name:** com.example.a7minuteworkout

**File Name:** HistoryEntity.kt

**Line by Line Documented Code:**

```
package com.example.a7minuteworkout

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity class to represent a row in a database table named 'history-table'
@Entity(tableName = "history-table")

// Data class to hold the date of a workout session
data class HistoryEntity(

    // Primary key of the table, represents the date of the workout session
    @PrimaryKey
    val date: String
)
```