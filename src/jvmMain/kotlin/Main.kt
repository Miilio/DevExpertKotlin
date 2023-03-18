import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    val text = remember { mutableStateOf("") }
    //val message = "Hello ${text.value}"
    val buttonEnable = text.value.isNotEmpty()

    MaterialTheme {
        Column {
            TextField(
                value = text.value,
                onValueChange = { newText  ->
                    text.value = newText
                }
            )

            Text(buildMessage(text.value))

            Button(onClick = { text.value = "" }, enabled = buttonEnable) {
                Text("Clean")
            }
        }

    }
}

fun buildMessage(text: String) = "Hello $text"

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
