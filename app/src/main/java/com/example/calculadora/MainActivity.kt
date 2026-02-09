package com.example.calculadora

import android.os.Bundle
import android.widget.NumberPicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraTheme {
                Calculadora()
             }
            }
        }
    }
@Composable
fun Calculadora() {
    var numero1 by remember { mutableStateOf("")}
    var numero2 by remember { mutableStateOf("")}
    var resultado by remember { mutableStateOf("") }
    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Número 1") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Número 2") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Resultado: $resultado",
        )
        Spacer(modifier = Modifier.height(height = 16.dp))
        Button(
            onClick = {
                val n1 = numero1.toDoubleOrNull() ?: 0.0
                val n2 = numero2.toDoubleOrNull() ?: 0.0

                resultado = (n1 + n2).toString()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("+")
        }
        Spacer(modifier = Modifier.height(height = 16.dp))
        Button(
            onClick = {
                val n1 = numero1.toDoubleOrNull() ?: 0.0
                val n2 = numero2.toDoubleOrNull() ?: 0.0

                resultado = (n1 - n2).toString()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("-")
        }

        Spacer(modifier = Modifier.height(height = 16.dp))
        Button(
            onClick = {
                val n1 = numero1.toDoubleOrNull() ?: 0.0
                val n2 = numero2.toDoubleOrNull() ?: 0.0

                resultado = (n1 * n2).toString()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("*")
        }

        Spacer(modifier = Modifier.height(height = 16.dp))
        Button(
            onClick = {
                val n1 = numero1.toDoubleOrNull() ?: 0.0
                val n2 = numero2.toDoubleOrNull() ?: 0.0

                if (n2 == 0.0) {
                    resultado = "No se puede dividir entre 0"
                } else {
                    resultado = (n1 / n2).toString()
                }


            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("/")
        }




    }
}






@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraTheme {
        Calculadora()

        


    }
}