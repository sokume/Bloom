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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = dark_primary,
    primaryVariant = Color.Red,
    secondary = dark_secondary,
    background = dark_background,
    surface = dark_surface,
    onPrimary = dark_on_primary,
    onSecondary = dark_secondary,
    onBackground = dark_background,
    onSurface = dark_surface,

)

private val LightColorPalette = lightColors(
    primary = light_primary,
    primaryVariant = Color.Red,
    secondary = light_secondary,

    background = light_background,
    surface = light_surface,
    onPrimary = light_on_primary,
    onSecondary = light_on_secondary,
    onBackground = light_on_background,
    onSurface = light_on_surface,

)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
