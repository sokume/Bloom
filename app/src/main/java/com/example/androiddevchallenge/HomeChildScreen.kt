/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.ui.theme.MyTheme

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeChildScreenLightPreview() {
    MyTheme {
        HomeChildScreenMake()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeChildScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        HomeChildScreenMake()
    }
}

@Composable
fun HomeChildScreen(navController: NavHostController) {
    HomeChildScreenMake()
}

@Composable
fun HomeChildScreenMake() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    ) {
        HomeChildItems()
    }
}

@Composable
fun HomeChildItems() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        SearchInputText(
            Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )

        BrowseThemeText(
            Modifier
                .fillMaxWidth()
                .height(32.dp)
                .padding(start = 16.dp, end = 16.dp)
        )

        HorizontalImage(
            Modifier
                .fillMaxWidth()
                .height(152.dp)
                .padding(top = 16.dp)
        )

        DisplayMessageText(
            Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(start = 16.dp, end = 16.dp)
        )

        VerticalImage(
            Modifier
                .weight(1.0f, true)
                .padding(bottom = 56.dp)
        )
    }
}

@Composable
fun VerticalImage(modifier: Modifier) {

    val collumImages = listOf<PlantData>(
        PlantData("Monstere", painterResource(R.drawable.monstera), "This is description"),
        PlantData("Aglopnema", painterResource(R.drawable.aglopnema), "This is description"),
        PlantData("Peace Lily", painterResource(R.drawable.peace_lily), "This is description"),
        PlantData("Fiddle_leaf", painterResource(R.drawable.fiddle_leaf), "This is description"),
        PlantData("Photos", painterResource(R.drawable.photos), "This is description"),
    )

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        items(collumImages) { plant ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .padding(start = 16.dp, end = 16.dp),
            ) {
                // val image: Painter = painterResource(id = plant.res)
                Image(
                    painter = plant.res,
                    contentDescription = plant.description,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CutCornerShape(2.dp)),
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .height(24.dp)
                            .padding(start = 16.dp),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Text(
                            text = plant.name,
                            style = MaterialTheme.typography.h2,
                            color = MaterialTheme.colors.onBackground
                        )
                    }

                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .padding(start = 16.dp),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Text(
                            text = plant.description,
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onBackground
                        )
                    }

                    Box(
                        modifier = Modifier
                            .height(64.dp)
                            .fillMaxWidth()
                            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
                        contentAlignment = Alignment.BottomEnd
                    ) {

                        val checkValue = remember { mutableStateOf(true) }

                        Checkbox(
                            checked = checkValue.value,
                            onCheckedChange = {
                                checkValue.value = it
                            },
                            modifier = Modifier
                                .padding(bottom = 16.dp),
                            colors = CheckboxDefaults.colors(
                                checkmarkColor = MaterialTheme.colors.primary
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayMessageText(modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = "Design your home garden",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            IconButton(
                modifier = Modifier
                    .size(24.dp)
                    .padding(bottom = 4.dp),

                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Filled.FilterList,
                    contentDescription = "filter list button",
                    tint = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}

@Composable
fun HorizontalImage(modifier: Modifier) {

    val rowImages = listOf<PlantData>(
        PlantData("Desert chic", painterResource(R.drawable.desert_chic), "This is description"),
        PlantData(
            "Tiny terrariums",
            painterResource(R.drawable.tiny_terrariums),
            "This is description"
        ),
        PlantData("Jungle vibes", painterResource(R.drawable.jungle_vibes), "This is description"),
        PlantData("Easy care", painterResource(R.drawable.easy_care), "This is description"),
    )

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(rowImages) { plant ->
            Card(
                modifier = Modifier.size(136.dp),
            ) {
                Column {
                    Image(
                        painter = plant.res,
                        contentDescription = plant.description,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(96.dp)
                    )
                    Text(
                        text = plant.name,
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .padding(top = 8.dp, start = 16.dp, end = 16.dp),
                    )
                }
            }
        }
    }
}

@Composable
fun BrowseThemeText(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomStart
    ) {
        Text(
            text = "Browse themes",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onPrimary,
        )
    }
}

@Composable
fun SearchInputText(modifier: Modifier) {
    val searchValue = remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = modifier,
    ) {
        TextField(
            value = searchValue.value,
            onValueChange = {
                searchValue.value = it
            },
            placeholder = {
                Text(
                    text = "Search",
                )
            },
            leadingIcon = {
                Icon(Icons.Filled.Search, "Search Keyword")
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.onBackground,
                    shape = MaterialTheme.shapes.small
                ),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
            ),
            textStyle = MaterialTheme.typography.body1,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                textColor = MaterialTheme.colors.onBackground,
            )
        )
    }
}
