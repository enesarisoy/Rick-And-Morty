package com.ns.rickandmortyinviochallenge.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ns.rickandmortyinviochallenge.R

// Set of Material typography styles to start with

val Avenir = FontFamily(
    Font(R.font.avenir_roman),
)
val AvenirBook = FontFamily(
    Font(R.font.avenir_book)
)
val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    ),
    bodyMedium = TextStyle(
        fontFamily = AvenirBook,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Avenir,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Avenir,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)