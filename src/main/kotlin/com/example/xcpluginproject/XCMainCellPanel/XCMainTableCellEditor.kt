package com.example.xcpluginproject.XCMainCellPanel

import com.example.xcpluginproject.XCMainCellPanel.XCCellPanel.XCMainMessageContentPanel
import com.example.xcpluginproject.XCMainPanelViewModel.XCCellType
import com.example.xcpluginproject.XCMainPanelViewModel.XCTableContentModel
import java.awt.Component
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.*
import javax.swing.AbstractCellEditor
import javax.swing.JTable
import javax.swing.table.TableCellEditor

class XCMainTableCellEditor(parentTable: JTable)  : AbstractCellEditor(), TableCellEditor, ActionListener {

    // 临时Model
    private var templateModel: XCTableContentModel = XCTableContentModel()

    private val mainMessageContentPanel = XCMainMessageContentPanel()

    init {

    }

    override fun getTableCellEditorComponent(
        table: JTable, value: Any?,
        isSelected: Boolean, row: Int, column: Int
    ): Component {

        if (value is XCTableContentModel) {

            templateModel = value

            if (templateModel.xcCellType == XCCellType.XCTaoBaoShoppingCartCellType) {

            } else if (templateModel.xcCellType == XCCellType.XCBilibiliVideoCellType){

            } else if (templateModel.xcCellType == XCCellType.XCBossMessageCellType){

            } else {

            }

        }

        return mainMessageContentPanel
    }

    override fun isCellEditable(e: EventObject): Boolean {
        return true
    }

    override fun getCellEditorValue(): Any {
        return ""
    }

    // 按钮点击事件处理
    override fun actionPerformed(e: ActionEvent) {
        fireEditingStopped()
    }

}
