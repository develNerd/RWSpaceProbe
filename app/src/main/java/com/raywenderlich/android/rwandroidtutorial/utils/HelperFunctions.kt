package com.raywenderlich.android.rwandroidtutorial.utils

import com.raywenderlich.android.rwandroidtutorial.model.*
import com.raywenderlich.android.rwandroidtutorial.ui.screens.*

fun getCurrentColor(colorId:Int): ColorTheme = when(colorId){
    SPACE_GREEN_CODE -> spaceGreenColors
    SPACE_GRAY_CODE -> spaceGrayColors
    SPACE_BLUE_CODE -> spaceBlueColors
    else -> spaceGreenColors
}

fun getCurrentShape(shapeId:Int):ShapeTheme =  when(shapeId){
    SHAPE_SQUARE_CODE -> shapeSquareEdge
    SHAPE_ROUNDED_CODE -> shapeRoundedEdge
    SHAPE_CUT_CODE -> shapeCutEdge
    else -> shapeSquareEdge
}


fun getCurrentFont(fontId:Int):FontsTheme = when(fontId){
    FONT_MONTSERRAT_CODE -> fontMontserrat
    FONT_ROBOTO_CODE -> fontRoboto
    FONT_OPEN_SANS_CODE -> fontOpenSans
    else -> fontOpenSans
}