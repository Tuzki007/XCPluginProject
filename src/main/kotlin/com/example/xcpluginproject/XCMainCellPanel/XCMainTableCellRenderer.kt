package com.example.xcpluginproject.XCMainCellPanel

import com.example.xcpluginproject.XCMainCellPanel.XCCellPanel.XCMainMessageContentPanel
import com.example.xcpluginproject.XCMainPanelViewModel.XCCellType
import com.example.xcpluginproject.XCMainPanelViewModel.XCTableContentModel
import java.awt.Color
import java.awt.Component
import javax.swing.JTable
import javax.swing.table.DefaultTableCellRenderer

class XCMainTableCellRenderer: DefaultTableCellRenderer() {

    private val mainMessageContentPanel = XCMainMessageContentPanel()

    init {
        // 设置JTable透明
        isOpaque = false
        mainMessageContentPanel.background = Color.YELLOW
    }

    override fun getTableCellRendererComponent(
        table: JTable?,
        value: Any?,
        isSelected: Boolean,
        hasFocus: Boolean,
        row: Int,
        column: Int
    ): Component {
        isOpaque = value == null

        if (!isSelected) {
            background = Color(0, 0, 0, 0)
        }

        if (isSelected) {
            background = table?.background
            foreground = table?.foreground
        } else {
            background = table?.background
            foreground = table?.foreground
        }

        if (value is XCTableContentModel) {

            if (value.xcCellType == XCCellType.XCTaoBaoShoppingCartCellType) {

            } else if (value.xcCellType == XCCellType.XCBilibiliVideoCellType){

            } else if (value.xcCellType == XCCellType.XCBossMessageCellType){

            } else {

            }

        }

        return mainMessageContentPanel
    }

}