package com.example.roomlocal.data.database

import android.content.Context
import androidx.room.Database
import com.example.roomlocal.data.dao.MahasiswaDao
import com.example.roomlocal.data.entity.Mahasiswa

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {

    //Medefinisikan fungsi untuk mengakses data mahasiswa
    abstract fun  mahasiswaDao(): MahasiswaDao

    companion object{
        @Volatile // memastikan bahawa nilai variabel instance selalu sama di semua
        private var  Instances: KrsDatabase? = null



        fun getDatabase(context: Context, it: KrsDatabase?): KrsDatabase{
            return (Instances ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java,
                    "KrsDatabase"
                )
                    .build().also { Instances =it }
            })
        }
    }
}