package sandeep.kumar.runningapp.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import sandeep.kumar.runningapp.db.RunningDatabase
import sandeep.kumar.runningapp.util.Constants.KEY_FIRST_TIME_TOGGLE
import sandeep.kumar.runningapp.util.Constants.KEY_NAME
import sandeep.kumar.runningapp.util.Constants.KEY_WEIGHT
import sandeep.kumar.runningapp.util.Constants.RUNNING_DATABASE_NAME
import sandeep.kumar.runningapp.util.Constants.SHARED_PREFERENCES_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRunningDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDAO(db: RunningDatabase) = db.getRunDao()


    @Singleton
    @Provides
    fun provideSharedPreference(
        @ApplicationContext app: Context
    ) = app.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideName(
        sharedPref: SharedPreferences
    ) = sharedPref.getString(KEY_NAME, "") ?: ""


    @Singleton
    @Provides
    fun provideWeight(
        sharedPref: SharedPreferences
    ) = sharedPref.getFloat(KEY_WEIGHT, 80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(
        sharedPref: SharedPreferences
    ) = sharedPref.getBoolean(KEY_FIRST_TIME_TOGGLE, true)

}