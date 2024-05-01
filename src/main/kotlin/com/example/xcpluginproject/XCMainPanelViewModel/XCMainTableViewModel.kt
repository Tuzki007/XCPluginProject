package com.example.xcpluginproject.XCMainPanelViewModel

import java.util.*
import javax.swing.table.AbstractTableModel

enum class XCCellType {
    // 淘宝购物车列表
    XCTaoBaoShoppingCartCellType,
    // Bilibili视频列表
    XCBilibiliVideoCellType,
    // 发送信息
    XCMessageContentCellType,
    // Boss
    XCBossMessageCellType
}

// 淘宝楼层
public class XCTaoBaoCellModel {

    // (1) 是否选中（true选中，false未选中）
    public var selected: Boolean = false

    // (2) 商品图片
    public var shopImageName: String = ""

    // (3) 商品标题
    public var shopTitle: String = ""

    // (4) 商品副标题
    public var shopSubTitle: String = ""

    // (5) 商品描述
    public var shopDescription: String = ""

    // (6) 商品价格
    public var shopPrice: String = ""

    // (7) 截止时间
    public var finalTime: String = ""

    // (8) 商品数量
    public var productQuantity: String = ""
}

// B站视频列表楼层
public class XCBilibiliVideoCellModel {

}

// 发送信息模型
public class XCMessageContentCellModel {

}

// Boss直聘Model
public class XCBossMessageCellModel {

}


// 列表数据源
public class XCTableContentModel {

    public var xcCellType: XCCellType = XCCellType.XCMessageContentCellType

    // （1）淘宝
    public var xcTaoBaoModel: XCTaoBaoCellModel = XCTaoBaoCellModel()
    // （2）B站
    public var xcBilibiliModel: XCBilibiliVideoCellModel = XCBilibiliVideoCellModel()
    // （3）发送信息
    public var xcMessageContentModel: XCMessageContentCellModel = XCMessageContentCellModel()
    // （4）Boss
    public var xcBossMessageModel: XCBossMessageCellModel = XCBossMessageCellModel()

}

open class XCMainTableViewModel: AbstractTableModel() {

    // 列名
    public var columnNames = Vector<String>()

    // TableView数据源头
    public var xcTableViewDataArray = ArrayList<ArrayList<XCTableContentModel>>()

    init {

        createMockData()
    }

    override fun getRowCount(): Int = xcTableViewDataArray.size
    override fun getColumnCount(): Int = columnNames.size
    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any = xcTableViewDataArray[rowIndex][columnIndex]
    override fun getColumnName(column: Int): String = columnNames[column]

    override fun isCellEditable(row: Int, column: Int): Boolean {
        // 使得所有单元格都可以被编辑
        return true
    }

    // 创建Mock数据
    fun createMockData() {

        // 淘宝
        val tableCellModel: XCTableContentModel = XCTableContentModel()
        tableCellModel.xcCellType = XCCellType.XCTaoBaoShoppingCartCellType
        tableCellModel.xcTaoBaoModel.selected = false
        tableCellModel.xcTaoBaoModel.shopImageName = ""
        tableCellModel.xcTaoBaoModel.shopTitle = "ROG枪神8高端电竞"
        tableCellModel.xcTaoBaoModel.shopSubTitle = "19-14900HX/RTX4070"
        tableCellModel.xcTaoBaoModel.shopDescription = "官方立减737元"
        tableCellModel.xcTaoBaoModel.shopPrice = "￥14736|券后价￥13799"
        tableCellModel.xcTaoBaoModel.finalTime = "库存不足100"
        tableCellModel.xcTaoBaoModel.productQuantity = "x1"

        val xcCellContentArray = ArrayList<XCTableContentModel>()
        xcCellContentArray.add(tableCellModel)

        xcTableViewDataArray.add(xcCellContentArray)


    }



}