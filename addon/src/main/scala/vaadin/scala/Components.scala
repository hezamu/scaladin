package vaadin.scala

import com.vaadin.terminal.Resource
import com.vaadin.ui.themes.BaseTheme
import com.vaadin.ui._
import com.vaadin.data.Property

class ButtonClickListener(action: com.vaadin.ui.Button#ClickEvent => Unit) extends com.vaadin.ui.Button.ClickListener {
  def buttonClick(event: com.vaadin.ui.Button#ClickEvent) = action(event)
}

class Button(caption: String = null, action: com.vaadin.ui.Button#ClickEvent => Unit = null, icon: Resource = null, style: String = null, enabled: Boolean = true)
    extends com.vaadin.ui.Button(caption) {
  setIcon(icon)
  setStyleName(style)
  setEnabled(enabled)

  if (action != null) addListener(action)

  def addListener(action: com.vaadin.ui.Button#ClickEvent => Unit): Unit = addListener(new ButtonClickListener(action))
}

class LinkButton(caption: String = null, action: com.vaadin.ui.Button#ClickEvent => Unit = null, icon: Resource = null, style: String = null)
    extends Button(caption, action, icon) {
  setStyleName(BaseTheme.BUTTON_LINK)
  addStyleName(style);
}

class CheckBox(caption: String = null, immediate: Boolean = false, action: com.vaadin.ui.Button#ClickEvent => Unit = null, icon: Resource = null, style: String = null, enabled: Boolean = true, description: String = null)
    extends com.vaadin.ui.CheckBox(caption) {
  setImmediate(immediate)
  setIcon(icon)
  setStyleName(style)
  setEnabled(enabled)
  setDescription(description)

  if (action != null) addListener(action)

  def addListener(action: com.vaadin.ui.Button#ClickEvent => Unit): Unit = addListener(new ButtonClickListener(action))
}

// icon, caption as constructor parameters?
class Label(content: String = null, width: String = 100 percent, height: String = null, property: Property = null, contentMode: Integer = com.vaadin.ui.Label.CONTENT_DEFAULT, style: String = null)
    extends com.vaadin.ui.Label(content, contentMode) {
  setWidth(width)
  setHeight(height)
  if (property != null) setPropertyDataSource(property)
  setStyleName(style)
}

class HtmlLabel(content: String = null, width: String = 100 percent, height: String = null, property: Property = null, style: String = null)
  extends Label(width = width, height = height, content = content, property = property, contentMode = com.vaadin.ui.Label.CONTENT_XHTML, style = style)

class TextField(caption: String = null, width: String = null, height: String = null, property: Property = null, style: String = null, prompt: String = null)
    extends com.vaadin.ui.TextField(caption) {
  setWidth(width)
  setHeight(height)
  if (property != null) setPropertyDataSource(property)
  setStyleName(style)
  setInputPrompt(prompt)
}

class TextArea(caption: String = null, width: String = null, height: String = null, property: Property = null, style: String = null, prompt: String = null)
    extends com.vaadin.ui.TextArea(caption) {
  setWidth(width)
  setHeight(height)
  if (property != null) setPropertyDataSource(property)
  setStyleName(style)
  setInputPrompt(prompt)
}

class DateField(caption: String = null, width: String = null, height: String = null, property: Property = null, style: String = null, value: Any = null, resolution: Int = com.vaadin.ui.DateField.RESOLUTION_MSEC)
    extends com.vaadin.ui.DateField(caption) {
  setWidth(width)
  setHeight(height)
  if (property != null) setPropertyDataSource(property)
  setStyleName(style)
  setResolution(resolution)
}

class InlineDateField(caption: String = null, width: String = null, height: String = null, property: Property = null, style: String = null, value: Any = null, resolution: Int = com.vaadin.ui.DateField.RESOLUTION_MSEC)
    extends com.vaadin.ui.InlineDateField(caption) {
  setWidth(width)
  setHeight(height)
  if (property != null) setPropertyDataSource(property)
  setStyleName(style)
  setResolution(resolution)
}