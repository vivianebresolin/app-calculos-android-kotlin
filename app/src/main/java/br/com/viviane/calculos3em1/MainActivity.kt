package br.com.viviane.calculos3em1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.viviane.calculos3em1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnImc.setOnClickListener{
            val mIntent = Intent(this, CalculoImcActivity::class.java)
            startActivity(mIntent)
        }

        binding.btnIpva.setOnClickListener{
            val mIntent = Intent(this, CalculoIpvaActivity::class.java)
            startActivity(mIntent)
        }

        binding.btnConverterMedidas.setOnClickListener{
            val mIntent = Intent(this, ConversorMedidasActivity::class.java)
            startActivity(mIntent)
        }
    }
}