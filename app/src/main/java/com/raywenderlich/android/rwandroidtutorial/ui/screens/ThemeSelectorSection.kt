package com.raywenderlich.android.rwandroidtutorial.ui.screens

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.raywenderlich.android.rwandroidtutorial.R
import com.raywenderlich.android.rwandroidtutorial.model.ThemeItem
import com.raywenderlich.android.rwandroidtutorial.ui.theme.dp10
import com.raywenderlich.android.rwandroidtutorial.ui.theme.elevation
import com.raywenderlich.android.rwandroidtutorial.ui.theme.paddingRadioButtonHorizontal
import com.raywenderlich.android.rwandroidtutorial.ui.theme.smallPadding

@Composable
fun ThemeSelectorSection() {

    val context = LocalContext.current as Activity
    val sharedPref = context.getPreferences(Context.MODE_PRIVATE) ?: return

    Column(
        verticalArrangement = Arrangement.spacedBy(smallPadding),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = elevation)
    ) {
        ColorSelectorSection(sharedPref = sharedPref)
        ShapeSelectorSection(sharedPref = sharedPref)
        FontSelectorSection(sharedPref = sharedPref)
    }
}

@Composable
fun ColorSelectorSection(sharedPref: SharedPreferences) {

    val themeColors = listOf(
        ThemeItem(stringResource(id = R.string.SpaceGreen), R.string.SpaceGreen),
        ThemeItem(stringResource(id = R.string.SpaceGray), R.string.SpaceGray),
        ThemeItem(stringResource(id = R.string.SpaceBlue), R.string.SpaceBlue)
    )

    val colorKey = stringResource(id = R.string.colors)

    val themeId = sharedPref.getInt(colorKey, R.string.SpaceGreen)

    var currentColor by remember {
        mutableStateOf(themeId)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(smallPadding),
        modifier = Modifier.padding(
            dp10
        )
    ) {
        Text(text = stringResource(id = R.string.colors), fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectableGroup()
        ) {
            themeColors.forEach { themeColor ->
                Row(
                    modifier = Modifier.clickable {
                        with(sharedPref.edit()) {
                            currentColor = themeColor.id
                            putInt(colorKey, currentColor)
                            apply()
                        }
                    }
                ) {
                    RadioButton(
                        selected = themeColor.id == currentColor,
                        null
                    )
                    Text(
                        text = themeColor.name,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(start = paddingRadioButtonHorizontal, end = paddingRadioButtonHorizontal)
                    )
                }
            }
        }
    }
}

@Composable
fun ShapeSelectorSection(sharedPref: SharedPreferences) {

    val shapeThemes = listOf(
        ThemeItem(stringResource(id = R.string.SquareEdge), R.string.SquareEdge),
        ThemeItem(stringResource(id = R.string.CutEdge), R.string.CutEdge),
        ThemeItem(stringResource(id = R.string.RoundedEdge), R.string.RoundedEdge)
    )

    val shapeKey = stringResource(id = R.string.shapes)

    val themeId = sharedPref.getInt(shapeKey, R.string.SquareEdge)

    var currentShape by remember {
        mutableStateOf(themeId)
    }

    Column(verticalArrangement = Arrangement.spacedBy(smallPadding), modifier = Modifier.padding(dp10)) {
        Text(text = stringResource(id = R.string.shapes), fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectableGroup()
        ) {
            shapeThemes.forEach { themeShape ->
                Row(
                    modifier = Modifier.clickable {
                        with(sharedPref.edit()) {
                            currentShape = themeShape.id
                            putInt(shapeKey, currentShape)
                            apply()
                        }
                    }
                ) {
                    RadioButton(
                        selected = themeShape.id == currentShape,
                        null
                    )
                    Text(
                        text = themeShape.name,
                        style = MaterialTheme.typography.body1.merge(),
                        modifier = Modifier.padding(start = paddingRadioButtonHorizontal, end = paddingRadioButtonHorizontal)
                    )
                }
            }
        }
    }
}

@Composable
fun FontSelectorSection(sharedPref: SharedPreferences) {

    val shapeThemes = listOf(
        ThemeItem(stringResource(id = R.string.OpenSans), R.string.OpenSans),
        ThemeItem(stringResource(id = R.string.Roboto), R.string.Roboto),
        ThemeItem(stringResource(id = R.string.Montserrat), R.string.Montserrat)
    )

    val fontKey = stringResource(id = R.string.FontTypes)

    val themeId = sharedPref.getInt(fontKey, R.string.OpenSans)

    var currentFont by remember {
        mutableStateOf(themeId)
    }

    Column(verticalArrangement = Arrangement.spacedBy(smallPadding), modifier = Modifier.padding(dp10)) {
        Text(text = stringResource(id = R.string.FontTypes), fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectableGroup()
        ) {
            shapeThemes.forEach { themeFont ->
                Row(
                    modifier = Modifier.clickable {
                        with(sharedPref.edit()) {
                            currentFont = themeFont.id
                            putInt(fontKey, currentFont)
                            apply()
                        }
                    }
                ) {
                    RadioButton(
                        selected = themeFont.id == currentFont,
                        null
                    )
                    Text(
                        text = themeFont.name,
                        style = MaterialTheme.typography.body1.merge(),
                        modifier = Modifier.padding(start = paddingRadioButtonHorizontal, end = paddingRadioButtonHorizontal)
                    )
                }
            }
        }
    }
}
