package com.example.sayitahminetuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_oyun.*
import kotlin.random.Random


class OyunActivity : AppCompatActivity() {
    private var rasgeleSayi = 0
    private var sayac = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oyun)

        rasgeleSayi = Random.nextInt(101)
        Log.e("Rasgele Sayi",rasgeleSayi.toString())




        button_TahminEt.setOnClickListener {
            sayac = sayac - 1
            val tahmin = editTextGirdi.text.toString().toInt()

            if(tahmin == rasgeleSayi){
                val intent = Intent(this@OyunActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",true)
                finish()
                startActivity(intent)
                return@setOnClickListener
            }
            if(tahmin > rasgeleSayi){
                yardimci_arttir_azaltir.text = "Azalt"
                kalan_hak.text = "Kalan Hak: $sayac"
            }
            if(tahmin < rasgeleSayi){
                yardimci_arttir_azaltir.text = "Arttır"
                kalan_hak.text = "Kalan Hak: $sayac"

            }
            if(sayac == 0){
                val intent = Intent(this@OyunActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",false)
                finish()
                startActivity(intent)
            }
            editTextGirdi.setText("")



        }

    }
}