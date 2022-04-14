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




