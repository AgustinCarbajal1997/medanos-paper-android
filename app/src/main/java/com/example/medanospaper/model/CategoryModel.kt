package com.example.medanospaper.model
import androidx.compose.ui.graphics.painter.Painter
import com.example.medanospaper.R
data class CategoryModel(
    val id: Int,
    val name: String,
    val image: Int
)


val postsCategories: List<CategoryModel> = listOf(
    CategoryModel(107, name = "Destacados", image = R.drawable.destacados),
    CategoryModel(25, name = "Agro", image = R.drawable.agro),
    CategoryModel(108, name = "Bienestar", image = R.drawable.bienestar),
    CategoryModel(39, name = "Ciencia", image = R.drawable.ciencia),
    CategoryModel(60, name = "Clima", image = R.drawable.clima),
    CategoryModel(27, name = "Cultura", image = R.drawable.cultura),
    CategoryModel(21, name = "Curisiodades", image = R.drawable.curiosidades),
    CategoryModel(0, name = "Clasificados", image = R.drawable.clasificados),
)
