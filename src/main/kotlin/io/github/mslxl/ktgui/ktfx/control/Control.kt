@file:JvmName("Control")
@file:JvmMultifileClass

package io.github.mslxl.ktgui.ktfx.control

import io.github.mslxl.ktgui.ktfx.FxPanelNode
import io.github.mslxl.ktgui.ktfx._ktfx
import javafx.geometry.Orientation
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.media.MediaView
import javafx.scene.paint.Color
import javafx.scene.web.HTMLEditor
import javafx.scene.web.WebView
import java.time.LocalDate

inline fun FxPanelNode.button(text: String = "", init: Button.() -> Unit = {}) = _ktfx(Button(text), init)

inline fun FxPanelNode.checkBox(text: String = "", init: CheckBox.() -> Unit = {}) = _ktfx(CheckBox(text), init)

inline fun <T : Any> FxPanelNode.choiceBox(init: ChoiceBox<T>.() -> Unit = {}) = _ktfx(ChoiceBox(), init)

inline fun FxPanelNode.colorPicker(color: Color = Color.WHITE, init: ColorPicker.() -> Unit = {}) = _ktfx(ColorPicker(color), init)

inline fun <T : Any> FxPanelNode.comboBox(init: ComboBox<T>.() -> Unit = {}) = _ktfx(ComboBox(), init)

inline fun FxPanelNode.datePicker(localDate: LocalDate? = null, init: DatePicker.() -> Unit = {}) = _ktfx(DatePicker(localDate), init)

inline fun FxPanelNode.htmlEditor(init: HTMLEditor.() -> Unit = {}) = _ktfx(HTMLEditor(), init)

inline fun FxPanelNode.hyperlink(text: String = "", init: Hyperlink.() -> Unit = {}) = _ktfx(Hyperlink(text), init)

inline fun FxPanelNode.imageView(init: ImageView.() -> Unit = {}) = _ktfx(ImageView(), init)
inline fun FxPanelNode.imageView(url: String, init: ImageView.() -> Unit = {}) = _ktfx(ImageView(url), init)
inline fun FxPanelNode.imageView(image: Image, init: ImageView.() -> Unit = {}) = _ktfx(ImageView(image), init)

inline fun FxPanelNode.label(text: String = "", init: Label.() -> Unit = {}) = _ktfx(Label(text), init)

inline fun <T : Any> FxPanelNode.listView(init: ListView<T>.() -> Unit = {}) = _ktfx(ListView(), init)

inline fun FxPanelNode.mediaView(init: MediaView.() -> Unit = {}) = _ktfx(MediaView(), init)

inline fun FxPanelNode.menuButton(init: MenuButton.() -> Unit = {}) = _ktfx(MenuButton(), init)

inline fun FxPanelNode.splitMenuButton(init: SplitMenuButton.() -> Unit = {}) = _ktfx(SplitMenuButton(), init)

inline fun FxPanelNode.pagination(pageCount: Int = Pagination.INDETERMINATE, pageIndex: Int = 0, init: _Pagination.() -> Unit = {}): Pagination = _ktfx(_Pagination(pageCount, pageIndex), init)

inline fun FxPanelNode.passwordField(init: PasswordField.() -> Unit = {}) = _ktfx(PasswordField(), init)

inline fun FxPanelNode.progressBar(init: ProgressBar.() -> Unit = {}) = _ktfx(ProgressBar(), init)

inline fun FxPanelNode.progressIndicator(init: ProgressIndicator.() -> Unit = {}) = _ktfx(ProgressIndicator(), init)

inline fun FxPanelNode.radioButton(text: String = "", init: RadioButton.() -> Unit = {}) = _ktfx(RadioButton(text), init)

inline fun FxPanelNode.scrollBar(init: ScrollBar.() -> Unit = {}) = _ktfx(ScrollBar(), init)

inline fun FxPanelNode.separator(init: Separator.() -> Unit = {}) = _ktfx(Separator(), init)

inline val FxPanelNode.separator get() = separator()
inline val FxPanelNode.verticalSeparator get() = separator { orientation = Orientation.VERTICAL }

inline fun FxPanelNode.slider(init: Slider.() -> Unit = {}) = _ktfx(Slider(), init)

inline fun FxPanelNode.webView(init: WebView.() -> Unit = {}) = _ktfx(WebView(), init)

inline fun <S> FxPanelNode.treeTableView(init: _TreeTableView<S>.() -> Unit = {})= _ktfx(_TreeTableView(),init)
inline fun <S> FxPanelNode.tableView(init: _TableView<S>.() -> Unit = {}) = _ktfx(_TableView(), init)
inline fun <S> FxPanelNode.treeView(init: _TreeView<S>.() -> Unit = {}) = _ktfx(_TreeView(), init)


inline fun FxPanelNode.textArea(text: String = "", init: TextArea.() -> Unit = {}) = _ktfx(TextArea(text), init)

inline fun FxPanelNode.textField(text: String = "", init: TextField.() -> Unit = {}) = _ktfx(TextField(text), init)

inline fun FxPanelNode.toggleButton(text: String = "", init: ToggleButton.() -> Unit = {}) = _ktfx(ToggleButton(text), init)
