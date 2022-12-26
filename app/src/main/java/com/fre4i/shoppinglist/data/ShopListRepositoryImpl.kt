package com.fre4i.shoppinglist.data

import com.fre4i.shoppinglist.domain.ShopItem
import com.fre4i.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrement = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrement++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(oldElement)
    }

    override fun getShopItem(showItemId: Int): ShopItem {
        return shopList.find { it.id == showItemId }
            ?: throw java.lang.RuntimeException("Element with id $showItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}