package br.com.fiap.myaiteacher.ui.screen.login.components.autocomplete

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import br.com.fiap.myaiteacher.model.universidade.Universidade
import br.com.fiap.myaiteacher.services.RetrofitFactory
import br.com.fiap.myaiteacher.ui.theme.Montserrat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoComplete(
    autoCompleteViewModel: AutoCompleteViewModel,
    modifier: Modifier,
    horizontalAlignment: Alignment.Horizontal,
    verticalArrangement: Arrangement.Vertical
) {

    val categoryState by autoCompleteViewModel.categoryState.observeAsState(initial = "")

    var category by remember {
        mutableStateOf("")
    }
//    val heightTextFields by remember {
//        mutableStateOf(80.dp)
//    }
    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val resultsState = remember() {
        mutableStateOf(listOf<Universidade>())
    }

    val call =
        RetrofitFactory().getListaDeUniversidadesService().getListaDeUniversidades(categoryState)

    call.enqueue(object : Callback<List<Universidade>> {
        override fun onResponse(
            call: Call<List<Universidade>>,
            response: Response<List<Universidade>>
        ) {
            if (response.isSuccessful) {
                resultsState.value = response.body() ?: emptyList()
                Log.i("FIAP", "onResponse: ${response.code()}")
            }
        }

        override fun onFailure(call: Call<List<Universidade>>, t: Throwable) {
            Log.e("Erro", "onFailure: ${t.message.toString()}")
        }
    })

    val colorPrimary = Color(0xFFD292FE)
    val colorSecondary = Color(0xFF00002E)
    val fontSize = 20.sp

    //Instituição Field
    Column(
        modifier = Modifier
            .padding(0.dp, 10.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    expanded = false
                }
            ),

        ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.padding(30.dp, 0.dp)) {

                    TextField(
                        label = {
                            Text(
                                text = "Instituição de Ensino",
                                color = colorSecondary,
                            )
                        },
                        modifier = Modifier
                            .background(
                                color = colorPrimary,
                                shape = RoundedCornerShape(20.dp)
                            )
//                            .clip(RoundedCornerShape(percent = 40))
                            .onGloballyPositioned { coordinates ->
                                textFieldSize = coordinates.size.toSize()
                            },
                        value = category,
                        onValueChange = {
                            category = it
                            expanded = true
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = colorSecondary,
                        ),
                        textStyle = TextStyle(
                            color = colorSecondary,
                            fontSize = fontSize,
                            fontFamily = Montserrat
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        leadingIcon = {
                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Filled.Place,
                                    contentDescription = "Instituição de Ensino",
                                    tint = colorSecondary
                                )
                            }
                        },
                        trailingIcon = {
                            IconButton(onClick = { expanded = !expanded }) {
                                Icon(
                                    imageVector = Icons.Rounded.ArrowDropDown,
                                    contentDescription = "arrow"
                                )
                            }
                        },
                    )
            }

            // Category List
            AnimatedVisibility(visible = expanded) {
                Card(
                    elevation = CardDefaults.elevatedCardElevation(15.dp),
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .widthIn(min = 150.dp, max = 320.dp)
                        .background(color = colorPrimary),
                    shape = RoundedCornerShape(10.dp)
                ) {

                    LazyColumn(
                        modifier = Modifier
                            .background(color = colorPrimary)
                            .heightIn(max = 150.dp)
                    ) {
                        if (category.isNotEmpty()) {
                            items(
                                resultsState.value.filter { universidade ->
                                    universidade.name.lowercase()
                                        .contains(category.lowercase()) || universidade.name.lowercase()
                                        .contains("others")
                                }
                                    .sortedBy { it.name.lowercase() }
                            ) {
                                CategoryItems(
                                    title = it.name
                                ) { title ->
                                    category = title
                                    expanded = false
                                }
                            }
                        } else {
                            items(
                                resultsState.value.sortedBy { it.name }
                            ) {
                                CategoryItems(
                                    title = it.name
                                ) { title ->
                                    category = title
                                    expanded = false
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryItems(
    title: String,
    onSelect: (String) -> Unit
) {
    val colorPrimary = Color(0xFFD292FE)
    val colorSecondary = Color(0xFF00002E)

    Row(
        modifier = Modifier
            .clickable(
                onClick = {
                    onSelect(title)
                }
            )
            .background(color = colorPrimary)
            .padding(10.dp),
    ) {
        Text(text = title, fontSize = 12.sp, color = colorSecondary)
    }
}
