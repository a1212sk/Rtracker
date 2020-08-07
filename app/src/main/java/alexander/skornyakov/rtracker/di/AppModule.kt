package alexander.skornyakov.rtracker.di

import alexander.skornyakov.rtracker.db.RunningDatabase
import alexander.skornyakov.rtracker.helpers.Constants.DATABASE_NAME
import alexander.skornyakov.rtracker.helpers.Constants.KEY_FIRST_TIME
import alexander.skornyakov.rtracker.helpers.Constants.KEY_NAME
import alexander.skornyakov.rtracker.helpers.Constants.KEY_WEIGHT
import alexander.skornyakov.rtracker.helpers.Constants.SHARED_PREFERENCES_NAME
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, RunningDatabase::class.java, DATABASE_NAME)
            .build()

    @Singleton
    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context) =
        context.getSharedPreferences( SHARED_PREFERENCES_NAME, MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideUsername(sharedPreferences: SharedPreferences) =
        sharedPreferences.getString(KEY_NAME,"") ?: ""

    @Singleton
    @Provides
    fun provideWeight(sharedPreferences: SharedPreferences) =
        sharedPreferences.getFloat(KEY_WEIGHT,80f)

    @Singleton
    @Provides
    fun provideFirstTime(sharedPreferences: SharedPreferences) =
        sharedPreferences.getBoolean(KEY_FIRST_TIME,true)

}