package com.fre4i.shoppinglist.presentation

import android.app.Application
import com.fre4i.shoppinglist.di.DaggerApplicationComponent

class ShoppingListApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}