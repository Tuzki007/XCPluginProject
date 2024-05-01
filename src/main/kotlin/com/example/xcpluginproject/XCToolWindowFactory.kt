package com.example.xcpluginproject

import com.intellij.openapi.project.Project
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.content.ContentManagerEvent
import com.intellij.ui.content.ContentManagerListener
import javax.swing.Icon

class XCToolWindowFactory: ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val xcProjectMainPanel = XCMainPanel()

        // 获取ContentFactory的实例
        val contentFactory = ContentFactory.SERVICE.getInstance()
        val content = contentFactory.createContent(xcProjectMainPanel.xcMainBackgroundPanel, "", false)

        toolWindow.contentManager.addContent(content)

        toolWindow.contentManager.addContentManagerListener(object : ContentManagerListener {
            override fun selectionChanged(event: ContentManagerEvent) {
                val isSelected = event.operation == ContentManagerEvent.ContentOperation.add
                toolWindow.setIcon(if (isSelected) XCPluginIcons.ICON_SELECTED else XCPluginIcons.ICON_UNSELECTED)
            }
        })

    }
}

object XCPluginIcons {
    val ICON_SELECTED: Icon = IconLoader.getIcon("/icons/icons8-chatgpt-white.png", XCPluginIcons::class.java)
    val ICON_UNSELECTED: Icon = IconLoader.getIcon("/icons/icons8-chatgpt-grey.png", XCPluginIcons::class.java)
}
