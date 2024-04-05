**Folder Name:** com.example.a7minuteworkout

**File Name:** ExerciseModel.java

```java
// Class to represent an exercise
public class ExerciseModel {

    // Attributes of an exercise
    private int id;
    private String name;
    private int image;
    private boolean isCompleted;
    private boolean isSelected;

    // Constructor to initialize the attributes
    public ExerciseModel(int id, String name, int image, boolean isCompleted, boolean isSelected) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.isCompleted = isCompleted;
        this.isSelected = isSelected;
    }

    // Getters and setters for each attribute

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
```