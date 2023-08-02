package com.fre4i.shoppinglist.di

import android.app.Application
import com.fre4i.shoppinglist.data.AppDatabase
import com.fre4i.shoppinglist.data.ShopListDao
import com.fre4i.shoppinglist.data.ShopListRepositoryImpl
import com.fre4i.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}