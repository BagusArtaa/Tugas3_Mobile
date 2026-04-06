package com.example.tugas3mobile

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PARCEL = "DATA_MHS"
    }

    private lateinit var profilNama: TextView
    private lateinit var profilNim: TextView
    private lateinit var profilProdi: TextView
    private lateinit var profilKelamin: TextView
    private lateinit var profilHobi: TextView
    private lateinit var btnKembali: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_layout)

        profilNama = findViewById(R.id.profilNama)
        profilNim = findViewById(R.id.profilNim)
        profilProdi = findViewById(R.id.profilProdi)
        profilKelamin = findViewById(R.id.profilKelamin)
        profilHobi = findViewById(R.id.profilHobi)
        btnKembali = findViewById(R.id.btnKembali)

        val data = intent.getParcelableExtra<Mahasiswa>(EXTRA_PARCEL)

        if (data != null) {
            profilNama.text = "Nama: ${data.nama}"
            profilNim.text = "NIM: ${data.nim}"
            profilProdi.text = "Prodi: ${data.prodi}"
            profilKelamin.text = "Jenis Kelamin: ${data.gender}"
            profilHobi.text = "Hobi: ${data.hobi}"
        } else {
            profilNama.text = "Data tidak ditemukan"
        }

        btnKembali.setOnClickListener {
            finish()
        }
    }
}