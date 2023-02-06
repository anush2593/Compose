package com.example.feature_github.domain

import android.content.res.Resources
import androidx.compose.ui.unit.*

fun Resources.getDimenDp(dimenRes: Int): Dp {
    val value = getDimension(dimenRes) / displayMetrics.density
    return value.dp
}

fun Resources.getDimenSp(dimenRes: Int): TextUnit {
    val value = getDimension(dimenRes) / displayMetrics.density
    return value.sp
}

