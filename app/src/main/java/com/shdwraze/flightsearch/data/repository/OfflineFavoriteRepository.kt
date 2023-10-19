package com.shdwraze.flightsearch.data.repository

import com.shdwraze.flightsearch.data.dao.FavoriteDao
import com.shdwraze.flightsearch.data.model.Favorite
import kotlinx.coroutines.flow.Flow

class OfflineFavoriteRepository(
    private val favoriteDao: FavoriteDao
) : FavoriteRepository {
    override suspend fun insertFavorite(favorite: Favorite) = favoriteDao.insert(favorite)

    override suspend fun deleteFavorite(favorite: Favorite) = favoriteDao.delete(favorite)

    override fun getFavoritesStream(): Flow<List<Favorite>> = favoriteDao.getFavorites()
}