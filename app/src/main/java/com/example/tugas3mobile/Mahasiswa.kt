package com.example.tugas3mobile

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Mahasiswa(
    val nama: String,
    val nim: String,
    val prodi: String,
    val gender: String,
    val hobi: String
) : Parcelable