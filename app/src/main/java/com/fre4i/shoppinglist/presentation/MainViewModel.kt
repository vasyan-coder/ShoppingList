package com.fre4i.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fre4i.shoppinglist.data.ShopListRepositoryImpl
import com.fre4i.shoppinglist.domain.DeleteShopItemUseCase
import com.fre4i.shoppinglist.domain.EditShopItemUseCase
import com.fre4i.shoppinglist.domain.GetShopListUseCase
import com.fre4i.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    //fun getShopList() {
    //    // method value вызывается только из главного потока
    //    // method postValue вызывается из любого потока
    //    val list = getShopListUseCase.getShopList()
    //    shopList.value = list
    //}

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}