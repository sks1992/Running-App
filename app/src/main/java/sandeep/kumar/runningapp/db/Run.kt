package sandeep.kumar.runningapp.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")//2
data class Run(//1
    var image: Bitmap? = null,
    var timestamp: Long = 0L,
    var averageSpeed: Float = 0f,
    var distanceInMeters: Int = 0,
    var timeInMillis: Long = 0L,
    var caloriesBurned: Int = 0
) {
    @PrimaryKey(autoGenerate = true)//3
    var id :Int? =null
}
/*
* 1.we make run as dataclass because we want to save it in database
* 2.@Entity annotation tells room that this is a dataClass table
* we use tableName for specify table name
* 3.we crete primary key in body because we want to create run object without
* specifying it in run object when it created .Room will automatically generate
* id for us.
* */