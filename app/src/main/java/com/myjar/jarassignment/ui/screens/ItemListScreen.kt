package com.myjar.jarassignment.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.myjar.jarassignment.data.model.ComputerItem
import com.myjar.jarassignment.ui.navigation.AppScreens
import com.myjar.jarassignment.ui.vm.JarViewModel


@Composable
fun ItemListScreen(
    viewModel: JarViewModel,
    navController: NavController
) {
    val items = viewModel.listStringData.collectAsState()


    if (items.value.isNullOrEmpty()){
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(items.value) { item ->
            ItemCard(
                item = item,
                onClick = { navController.navigate("${AppScreens.ItemDetailScreen.name}/${item.id}") }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ItemCard(item: ComputerItem, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Text(text = item.name, fontWeight = FontWeight.Bold, color = Color.Black)
        if (item.data?.color!=null)
        Text(text = "Color : ${item.data?.color}", color = Color.Black)
        if (item.data?.price!=null)
        Text(text = "Price : $ ${item.data?.price}", color = Color.Black)
        if (item.data?.description!=null)
            Text(text = "Description : ${item.data?.description}", color = Color.Black)


    }
}