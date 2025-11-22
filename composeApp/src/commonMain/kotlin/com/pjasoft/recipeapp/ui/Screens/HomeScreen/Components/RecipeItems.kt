package com.pjasoft.recipeapp.ui.Screens.HomeScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.pjasoft.recipeapp.domain.models.Recipe

@Composable
fun RecipeItems(recipe: Recipe, onClick : () -> Unit){
    val colors = MaterialTheme.colorScheme
    Row (
        modifier = Modifier
            .clickable{ onClick() }
            .padding(vertical = 5.dp)
            .fillMaxWidth()
            .shadow(6.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(colors.surface)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            model = recipe.imageUrl,
            contentDescription = recipe.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 10.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Column (
            modifier = Modifier.weight(1f)
        ){
            Text(
                text = recipe.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = recipe.category,
                color = colors.onSurfaceVariant,
                fontSize = 12.sp
            )
        }
        Row {
            Icon(
                imageVector = Icons.Default.Schedule,
                contentDescription = null,
                tint = colors.primary
            )
            Text("${recipe.minutes} min", color = colors.primary, fontWeight = FontWeight.Bold)
        }

    }

}