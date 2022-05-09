/*
 * Copyright (c) 2022 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.yourcompany.android.spaceprobe.ui.screens

import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.yourcompany.android.spaceprobe.R
import com.yourcompany.android.spaceprobe.model.*
import com.yourcompany.android.spaceprobe.ui.theme.mediumPadding
import com.yourcompany.android.spaceprobe.ui.theme.paddingRadioButtonHorizontal
import com.yourcompany.android.spaceprobe.ui.theme.smallPadding

@Composable
fun ColorSelectorSection(
    sharedPref: SharedPreferences,
    currentColorTheme: ColorTheme,
    setCurrentColorTheme: (Int) -> Unit
) {

    val themeColors = listOf(
        ThemeItem(stringResource(id = R.string.SpaceGreen), SPACE_GREEN_CODE),
        ThemeItem(stringResource(id = R.string.SpaceGray), SPACE_GRAY_CODE),
        ThemeItem(stringResource(id = R.string.SpaceBlue), SPACE_BLUE_CODE)
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(smallPadding),
        modifier = Modifier.padding(
            mediumPadding
        )
    ) {
        Text(
            text = stringResource(id = R.string.colors),
            fontWeight = FontWeight.Bold,
            fontFamily = LocalFontThemes.current.fontFamily
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectableGroup()
        ) {
            themeColors.forEach { themeColor ->
                Row(
                    modifier = Modifier.clickable {
                        with(sharedPref.edit()) {
                            setCurrentColorTheme(themeColor.id)
                            putInt(COLOR_KEY, themeColor.id)
                            apply()
                        }
                    }
                ) {

                    RadioButton(
                        selected = themeColor.id == currentColorTheme.id,
                        null,
                        colors = RadioButtonDefaults.colors(selectedColor = LocalColorThemes.current.secondaryColor)
                    )
                    Text(
                        text = themeColor.name,
                        style = MaterialTheme.typography.body1,
                        fontFamily = LocalFontThemes.current.fontFamily,
                        modifier = Modifier.padding(
                            start = paddingRadioButtonHorizontal,
                            end = paddingRadioButtonHorizontal
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ShapeSelectorSection(
    sharedPref: SharedPreferences,
    setCurrentShapeTheme: (Int) -> Unit
) {

    val shapeThemes = listOf(
        ThemeItem(stringResource(id = R.string.SquareEdge), SHAPE_SQUARE_CODE),
        ThemeItem(stringResource(id = R.string.CutEdge), SHAPE_CUT_CODE),
        ThemeItem(stringResource(id = R.string.RoundedEdge), SHAPE_ROUNDED_CODE)
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(smallPadding),
        modifier = Modifier.padding(mediumPadding)
    ) {
        Text(
            text = stringResource(id = R.string.shapes),
            fontWeight = FontWeight.Bold,
            fontFamily = LocalFontThemes.current.fontFamily
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectableGroup()
        ) {
            shapeThemes.forEach { themeShape ->
                Row(
                    modifier = Modifier.clickable {
                        with(sharedPref.edit()) {
                            setCurrentShapeTheme(themeShape.id)
                            putInt(SHAPE_KEY, themeShape.id)
                            apply()
                        }
                    }
                ) {
                    RadioButton(
                        selected = themeShape.id == sharedPref.getInt(SHAPE_KEY, SHAPE_SQUARE_CODE),
                        null,
                        colors = RadioButtonDefaults.colors(selectedColor = LocalColorThemes.current.secondaryColor)
                    )
                    Text(
                        text = themeShape.name,
                        style = MaterialTheme.typography.body1.merge(),
                        fontFamily = LocalFontThemes.current.fontFamily,
                        modifier = Modifier.padding(
                            start = paddingRadioButtonHorizontal,
                            end = paddingRadioButtonHorizontal
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun FontSelectorSection(
    sharedPref: SharedPreferences,
    currentFontTheme: FontsTheme,
    setCurrentFontTheme: (Int) -> Unit
) {

    val fontThemes = listOf(
        ThemeItem(stringResource(id = R.string.OpenSans), FONT_OPEN_SANS_CODE),
        ThemeItem(stringResource(id = R.string.Roboto), FONT_ROBOTO_CODE),
        ThemeItem(stringResource(id = R.string.Montserrat), FONT_MONTSERRAT_CODE),
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(smallPadding),
        modifier = Modifier.padding(mediumPadding)
    ) {
        Text(
            text = stringResource(id = R.string.FontTypes),
            fontWeight = FontWeight.Bold,
            fontFamily = LocalFontThemes.current.fontFamily
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectableGroup()
        ) {
            fontThemes.forEach { themeFont ->
                Row(
                    modifier = Modifier.clickable {
                        with(sharedPref.edit()) {
                            setCurrentFontTheme(themeFont.id)
                            putInt(FONT_KEY, currentFontTheme.id)
                            apply()
                        }
                    }
                ) {
                    RadioButton(
                        selected = themeFont.id == currentFontTheme.id,
                        null,
                        colors = RadioButtonDefaults.colors(selectedColor = LocalColorThemes.current.secondaryColor)
                    )
                    Text(
                        text = themeFont.name,
                        style = MaterialTheme.typography.body1.merge(),
                        fontFamily = LocalFontThemes.current.fontFamily,
                        modifier = Modifier.padding(
                            start = paddingRadioButtonHorizontal,
                            end = paddingRadioButtonHorizontal
                        )
                    )
                }
            }
        }
    }
}
