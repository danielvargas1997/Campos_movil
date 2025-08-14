package com.example.generadorescamposfinito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vincula este archivo Kotlin con el layout XML
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la interfaz
        val etPrime = findViewById<EditText>(R.id.etPrime)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Acción al pulsar el botón
        btnCalculate.setOnClickListener {
            val pText = etPrime.text.toString()

            // Validar entrada
            if (pText.isNotEmpty()) {
                val p = pText.toInt()
                if (isPrime(p)) {
                    val generators = findGenerators(p)
                    tvResult.text = "Generadores de GF($p): $generators"
                } else {
                    tvResult.text = "El número no es primo"
                }
            } else {
                tvResult.text = "Por favor ingresa un número"
            }
        }
    }

    // Función para verificar si un número es primo
    private fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) return false
        }
        return true
    }

    // Función para encontrar generadores de GF(p)
    private fun findGenerators(p: Int): List<Int> {
        val phi = p - 1
        val factors = primeFactors(phi)
        val generators = mutableListOf<Int>()

        for (g in 2 until p) {
            var isGenerator = true
            for (factor in factors) {
                if (modPow(g, phi / factor, p) == 1) {
                    isGenerator = false
                    break
                }
            }
            if (isGenerator) generators.add(g)
        }
        return generators
    }

    // Descomposición en factores primos
    private fun primeFactors(n: Int): Set<Int> {
        var num = n
        val factors = mutableSetOf<Int>()
        var i = 2
        while (i * i <= num) {
            while (num % i == 0) {
                factors.add(i)
                num /= i
            }
            i++
        }
        if (num > 1) factors.add(num)
        return factors
    }

    // Potencia modular rápida
    private fun modPow(base: Int, exp: Int, mod: Int): Int {
        var result = 1
        var b = base % mod
        var e = exp
        while (e > 0) {
            if (e % 2 == 1) result = (result * b) % mod
            b = (b * b) % mod
            e /= 2
        }
        return result
    }
}
