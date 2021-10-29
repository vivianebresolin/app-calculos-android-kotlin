package br.com.viviane.calculos3em1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.viviane.calculos3em1.databinding.ActivityCalculoImcBinding
import br.com.viviane.calculos3em1.databinding.ActivityConversorMedidasBinding
import java.text.DecimalFormat

class ConversorMedidasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConversorMedidasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConversorMedidasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConversorCalcular.setOnClickListener{
            val inputKm = binding.inputKm.text.trim().toString()

            if(inputKm.isEmpty()){
                binding.inputKm.error = "Campo obrigatório."
                binding.inputKm.requestFocus()
            }  else {
                val km = inputKm.toDouble()

                val metros = km * 1000
                val centimetros = km * 100000
                val milimetros = km * 1000000

                val texto = "$inputKm km é equivalente a $metros metros, " +
                        "$centimetros centímetros e $milimetros milímetros."
                binding.conversorResultado.text = texto
            }
        }
    }
}