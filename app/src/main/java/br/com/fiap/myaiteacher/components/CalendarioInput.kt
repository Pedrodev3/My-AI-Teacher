package br.com.fiap.myaiteacher.components

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarioInput(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
) {
    val context = LocalContext.current

    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                val formattedDate = "$dayOfMonth/$month/$year"
                onValueChange(formattedDate)
            },
            year,
            month,
            day
        )
    }

    Column {
        Box(
            modifier = Modifier
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = {},
                label = { Text(text = label) },
                readOnly = true,
                modifier = modifier,
            )
            IconButton(
                onClick = {
                    datePickerDialog.show()
                },
                modifier = Modifier
                    .offset(x = 220.dp, y = (10).dp)
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Abrir Calendário"
                )
            }
        }
    }
}






