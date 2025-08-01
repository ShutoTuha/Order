package com.example.order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.order.ui.theme.BaseColor

@Composable
fun RadioButtonWithText(
    text: String,
    selected: Boolean,
    onSelect: () -> Unit
) {
    Row(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .selectable(selected = selected, onClick = onSelect),
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(
            selected = selected, onClick = null
        )
        Text(
            text = text, style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun MainDishSection() {
    var selectedDish by remember { mutableStateOf("ハンバーガー") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BaseColor, shape = MaterialTheme.shapes.extraLarge)
    ) {
        Column (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .selectableGroup()
        ){
            Text("メインを選択", style = MaterialTheme.typography.titleLarge)
            RadioButtonWithText(
                text = "ハンバーガー", selected = selectedDish == "ハンバーガー"
            ) {selectedDish = "ハンバーガー"}
            RadioButtonWithText(
                text = "チーズバーガー", selected = selectedDish == "チーズバーガー"
            ) {selectedDish = "チーズバーガー"}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonWithTextPreview() {
    RadioButtonWithText(text = "ハンバーガー", selected = true, onSelect = {})
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun MainDishSectionPreview() {
    MainDishSection()
}