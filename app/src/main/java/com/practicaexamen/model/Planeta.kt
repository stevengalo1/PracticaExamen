package com.practicaexamen.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "estado")

data class Planeta(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="nombre")
    val nombre: String,
    @ColumnInfo(name="capital")
    val capital: String?,
    @ColumnInfo(name="poblacion")
    val poblacion: String?,
    @ColumnInfo(name="moneda")
    val moneda: String?
) : Parcelable
