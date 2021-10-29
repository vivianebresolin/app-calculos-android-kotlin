package br.com.viviane.calculos3em1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.viviane.calculos3em1.databinding.ActivityCalculoImcBinding
import java.text.DecimalFormat

class CalculoImcActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculoImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculoImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener{
            val inputPeso = binding.inputPeso.text.trim().toString()
            val inputAltura = binding.inputAltura.text.trim().toString()

            if(inputPeso.isEmpty()){
                binding.inputPeso.error = "Campo obrigatório."
                binding.inputPeso.requestFocus()
            } else if(inputAltura.isEmpty()){
                binding.inputAltura.error = "Campo obrigatório."
                binding.inputAltura.requestFocus()
            } else {
                val altura = inputAltura.toDouble()
                val peso = inputPeso.toDouble()
                val decimal = DecimalFormat("#,###.00")
                val imc = peso / (altura * altura)
                var status = ""

                if (imc < 18.5) {
                    status = "magreza"
                } else if (imc < 24.9) {
                    status = "peso normal"
                } else if (imc < 30) {
                    status = "sobrepeso"
                } else {
                    status = "obesidade"
                }

                val textoDoResultado = "O resultado do IMC é ${decimal.format(imc)}, o que indica $status."
                binding.resultado.text = textoDoResultado
            }
        }
    }
}