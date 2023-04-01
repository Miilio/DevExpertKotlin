import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class AppState {
    var state by mutableStateOf(UiState())   //List empty of type Note
    /*fun loadNotes() {
        //Creamos un hilo pero no me funciona no se ve
        Thread {
            state.value = UiState(loading = true)
            getNotes { state.value = UiState(notes = it, loading = false) }
        }
    }*/
    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            state = UiState(loading = true)
            state = UiState(notes = getNotes())
        }

    }

    //data class UiState (val  notes: List<Note> = emptyList(), val loading: Boolean = false)
    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false
    )

}

@Composable
@Preview
fun App(appState: AppState) {
    val notes = appState.state.notes
    //val scope = rememberCoroutineScope() //no es necesario ya que nos da el contexto de la corutina
    if (notes == null) {
        LaunchedEffect(true) {  //Se ejecuta solo una vez
            appState.loadNotes(this)
        }
    }


    MaterialTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (appState.state.loading) {
                CircularProgressIndicator()
            }
            if (notes != null) {
                NotesList(notes)
            }

        }
    }
}



fun main() = application {
    val appState = AppState()
    Window(onCloseRequest = ::exitApplication) {
        App(appState)
    }
}
