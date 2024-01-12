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

data class Cocina (
    val name: String, val imagen: Int, val precio:Double, val descrip:String
)
@Composable
fun CocinaItem(cocina: Hogar) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar la foto utilizando el componente Image
        Image(
            painter = painterResource(id = cocina.imagen),
            contentDescription = null, // Descripción de la imagen (ajústalo según tus necesidades)
            modifier = Modifier
                .size(150.dp) // Tamaño de la imagen (ajústalo según tus necesidades)
                .clip(shape = RoundedCornerShape(8.dp)) // Opcional: redondear las esquinas
        )

        // Mostrar el nombre, descripción y precio
        Text(text = cocina.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = cocina.descrip, fontSize = 16.sp)
        Text(text = "Precio: $${cocina.precio}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Cocina(controladorNavegacion: NavHostController) {
    val categories = listOf(
        Hogar("Sarten", R.drawable.sarten, 12.00, "Sarten antiadherente"),
        Hogar("Nevera", R.drawable.nevera, 999.99, "Nevera Samsung"),
        Hogar("Freidora", R.drawable.freidora, 39.99, "Freidora con aceite"),
        Hogar("Cuchillo", R.drawable.cuchillo, 10.00, "Cuchillo Arcos")
    )

    LazyColumn {
        items(categories) { cocina ->
            CocinaItem(cocina = cocina)
            // Puedes agregar un separador entre cada elemento si lo deseas
            Divider(modifier = Modifier.padding(horizontal = 16.dp), color = Color.Gray)
        }
    }
}