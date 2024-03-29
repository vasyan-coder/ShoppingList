package com.fre4i.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.fre4i.shoppinglist.domain.ShopItem
import com.fre4i.shoppinglist.domain.ShopListRepository
import javax.inject.Inject

class ShopListRepositoryImpl @Inject constructor(
    private val mapper: ShopListMapper,
    private val shopListDao: ShopListDao
) : ShopListRepository {

    override suspend fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun getShopItem(showItemId: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(showItemId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun getShopList(): LiveData<List<ShopItem>> = shopListDao.getShopList().map { dbModel ->
        dbModel.map {
            mapper.mapDbModelToEntity(it)
        }
    }
}