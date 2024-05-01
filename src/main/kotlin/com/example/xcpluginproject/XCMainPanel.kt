package com.example.xcpluginproject

import com.example.xcpluginproject.XCMainCellPanel.XCBackGroundColorType
import com.example.xcpluginproject.XCMainCellPanel.XCMainScrollJViewport
import com.example.xcpluginproject.XCMainCellPanel.XCMainTableCellEditor
import com.example.xcpluginproject.XCMainCellPanel.XCMainTableCellRenderer
import com.example.xcpluginproject.XCMainPanelViewModel.XCMainTableViewModel
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import javax.swing.*
import javax.swing.table.TableCellRenderer

class XCMainPanel {

    // --------------- UI 部分 ---------------
    var xcMainTableViewModel: XCMainTableViewModel = XCMainTableViewModel()

    // --------------- UI 部分 ---------------
    // (1)背景
    val xcMainBackgroundPanel: JPanel = JPanel(BorderLayout())
    // (2)上下分割器
    private val xcSplitPane: JSplitPane = JSplitPane(JSplitPane.VERTICAL_SPLIT)

    // 创建 JTable 并设置模型
    private val xcChatTable = object : JTable(xcMainTableViewModel) {
        // 设置动态行高
        override fun prepareRenderer(renderer: TableCellRenderer, row: Int, column: Int): java.awt.Component {
            val component = super.prepareRenderer(renderer, row, column)
            val rendererWidth = 300
            val tableColumn = getColumnModel().getColumn(column)
            tableColumn.width = Math.max(rendererWidth + intercellSpacing.width, tableColumn.width)

            var rendererHeight = component.preferredSize.height
            if (getRowHeight(row) < rendererHeight) {
                setRowHeight(row, rendererHeight)
            }
            return component
        }
    }

    private val xcScrollPane = JScrollPane(xcChatTable)



    init {

        createMainPanelUI()
    }

    // 创建UI
    fun createMainPanelUI() {

        xcMainBackgroundPanel.background = Color.WHITE

        // 分割面板
        createSplitPane()
        // 列表
        createTableView()
        // 底部输入框
        createInputBottomView()
    }

    // 创建整体面板分割
    private fun createSplitPane() {
        xcSplitPane.topComponent = xcScrollPane
//        xcSplitPane.bottomComponent =
        xcSplitPane.dividerLocation = 650
        xcSplitPane.dividerSize = 1
        xcSplitPane.resizeWeight = 0.9
        xcSplitPane.setContinuousLayout(true);
        xcSplitPane.isOneTouchExpandable = false
        xcSplitPane.setDividerLocation(0.8)
        xcSplitPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, PropertyChangeListener { event: PropertyChangeEvent ->
            SwingUtilities.invokeLater {

            }
        })
        xcMainBackgroundPanel.add(xcSplitPane, BorderLayout.CENTER)
    }

    // 创建列表
    private fun createTableView() {

        xcScrollPane.viewport = XCMainScrollJViewport().also {
            it.view = xcChatTable
            it.xcBGColorType = XCBackGroundColorType.BGLightGreenColorType
        }

        xcChatTable.isOpaque = false
        xcChatTable.setShowGrid(false)
        //移除单元格间距
        xcChatTable.intercellSpacing = Dimension(0, 0)
        xcChatTable.gridColor = Color(0, 0, 0, 0)

        for (column in 0 until xcChatTable.columnCount) {
            xcChatTable.setDefaultEditor(xcChatTable.getColumnClass(column), XCMainTableCellEditor(xcChatTable))
            xcChatTable.setDefaultRenderer(xcChatTable.getColumnClass(column), XCMainTableCellRenderer())
        }

        // 禁止行选中
        xcChatTable.setRowSelectionAllowed(false);
        // 禁止列选中
        xcChatTable.setColumnSelectionAllowed(false);
        // 禁止单元格选中
        xcChatTable.setCellSelectionEnabled(false);
    }

    // 创建底部输入框
    private fun createInputBottomView () {

    }

}



















