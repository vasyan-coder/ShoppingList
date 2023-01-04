package com.fre4i.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.fre4i.shoppinglist.domain.ShopItem

class ShopListDiffCallback(
    private val oldShopList: List<ShopItem>,
    private val newShopList: List<ShopItem>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldShopList.size
    }

    override fun getNewListSize(): Int {
        return newShopList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldShopList[oldItemPosition]
        val newItem = newShopList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldShopList[oldItemPosition]
        val newItem = newShopList[newItemPosition]
        return oldItem == newItem
    }

}