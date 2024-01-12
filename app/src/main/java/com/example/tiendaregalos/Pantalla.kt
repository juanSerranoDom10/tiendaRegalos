package com.example.tiendaregalos

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PantallaPrincipal(controladorNavegacion: NavHostController) {
    val navItems = listOf(
        NavItem("Hogar", R.drawable.sillon) { controladorNavegacion.navigate("Hogar") },
        NavItem("Electronica", R.drawable.portatil) { controladorNavegacion.navigate("Electronica") },
        NavItem("Ropa", R.drawable.camiatm) { controladorNavegacion.navigate("Ropa") },
        NavItem("Cocina", R.drawable.sarten) { controladorNavegacion.navigate("Cocina") },
        NavItem("Juguetes", R.drawable.monopoly) { controladorNavegacion.navigate("Juguetes") },
        NavItem("Decoracion", R.drawable.cuadro) { controladorNavegacion.navigate("Decoracion") }
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(navItems.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (item in rowItems) {
                    NavItemCard(navItem = item)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
data class NavItem(val title: String, val backgroundResId: Int, val onClick: () -> Unit)


@Composable
fun NavItemCard(navItem: NavItem) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .background(Color.Gray)
            .clickable { navItem.onClick.invoke() }
    ) {
        Image(
            painter = painterResource(id = navItem.backgroundResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(text = navItem.title, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}
