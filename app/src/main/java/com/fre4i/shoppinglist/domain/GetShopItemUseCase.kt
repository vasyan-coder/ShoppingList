package com.fre4i.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend fun getShopItem(showItemId: Int): ShopItem {
        return shopListRepository.getShopItem(showItemId)
    }
}