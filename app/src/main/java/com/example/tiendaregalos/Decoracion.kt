package com.example.tiendaregalos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class Decoracion (
    val name: String, val imagen: Int, val precio:Double, val descrip:String
)
@Composable
fun DecoracionItem(decoracion: Hogar) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la foto utilizando el componente Image
        Image(
            painter = painterResource(id = decoracion.imagen),
            contentDescription = null, // Descripción de la imagen (ajústalo según tus necesidades)
            modifier = Modifier
                .size(150.dp) // Tamaño de la imagen (ajústalo según tus necesidades)
                .clip(shape = RoundedCornerShape(8.dp)) // Opcional: redondear las esquinas
        )

        // Mostrar el nombre, descripción y precio
        Text(text = decoracion.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = decoracion.descrip, fontSize = 16.sp)
        Text(text = "Precio: $${decoracion.precio}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Decoracion(controladorNavegacion: NavHostController) {
    val categories = listOf(
        Hogar("Cuadro", R.drawable.cuadro, 50.00, "Cuadro abstracto"),
        Hogar("Florero", R.drawable.florero, 19.99, "Florero con forma de cabezas"),
        Hogar("Objeto para chimenea", R.drawable.decoracionchimenea, 999.99, "Par de decoracion de chimenea medieval"),
        Hogar("Flores", R.drawable.flor, 10.00, "Flores metalicas")
    )

    LazyColumn {
        items(categories) { decoracion ->
            DecoracionItem(decoracion = decoracion)
            // Puedes agregar un separador entre cada elemento si lo deseas
            Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Color.Gray)
        }
    }
}