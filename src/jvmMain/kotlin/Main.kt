import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application



class AppState {
    val text = mutableStateOf("")       //remember al estar fuera de compose no es necesario
    fun buttonEnable() = text.value.isNotEmpty()
}

@Composable
@Preview
fun App(appState: AppState) {
    MaterialTheme {
        Column {
            TextField(
                value = appState.text.value,
                onValueChange = { newText  ->
                    appState.text.value = newText
                }
            )

            Text(buildMessage(appState.text.value))

            Button(onClick = { appState.text.value = "" }, enabled = appState.buttonEnable()) {
                Text("Clean")
            }
        }

    }
}

fun buildMessage(text: String) = "Hello $text"

fun main() = application {
    val appState = AppState()
    Window(onCloseRequest = ::exitApplication) {
        App(appState)
    }
}
