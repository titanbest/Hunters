package com.titanium.data.tactic

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.titanium.data.entity.EnemyUnitEntity
import com.titanium.data.tactic.BaseDao

@Dao
interface EnemyUnitDao : BaseDao<EnemyUnitEntity> {

    @Query("SELECT * FROM EnemyUnitEntity WHERE id = :id")
    fun getEnemy(id: Int): EnemyUnitEntity

    @Query("SELECT * FROM EnemyUnitEntity")
    fun getAllEnemy(): List<EnemyUnitEntity>
}