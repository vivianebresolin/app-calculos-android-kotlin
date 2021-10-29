package br.com.viviane.calculos3em1

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.viviane.calculos3em1.databinding.ActivityCalculoIpvaBinding
import br.com.viviane.calculos3em1.databinding.ActivityConversorMedidasBinding
import java.text.DecimalFormat

class CalculoIpvaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculoIpvaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculoIpvaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaEstados = arrayListOf("Escolha o estado: ", "Santa Catarina", "Minas Gerais", "Sergipe", "Tocantins", "Distrito Federal")
        val spinnerAdapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, listaEstados)
        binding.spinner.adapter = spinnerAdapter

        binding.btnCalcularIpva.setOnClickListener{
            val inputValor = binding.inputValorVeiculo.text.trim().toString()
            val estado = binding.spinner.selectedItem.toString()

            if(inputValor.isEmpty()){
                binding.inputValorVeiculo.error = "Campo obrigatório."
                binding.inputValorVeiculo.requestFocus()
            } else if(estado == listaEstados[0]) {
                Toast.makeText(this, "Escolha um estado!", Toast.LENGTH_LONG).show()
            } else {
                val valorVeiculo = inputValor.toDouble()
                var ipva = 0.0
                val decimal = DecimalFormat("#,###.00")

                when(estado){
                    "Santa Catarina" -> ipva = valorVeiculo * 0.02
                    "Minas Gerais" -> ipva = valorVeiculo * 0.04
                    "Sergipe" -> ipva = valorVeiculo * 0.02
                    "Tocantins" -> ipva = valorVeiculo * 0.02
                    "Distrito Federal" -> ipva = valorVeiculo * 0.03
                }

                val textoIpva = "O valor do IPVA é de R$ ${decimal.format(ipva)}."
                binding.resultadoIpva.text = textoIpva
            }
        }
    }
}