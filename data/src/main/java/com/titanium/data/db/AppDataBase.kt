package com.titanium.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.titanium.data.entity.EnemyUnitEntity
import com.titanium.data.entity.GameProcessEntity
import com.titanium.data.tactic.EnemyUnitDao
import com.titanium.data.tactic.GameProcessDao
import com.titanium.data.DataBaseUtils

@Database(
        entities = [EnemyUnitEntity::class, GameProcessEntity::class],
        version = DataBaseUtils.VERSION,
        exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun enemyDao(): EnemyUnitDao

    abstract fun gameProcessDao(): GameProcessDao

}