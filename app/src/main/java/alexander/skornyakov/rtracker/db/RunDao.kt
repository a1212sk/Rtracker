package alexander.skornyakov.rtracker.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsOrderedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeed DESC")
    fun getAllRunsOrderedByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distance DESC")
    fun getAllRunsOrderedByDistance(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY time DESC")
    fun getAllRunsOrderedByTime(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY calories DESC")
    fun getAllRunsOrderedByCalories(): LiveData<List<Run>>

    @Query("SELECT SUM(time) FROM running_table")
    fun getTotalTime(): LiveData<Long>

    @Query("SELECT SUM(calories) FROM running_table")
    fun getTotalCalories(): LiveData<Int>

    @Query("SELECT SUM(distance) FROM running_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT AVG(avgSpeed) FROM running_table")
    fun getTotalAvgSpeed(): LiveData<Float>
}