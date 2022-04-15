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

package com.raywenderlich.android.rwandroidtutorial.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.raywenderlich.android.rwandroidtutorial.R
import com.raywenderlich.android.rwandroidtutorial.model.spaceProbeMissions
import com.raywenderlich.android.rwandroidtutorial.ui.theme.mediumPadding
import com.raywenderlich.android.rwandroidtutorial.ui.theme.smallPadding
import com.raywenderlich.android.rwandroidtutorial.ui.theme.*
import com.raywenderlich.android.rwandroidtutorial.ui.widgets.MainTopBar


@Composable
fun MainScreen() {

    var isThemeSectionExpanded by remember {
        mutableStateOf(true)
    }


    Scaffold(topBar = {
        MainTopBar(actions = {
            IconButton(onClick = { isThemeSectionExpanded = !isThemeSectionExpanded }) {
                Icon(
                    if (!isThemeSectionExpanded) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropUp,
                    contentDescription = "Localized description"
                )
            }
        })
    }) {


        Column(verticalArrangement = Arrangement.spacedBy(
            smallPadding)) {

            if (isThemeSectionExpanded) {
                ThemeSelectorSection()
            }

            Column(modifier = Modifier.padding(mediumPadding).verticalScroll(rememberScrollState()),verticalArrangement = Arrangement.spacedBy(
                smallPadding)) {
                spaceProbeMissions.forEach {probeMission ->
                    ProbeMissionItem(probeName = probeMission.probeName, missionDescription = probeMission.missionDescription )
                }
            }




        }


    }

}

@Composable
fun ProbeMissionItem(probeName:String,missionDescription:String){
    Box(modifier = Modifier.background(color = MaterialTheme.colors.onSurface)) {
        Column(verticalArrangement = Arrangement.spacedBy(mediumPadding), modifier = Modifier.padding(
            mediumPadding)) {
            Text(text = probeName, fontWeight = FontWeight.Bold)
            Text(text = missionDescription)
        }
    }

}




