package com.fre4i.shoppinglist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fre4i.shoppinglist.domain.DeleteShopItemUseCase
import com.fre4i.shoppinglist.domain.EditShopItemUseCase
import com.fre4i.shoppinglist.domain.GetShopListUseCase
import com.fre4i.shoppinglist.domain.ShopItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getShopListUseCase: GetShopListUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase,
    private val editShopItemUseCase: EditShopItemUseCase,
) : ViewModel() {

    val shopList = getShopListUseCase.getShopList()

    //fun getShopList() {
    //    // method value вызывается только из главного потока
    //    // method postValue вызывается из любого потока
    //    val list = getShopListUseCase.getShopList()
    //    shopList.value = list
    //}

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }
}