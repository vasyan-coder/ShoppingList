package com.fre4i.shoppinglist.domain

interface ShopListRepository {

    fun addShopItemUseCase(shopItem: ShopItem)

    fun deleteShopItemUseCase(shopItem: ShopItem)

    fun editShopItemUseCase(shopItem: ShopItem)

    fun getShopItem(showItemId: Int): ShopItem

    fun getShopList(): List<ShopItem>
}