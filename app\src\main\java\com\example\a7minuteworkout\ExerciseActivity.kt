**Folder Name:** com.example.a7minuteworkout

**File Name:** ExerciseActivity.kt

**Original Code Snippet with Line-by-Line Explanation:**

```kotlin
// Importing necessary packages
import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a7minuteworkout.databinding.ActivityExerciseBinding
import com.example.a7minuteworkout.databinding.CustomDialogBackConfirmationBinding
import java.util.Locale

class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    // Binding the layout file to the activity
    private var binding: ActivityExerciseBinding? = null
    // Creating a CountDownTimer for the rest period
    private var restTimer: CountDownTimer? = null
    // Progress of the rest period
    private var restProgress = 0
    // Creating a CountDownTimer for the exercise period
    private var exerciseTimer: CountDownTimer? = null
    // Progress of the exercise period
    private var exerciseProgress = 0
    // List of exercises
    private var exerciseList : ArrayList<ExerciseModel>? = null
    // Current position of the exercise
    private var currentExercisePosittion = -1
    // TextToSpeech object
    private var tts: TextToSpeech? = null
    // MediaPlayer object
    private var player: MediaPlayer? = null
    // Adapter for the RecyclerView of exercise status
    private var exerciseAdapter: ExerciseStatusAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflating the layout file
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        // Setting the content view
        setContentView(binding?.root)

        // Setting up the toolbar
        setSupportActionBar(binding?.toolBarExercise)

        // If the support action bar is not null, enable the back button
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        // Setting up the listener for the back button
        binding?.toolBarExercise?.setNavigationOnClickListener {
            customDialogForBackButton()
        }

        // Getting the list of exercises
        exerciseList = Constants.defaultExerciseList()

        // Initializing the TextToSpeech object
        tts = TextToSpeech(this , this)



        // Setting up the rest view
        setupRestView()
        // Setting up the RecyclerView of exercise status
        setUpExerciseStatusRecyclerView()
    }

    override fun onBackPressed() {
        // When the back button is pressed, show a custom dialog
        customDialogForBackButton()
    }

    private fun customDialogForBackButton() {
        // Creating a custom dialog
        val customDialog = Dialog(this)
        // Inflating the layout for the custom dialog
        val dialogBinding = CustomDialogBackConfirmationBinding.inflate(layoutInflater)
        // Setting the content view of the custom dialog
        customDialog.setContentView(dialogBinding.root)
        // Setting the custom dialog to not be canceled when touched outside
        customDialog.setCanceledOnTouchOutside(false)
        // Setting up the onClickListener for the "Yes" button
        dialogBinding.btnYes.setOnClickListener {
            // Finishing the activity
            this@ExerciseActivity.finish()
            // Dismissing the custom dialog
            customDialog.dismiss()
        }
        // Setting up the onClickListener for the "No" button
        dialogBinding.btnNo.setOnClickListener {
            // Dismissing the custom dialog
            customDialog.dismiss()
        }

        // Showing the custom dialog
        customDialog.show()
    }

    private fun setUpExerciseStatusRecyclerView(){
        // Setting up the layout manager for the RecyclerView
        binding?.rvExerciseStatus?.layoutManager =
            LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false)
        // Creating an adapter for the RecyclerView
        exerciseAdapter = ExerciseStatusAdapter(exerciseList!!)
        // Setting the adapter to the RecyclerView
        binding?.rvExerciseStatus?.adapter = exerciseAdapter
    }

    private fun setupRestView(){

        try {
            // Getting the URI of the sound file
            val soundURI = Uri.parse("android.resource://com.example.a7minuteworkout/" +
                    R.raw.app_src_main_res_raw_press_start)
            // Creating a MediaPlayer object
            player = MediaPlayer.create(applicationContext , soundURI)
            // Setting the player to loop
            player?.isLooping = false
            // Starting the player
            player?.start()
        }catch (e: Exception){
            // Handling the exception
            e.printStackTrace()
        }

        // Setting the visibility of the views
        binding?.flprogressBar?.visibility = View.VISIBLE
        binding?.tvTitle?.visibility = View.VISIBLE
        binding?.upcomingExercise?.visibility = View.VISIBLE
        binding?.exerciseName?.visibility = View.VISIBLE
        binding?.tvExerciseName?.visibility = View.INVISIBLE
        binding?.flExercise?.visibility = View.INVISIBLE
        binding?.ivImage?.visibility = View.INVISIBLE

        // Canceling the rest timer
        if(restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        // Setting the name of the upcoming exercise
        binding?.exerciseName?.text = exerciseList!![currentExercisePosittion + 1].getName()

        // Setting up the progress bar for the rest period
        setRestProgressBar()
    }

    private fun setupExerciseView(){
        // Setting the visibility of the views
        binding?.flprogressBar?.visibility = View.INVISIBLE
        binding?.tvTitle?.visibility = View.INVISIBLE
        binding?.upcomingExercise?.visibility = View.INVISIBLE
        binding?.exerciseName?.visibility = View.INVISIBLE
        binding?.tvExerciseName?.visibility = View.VISIBLE
        binding?.flExercise?.visibility = View.VISIBLE
        binding?.ivImage?.visibility = View.VISIBLE
        // Canceling the exercise timer
        if(exerciseTimer != null){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }

        // Speaking out the name of the exercise
        speakOut(exerciseList!![currentExercisePosittion].getName())

        // Setting the image for the exercise
        binding?.ivImage?.setImageResource(exerciseList!![currentExercisePosittion].getImage())
        // Setting the name of the exercise
        binding?.tvExerciseName?.text = exerciseList!![currentExercisePosittion].getName()

        // Setting up the progress bar for the exercise period
        setExerciseProgressBar()
    }

    private fun setRestProgressBar(){
        // Setting the progress of the progress bar
        binding?.progressBar?.progress = restProgress

        restTimer = object : CountDownTimer(10000 , 1000){
            override fun onTick(millisUntilFinished: Long) {
                // Incrementing the progress of the progress bar
                restProgress++
                // Setting the progress of the progress bar
                binding?.progressBar?.progress = (10 - restProgress)
                // Setting the text of the timer
                binding?.tvTimer?.text = (10 - restProgress).toString()
            }

            override fun onFinish() {
                // Incrementing the position of the current exercise
                currentExercisePosittion++
                // Setting the current exercise as selected
                exerciseList!![currentExercisePosittion].setIsSelected(true)
                // Notifying the adapter of the change
                exerciseAdapter!!.notifyDataSetChanged()
                // Setting up the view for the exercise
                setupExerciseView()