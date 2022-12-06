package com.fre4i.shoppinglist.domain

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopItemUseCase(shopItem: ShopItem) {
        shopListRepository.deleteShopItemUseCase(shopItem)
    }
}