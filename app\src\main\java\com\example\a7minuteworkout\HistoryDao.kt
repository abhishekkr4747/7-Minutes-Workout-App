**Folder Name:** com.example.a7minuteworkout

**File Name:** HistoryDao.kt

**Documented Code:**

```kotlin
package com.example.a7minuteworkout

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// Data Access Object (DAO) for the History table
@Dao
interface HistoryDao {

    /**
     * Insert a new history entity into the database.
     *
     * @param historyEntity The HistoryEntity to be inserted.
     */
    @Insert
    suspend fun insert(historyEntity: HistoryEntity)

    /**
     * Fetch all the dates from the History table.
     *
     * Returns a Flow of List of HistoryEntity.
     * Flow is used for asynchronous data retrieval and ensures that the data is always up-to-date.
     */
    @Query("SELECT * FROM `history-table`")
    fun fetchAllDates(): Flow<List<HistoryEntity>>
}
```