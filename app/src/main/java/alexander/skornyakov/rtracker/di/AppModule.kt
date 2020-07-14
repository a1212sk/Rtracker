package alexander.skornyakov.rtracker.di

import alexander.skornyakov.rtracker.db.RunningDatabase
import alexander.skornyakov.rtracker.helpers.Constants.DATABASE_NAME
import android.content.Context
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

}