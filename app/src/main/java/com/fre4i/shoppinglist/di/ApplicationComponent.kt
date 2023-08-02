package com.fre4i.shoppinglist.di

import android.app.Application
import com.fre4i.shoppinglist.presentation.MainActivity
import com.fre4i.shoppinglist.presentation.ShopItemFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        ViewModelsModule::class
    ]
)
@ApplicationScope
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: ShopItemFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}