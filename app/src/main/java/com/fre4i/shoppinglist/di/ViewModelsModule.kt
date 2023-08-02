package com.fre4i.shoppinglist.di

import androidx.lifecycle.ViewModel
import com.fre4i.shoppinglist.presentation.viewmodel.ShopItemViewModel
import com.fre4i.shoppinglist.presentation.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelsModule {

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    @Binds
    fun bindShopItemViewModel(impl: ShopItemViewModel): ViewModel

}