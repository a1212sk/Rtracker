package alexander.skornyakov.rtracker.repositories

import alexander.skornyakov.rtracker.db.Run
import alexander.skornyakov.rtracker.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
){

    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsSortedByDate() = runDao.getAllRunsOrderedByDate()

    fun getAllRunsSortedByAvgSpeed() = runDao.getAllRunsOrderedByAvgSpeed()

    fun getAllRunsSortedByCalories() = runDao.getAllRunsOrderedByCalories()

    fun getAllRunsSortedByDistance() = runDao.getAllRunsOrderedByDistance()

    fun getAllRunsSortedByTime() = runDao.getAllRunsOrderedByTime()

    fun getTotalAvgSpeed() = runDao.getTotalAvgSpeed()

    fun getTotalCalories() = runDao.getTotalCalories()

    fun getTotalDistance() = runDao.getTotalDistance()

    fun getTotalTime() = runDao.getTotalTime()

}