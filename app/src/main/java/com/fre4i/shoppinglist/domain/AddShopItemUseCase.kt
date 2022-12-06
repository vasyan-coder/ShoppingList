package com.fre4i.shoppinglist.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItemUseCase(shopItem: ShopItem) {
        shopListRepository.addShopItemUseCase(shopItem)
    }
}