package com.titanium.data.tactic

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.titanium.data.entity.GameProcessEntity
import com.titanium.data.tactic.BaseDao

@Dao
interface GameProcessDao : BaseDao<GameProcessEntity> {

    @Query("SELECT * FROM GameProcessEntity")
    fun getStatsProcessGame(): GameProcessEntity
}