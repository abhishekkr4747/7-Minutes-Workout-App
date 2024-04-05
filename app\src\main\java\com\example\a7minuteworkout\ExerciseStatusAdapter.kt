**Folder Name:** com.example.a7minuteworkout

**File Name:** ExerciseStatusAdapter.kt

**Line by line documented Code:**

```kotlin
package com.example.a7minuteworkout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minuteworkout.databinding.ActivityExerciseBinding
import com.example.a7minuteworkout.databinding.ItemExerciseStatusBinding

class ExerciseStatusAdapter(val items: ArrayList<ExerciseModel>): RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {

    // ViewHolder class provides access to views for each list item
    class ViewHolder(binding: ItemExerciseStatusBinding):
    RecyclerView.ViewHolder(binding.root){
        val tvItem = binding.tvItem // textView to display exercise number

    }

    // Creates a new ViewHolder and inflates the list item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemExerciseStatusBinding.inflate(LayoutInflater.from(parent.context) ,
            parent , false))
    }

    // Returns the size of the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Binds the data to the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ExerciseModel = items[position]
        holder.tvItem.text = model.getId().toString() // Set textView text to exercise number

        // Set background color and text color based on exercise status
        when{
            model.getIsSelected()->{ // if exercise is selected
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context ,
                        R.drawable.item_circular_thin_accent_border) // set border
                holder.tvItem.setTextColor(Color.parseColor("#212121")) // set text colorblack
            }
            model.getIsCompleted()->{ // if exercise is completed
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context ,
                        R.drawable.circular_color_accent_background) // set background color
                holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))  // set text color to white
            }
            else -> { // if exercise is not selected or completed
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context ,
                        R.drawable.item_circular_color_gray_background)  // set default background color
                holder.tvItem.setTextColor(Color.parseColor("#212121"))  // set default text color to black
            }
        }

    }
}
```