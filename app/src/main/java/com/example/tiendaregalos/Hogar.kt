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

data class Hogar(
    val name: String, val imagen: Int, val precio:Double, val descrip:String
)
@Composable
fun HogarItem(hogar: Hogar) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la foto utilizando el componente Image
        Image(
            painter = painterResource(id = hogar.imagen),
            contentDescription = null, // Descripción de la imagen (puedes ajustarlo según tus necesidades)
            modifier = Modifier
                .size(150.dp) // Tamaño de la imagen
                .clip(shape = RoundedCornerShape(8.dp)) // Opcional: redondear las esquinas
        )

        // Mostrar el nombre, descripción y precio
        Text(text = hogar.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = hogar.descrip, fontSize = 16.sp)
        Text(text = "Precio: ${hogar.precio}€", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Hogar(controladorNavegacion: NavHostController) {
    val categories = listOf(
        Hogar("Sillon", R.drawable.sillon, 99.99, "Sillon bien guapo"),
        Hogar("Mesa", R.drawable.mesa, 45.50, "Mesa"),
        Hogar("Armario", R.drawable.armario, 79.99, "Armario elegante"),
        Hogar("Lampara", R.drawable.lampara, 19.95, "Lampara moderna")
    )

    LazyColumn {
        items(categories) { hogar ->
            HogarItem(hogar = hogar)
            //separador entre cada elemento
            Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Color.Gray)
        }
    }
}
