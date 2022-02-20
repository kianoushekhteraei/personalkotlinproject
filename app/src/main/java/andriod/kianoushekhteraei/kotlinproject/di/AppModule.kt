package andriod.kianoushekhteraei.kotlinproject.di

import andriod.kianoushekhteraei.kotlinproject.Components.Base.ApplicationClass
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent ::class)
object AppModule {


    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): ApplicationClass {
        return app as ApplicationClass
    }

}