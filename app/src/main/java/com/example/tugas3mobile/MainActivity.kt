package com.example.tugas3mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var nama: EditText
    private lateinit var nim: EditText
    private lateinit var prodi: Spinner
    private lateinit var kelamin: RadioGroup
    private lateinit var buku: CheckBox
    private lateinit var musik: CheckBox
    private lateinit var olahraga: CheckBox
    private lateinit var btnTampil: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nama = findViewById(R.id.inputNama)
        nim = findViewById(R.id.inputNim)
        prodi = findViewById(R.id.pilihProdi)
        kelamin = findViewById(R.id.kelamin)
        buku = findViewById(R.id.buku)
        musik = findViewById(R.id.musik)
        olahraga = findViewById(R.id.olahraga)
        btnTampil = findViewById(R.id.btnTampil)

        val prodiList = arrayOf(
            "Teknik Informatika",
            "Teknik Sipil",
            "Teknik Elektro"
        )
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item, prodiList)
        prodi.adapter = adapter

        btnTampil.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnTampil) {

            val nama = nama.text.toString()
            val nim = nim.text.toString()
            val prodi = prodi.selectedItem.toString()

            if (nama.isEmpty() || nim.isEmpty()) {
                Toast.makeText(this,
                    "Nama dan NIM tidak boleh kosong",
                    Toast.LENGTH_SHORT).show()
                return
            }

            val selectedGenderId = kelamin.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                val rb = findViewById<RadioButton>(selectedGenderId)
                rb.text.toString()
            } else {
                "Tidak dipilih"
            }

            val hobiList = mutableListOf<String>()
            if (buku.isChecked) hobiList.add("Membaca buku")
            if (musik.isChecked) hobiList.add("Mendengarkan musik")
            if (olahraga.isChecked) hobiList.add("Olahraga")

            val hobi = hobiList.joinToString(", ")

            val mahasiswa = Mahasiswa(
                nama = nama,
                nim = nim,
                prodi = prodi,
                gender = gender,
                hobi = hobi
            )

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("DATA_MHS", mahasiswa)
            startActivity(intent)
        }
    }
}