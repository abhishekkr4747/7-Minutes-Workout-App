**Folder Name: ** com.example.a7minuteworkout

**File Name: ** HistoryDatabase.kt

```kotlin
package com.example.a7minuteworkout

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HistoryEntity::class] , version = 1)
abstract class HistoryDatabase: RoomDatabase() {

    abstract fun historyDao(): HistoryDao

    companion object {

        @Volatile
        private var INSTANCE: HistoryDatabase? = null

        fun getInstance(context: Context): HistoryDatabase{

            synchronized(this){

                var instance = INSTANCE

                if(instance==null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext ,
                        HistoryDatabase::class.java ,
                        "history_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return  instance
            }
        }
    }
}
```

**Line - by - Line Documentation:**

1. **package com.example.a7minuteworkout;** - This line specifies the Java package to which this Kotlin file belongs.

2. **import android.content.Context;** - This line imports the Context class from the Android SDK, which represents the environment in which an application is running.

3. **import androidx.room.Database;** - This line imports the Database annotation from the Room persistence library, which is used to define database entities and their schema.

4. **import androidx.room.Room;** - This line imports the Room class from the Room persistence library, which is used to create and manage database instances.

5. **import androidx.room.RoomDatabase;** - This line imports the RoomDatabase abstract class from the Room persistence library, which represents the base class for all Room databases.

6. **@Database(entities = [HistoryEntity::class] , version = 1)** - This line defines the HistoryDatabase class as a Room database with the following properties:

```kotlin
   @Database(entities = [HistoryEntity::class] , version = 1)
```

   - **entities:** Specifies the entities (tables) that will be stored in this database. In this case, it's the HistoryEntity class.
   - **version:** Specifies the version of the database schema. When the schema changes, the version number should be incremented.

7. **abstract class HistoryDatabase: RoomDatabase()** - This line defines the HistoryDatabase class as an abstract subclass of RoomDatabase.

8. **abstract fun historyDao(): HistoryDao** - This line declares an abstract function named historyDao() that will return an instance of the HistoryDao interface.

9. **companion object { ... }** - This line defines a companion object for the HistoryDatabase class, which can contain static members and functions.

10. **@Volatile private var INSTANCE: HistoryDatabase? = null** - This line declares a volatile private variable named INSTANCE, which will store the singleton instance of the HistoryDatabase.

11. **fun getInstance(context: Context): HistoryDatabase** - This function is used to get the singleton instance of the HistoryDatabase. It takes a Context object as a parameter.

12. **synchronized(this){ ... }** - This block of code ensures that only one thread can access the getInstance() function at a time.

13. **var instance = INSTANCE** - This line gets the current value of the INSTANCE variable.

14. **if(instance==null) { ... }** - This block of code checks if the INSTANCE variable is null, which means the database has not been created yet.

15. **instance = Room.databaseBuilder( ... ).build()** - This line creates a new instance of the HistoryDatabase using the Room.databaseBuilder() method.

16. **INSTANCE = instance** - This line sets the INSTANCE variable to the newly created database instance.

17. **return instance** - This line returns the instance of the HistoryDatabase.

18. **}** - This line closes the companion object block.