package com.example.todoapp.util

import android.content.Context
import com.example.todoapp.model.TodoDatabase
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val DB_NAME="tododb"

fun buildDB(context:Context):TodoDatabase{
//    val db = Room.databaseBuilder(context,TodoDatabase::class.java, DB_NAME).addMigrations(Migration_1_2).build()
    val db = Room.databaseBuilder(context,TodoDatabase::class.java, DB_NAME)
        .addMigrations(Migration_3_4)
        .build()
    return db
}

val Migration_1_2=object: Migration(1,2)
{
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE todo ADD COLUMN priority INTEGER DEFAULT 3 NOT NULL")
    }

}
val Migration_2_3=object: Migration(2,3)
{
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE todo ADD COLUMN is_done INTEGER DEFAULT 0 NOT NULL")
    }

}
val Migration_3_4=object: Migration(3,4)
{
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE 'todo' ADD COLUMN 'coba' INTEGER NOT NULL DEFAULT 0 ")
    }

}