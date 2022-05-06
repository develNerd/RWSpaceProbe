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

package com.raywenderlich.android.rwandroidtutorial.model

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.raywenderlich.android.rwandroidtutorial.ui.screens.SPACE_BLUE_CODE
import com.raywenderlich.android.rwandroidtutorial.ui.screens.SPACE_GRAY_CODE
import com.raywenderlich.android.rwandroidtutorial.ui.screens.SPACE_GREEN_CODE
import com.raywenderlich.android.rwandroidtutorial.ui.theme.*

data class ColorTheme(
    val id: Int = SPACE_GREEN_CODE,
    val primaryColor: Color = spaceGreen700,
    val secondaryColor: Color = spaceGreen500,
    val itemBackground: Color = spaceGreen200
)

val spaceGreenColors = ColorTheme(
    id = SPACE_GREEN_CODE,
    primaryColor = spaceGreen700,
    secondaryColor = spaceGreen200,
    itemBackground = TealGreen200
)

val spaceGrayColors = ColorTheme(
    id = SPACE_GRAY_CODE,
    primaryColor = spaceGray700,
    secondaryColor = spaceGray500,
    itemBackground = spaceGray200
)

val spaceBlueColors = ColorTheme(
    id = SPACE_BLUE_CODE,
    primaryColor = spaceBlue700,
    secondaryColor = spaceBlue500,
    itemBackground = spaceBlue200
)

val LocalColorThemes = staticCompositionLocalOf { ColorTheme() }
