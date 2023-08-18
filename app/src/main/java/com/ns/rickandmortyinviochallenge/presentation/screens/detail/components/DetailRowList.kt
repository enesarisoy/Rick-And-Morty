package com.ns.rickandmortyinviochallenge.presentation.screens.detail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailRowList(
    title: String,
    detail: String
) {

    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 5.dp),
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = detail,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(bottom = 5.dp)
                .weight(1.5f)
        )
    }
}