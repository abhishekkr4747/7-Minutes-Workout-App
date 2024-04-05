**Folder:** **com.example.a7minuteworkout**

**File:** **Constants.kt**

**Line by Line Documented Code:**

```kotlin
// package is the root module or directory for this code base.
package com.example.a7minuteworkout

// an object declaration in Kotlin, and it can have properties and methods
// a companion object is a special type of object that is associated with a class or interface.
// It can be used to define properties and methods that are common to all instances of the class or interface.
object Constants {

    // fun is used to define a function in Kotlin.
    // defaultExerciseList() is a function that returns an ArrayList of ExerciseModel objects.
    fun defaultExerciseList(): ArrayList<ExerciseModel> {
        // ArrayList<ExerciseModel>() is a constructor to create an ArrayList of ExerciseModel objects.
        val exerciseList = ArrayList<ExerciseModel>()

        // val is used to declare a variable that cannot be reassigned.
        // jumpingJacks is a variable of type ExerciseModel and it is initialized with a new instance of ExerciseModel.
        val jumpingJacks = ExerciseModel(
            // 1 is the id of the exercise.
            1,
            // "Jumping Jacks" is the name of the exercise.
            "Jumping Jacks",
            // R.drawable.ic_jumping_jacks is the resource id of the image for the exercise.
            R.drawable.ic_jumping_jacks,
            // false indicates that the exercise is not done.
            false,
            // false indicates that the exercise is not selected.
            false
        )

        // exerciseList.add(jumpingJacks) adds the jumpingJacks object to the exerciseList.
        exerciseList.add(jumpingJacks)

        // Similar to jumpingJacks, highKneesRunningInPlace is initialized and added to exerciseList.
        val highKneesRunningInPlace = ExerciseModel(
            2,
            "High Knees Running In Place",
            R.drawable.ic_high_knees_running_in_place,
            false,
            false
        )
        exerciseList.add(highKneesRunningInPlace)

        // Similar to jumpingJacks, lunge is initialized and added to exerciseList.
        val lunge = ExerciseModel(
            3,
            "Lunge",
            R.drawable.ic_lunge,
            false,
            false
        )
        exerciseList.add(lunge)

        // Similar to jumpingJacks, squat is initialized and added to exerciseList.
        val squat = ExerciseModel(
            4,
            "Squats",
            R.drawable.ic_squat,
            false,
            false
        )
        exerciseList.add(squat)

        // Similar to jumpingJacks, abdominalCrunch is initialized and added to exerciseList.
        val abdominalCrunch = ExerciseModel(
            5,
            "Abdominal Crunch",
            R.drawable.ic_abdominal_crunch,
            false,
            false
        )
        exerciseList.add(abdominalCrunch)

        // Similar to jumpingJacks, pushUp is initialized and added to exerciseList.
        val pushUp = ExerciseModel(
            6,
            "Push Ups",
            R.drawable.ic_push_up,
            false,
            false
        )
        exerciseList.add(pushUp)

        // Similar to jumpingJacks, pushUpAndRotation is initialized and added to exerciseList.
        val pushUpAndRotation = ExerciseModel(
            7,
            "Push Ups And Rotations",
            R.drawable.ic_push_up_and_rotation,
            false,
            false
        )
        exerciseList.add(pushUpAndRotation)

        // Similar to jumpingJacks, plank is initialized and added to exerciseList.
        val plank = ExerciseModel(
            8,
            "Plank",
            R.drawable.ic_plank,
            false,
            false
        )
        exerciseList.add(plank)

        // Similar to jumpingJacks, sidePlank is initialized and added to exerciseList.
        val sidePlank = ExerciseModel(
            9,
            "Side Plank",
            R.drawable.ic_side_plank,
            false,
            false
        )
        exerciseList.add(sidePlank)

        // Similar to jumpingJacks, wallSit is initialized and added to exerciseList.
        val wallSit = ExerciseModel(
            10,
            "Wall Sit",
            R.drawable.ic_wall_sit,
            false,
            false
        )
        exerciseList.add(wallSit)

        // Similar to jumpingJacks, stepUpOntoChair is initialized and added to exerciseList.
        val stepUpOntoChair = ExerciseModel(
            11,
            "Step Up Onto Chair",
            R.drawable.ic_step_up_onto_chair,
            false,
            false
        )
        exerciseList.add(stepUpOntoChair)

        // Similar to jumpingJacks, tricepsDipOnChair is initialized and added to exerciseList.
        val tricepsDipOnChair = ExerciseModel(
            12,
            "Triceps Dip On Chair",
            R.drawable.ic_triceps_dip_on_chair,
            false,
            false
        )
        exerciseList.add(tricepsDipOnChair)

        // return keyword returns the exerciseList from the function.
        return exerciseList
    }
}
```