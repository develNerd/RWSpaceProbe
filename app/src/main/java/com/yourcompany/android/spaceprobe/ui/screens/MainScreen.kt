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

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import com.yourcompany.android.spaceprobe.R
import com.yourcompany.android.spaceprobe.model.LocalColorThemes
import com.yourcompany.android.spaceprobe.model.LocalFontThemes
import com.yourcompany.android.spaceprobe.model.LocalShapeThemes
import com.yourcompany.android.spaceprobe.model.spaceProbeMissions
import com.yourcompany.android.spaceprobe.ui.theme.elevation
import com.yourcompany.android.spaceprobe.ui.theme.mediumPadding
import com.yourcompany.android.spaceprobe.ui.theme.smallPadding
import com.yourcompany.android.spaceprobe.ui.widgets.MainTopBar
import com.yourcompany.android.spaceprobe.utils.getCurrentColor
import com.yourcompany.android.spaceprobe.utils.getCurrentFont
import com.yourcompany.android.spaceprobe.utils.getCurrentShape

const val SPACE_GREEN_CODE = R.string.SpaceGreen
const val SPACE_GRAY_CODE = R.string.SpaceGray
const val SPACE_BLUE_CODE = R.string.SpaceBlue
const val COLOR_KEY = "Colors"

const val SHAPE_SQUARE_CODE = R.string.SquareEdge
const val SHAPE_ROUNDED_CODE = R.string.RoundedEdge
const val SHAPE_CUT_CODE = R.string.CutEdge
const val SHAPE_KEY = "Shapes"

const val FONT_OPEN_SANS_CODE = R.string.OpenSans
const val FONT_ROBOTO_CODE = R.string.Roboto
const val FONT_MONTSERRAT_CODE = R.string.Montserrat
const val FONT_AMATIC_CODE = R.string.Amatic
const val FONT_KEY = "Fonts"

@Composable
fun MainScreen() {

    var isThemeSectionExpanded by remember {
        mutableStateOf(true)
    }

    val context = LocalContext.current
    val sharedPref = (context as Activity).getPreferences(Context.MODE_PRIVATE) ?: return

    val colorTheme = sharedPref.getInt(COLOR_KEY, SPACE_GREEN_CODE)
    val shapeTheme = sharedPref.getInt(SHAPE_KEY, SHAPE_SQUARE_CODE)
    val fontTheme = sharedPref.getInt(FONT_KEY, FONT_OPEN_SANS_CODE)

    var currentColorThemeCode by remember {
        mutableStateOf(colorTheme)
    }

    var currentShapeThemeCode by remember {
        mutableStateOf(shapeTheme)
    }

    var currentFontThemeCode by remember {
        mutableStateOf(fontTheme)
    }

    val shapeThemes = getCurrentShape(currentShapeThemeCode)

    val colorThemes = getCurrentColor(currentColorThemeCode)

    val fontThemes = getCurrentFont(currentFontThemeCode)

    CompositionLocalProvider(
        LocalColorThemes provides colorThemes,
        LocalFontThemes provides fontThemes
    ) {

        Scaffold(topBar = {
            MainTopBar(backgroundColor = LocalColorThemes.current.primaryColor, actions = {
                IconButton(onClick = { isThemeSectionExpanded = !isThemeSectionExpanded }) {
                    Icon(
                        if (!isThemeSectionExpanded) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropUp,
                        contentDescription = "Localized description"
                    )
                }
            })
        }) {

            Column(
                verticalArrangement = Arrangement.spacedBy(
                    smallPadding
                )
            ) {
                if (isThemeSectionExpanded) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(smallPadding),
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(elevation = elevation)
                    ) {
                        ColorSelectorSection(sharedPref = sharedPref, currentColorTheme = LocalColorThemes.current) {
                            currentColorThemeCode = it
                        }

                        FontSelectorSection(sharedPref = sharedPref, LocalFontThemes.current) {
                            currentFontThemeCode = it
                        }

                        ShapeSelectorSection(sharedPref = sharedPref) {
                            currentShapeThemeCode = it
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(mediumPadding)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(
                        smallPadding
                    )
                ) {
                    CompositionLocalProvider(LocalShapeThemes provides shapeThemes) {
                        spaceProbeMissions.forEach { probeMission ->
                            ProbeMissionItem(
                                probeName = probeMission.probeName,
                                missionDescription = probeMission.missionDescription
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProbeMissionItem(probeName: String, missionDescription: String) {
    Box(
        modifier = Modifier.background(
            color = LocalColorThemes.current.itemBackground,
            shape = LocalShapeThemes.current.shape
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            modifier = Modifier.padding(
                mediumPadding
            )
        ) {
            CompositionLocalProvider(LocalTextStyle provides MaterialTheme.typography.body1) {
                Text(text = probeName)
                CompositionLocalProvider(LocalTextStyle provides MaterialTheme.typography.body2) {
                    Text(text = missionDescription)
                }
            }
        }
    }
}
