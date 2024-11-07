package com.nta.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run : Run)

    @Delete
    suspend fun deleteRun(run : Run)

    @Query("SELECT * FROM running_table ORDER BY timeStamp DESC")
    suspend fun getAllRunsSortedByDate() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC")
    suspend fun getAllRunsSortedByAvgSpeed() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    suspend fun getAllRunsSortedByDistance() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    suspend fun getAllRunsSortedByTimeInMillis() : LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    suspend fun getAllRunsSortedByCaloriesBurned() : LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    suspend fun getTotalTimeInMillis() : LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    suspend fun getTotalCaloriesBurned() : LiveData<Long>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    suspend fun getTotalDistance() : LiveData<Long>

    @Query("SELECT SUM(avgSpeedInKMH) FROM running_table")
    suspend fun getTotalAvgSpeed() : LiveData<Long>


}