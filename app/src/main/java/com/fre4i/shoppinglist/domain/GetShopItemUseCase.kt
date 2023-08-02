package com.fre4i.shoppinglist.domain

import javax.inject.Inject

class GetShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {

    suspend fun getShopItem(showItemId: Int): ShopItem {
        return shopListRepository.getShopItem(showItemId)
    }
}