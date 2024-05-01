package com.example.xcpluginproject.XCMainCellPanel

import com.example.xcpluginproject.XCTools.XCColors
import java.awt.Color
import java.awt.GradientPaint
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JViewport

enum class XCBackGroundColorType {
    //（1）默认白色
    BGWhiteColorType,
    //（2）淡紫色
    BGLavenderColorType,
    //（3）淡绿色
    BGLightGreenColorType,
}

// 整体背景（1、颜色 2、背景图片）
class XCMainScrollJViewport: JViewport() {

    // 背景颜色
    public var xcBGColorType:XCBackGroundColorType = XCBackGroundColorType.BGWhiteColorType

    override fun paintComponent(g: Graphics) {

        super.paintComponent(g)

        val graphics2D = g as Graphics2D

        val width = this.width

        val height = this.height

        var startColor = XCColors.xc_white_color

        var endColor = XCColors.xc_white_color

        if (xcBGColorType == XCBackGroundColorType.BGWhiteColorType) {

            startColor = XCColors.xc_lavender_color

            endColor = XCColors.xc_white_color
        } else if (xcBGColorType == XCBackGroundColorType.BGLavenderColorType) {

            startColor = XCColors.xc_lavender_color

            endColor = XCColors.xc_white_color
        } else if (xcBGColorType == XCBackGroundColorType.BGLightGreenColorType) {
            startColor = XCColors.xc_light_green_color

            endColor = XCColors.xc_white_color
        } else {
            startColor = XCColors.xc_lavender_color

            endColor = XCColors.xc_white_color
        }

        val gradientPaint = GradientPaint(0f, 0f, startColor, 0f, height.toFloat(), endColor)

        graphics2D.paint = gradientPaint

        graphics2D.fillRect(0, 0, width, height)
    }
}









