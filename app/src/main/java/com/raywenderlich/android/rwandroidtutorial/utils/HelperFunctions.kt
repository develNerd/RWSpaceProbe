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
    SHAPE_SQUARE_CODE -> squareEdge
    SHAPE_ROUNDED_CODE -> roundedEdge
    SHAPE_CUT_CODE -> cutEdge
    else -> squareEdge
}


fun getCurrentFont(fontId:Int):FontsTheme = when(fontId){
    FONT_MONTSERRAT_CODE -> montserrat
    FONT_ROBOTO_CODE -> roboto
    FONT_OPEN_SANS_CODE -> openSans
    FONT_AMATIC_CODE -> amatic_sc
    else -> openSans
}