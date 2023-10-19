package com.shdwraze.flightsearch.data.repository

import com.shdwraze.flightsearch.data.model.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun insertFavorite(favorite: Favorite)

    suspend fun deleteFavorite(favorite: Favorite)

    fun getFavoritesStream(): Flow<List<Favorite>>
}