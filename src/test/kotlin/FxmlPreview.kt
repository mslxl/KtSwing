import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class FxmlPreview : Application() {
    override fun start(stage: Stage) {
        val parent = FXMLLoader.load<StackPane>(FxmlPreview::class.java.getResource("fxml_preview.fxml"))
        stage.scene = Scene(parent, 400.0, 300.0)
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(FxmlPreview::class.java, *args)
        }
    }
}