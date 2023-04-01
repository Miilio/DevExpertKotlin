import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
fun NotesList(notes: List<Note>) {
    LazyColumn(
        //Center the colum
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {    //render only the cells visible
        items(notes) { note ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.8f)     //busy the 80% of space
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.weight(1f)
                            /*
                                El weight divide el espacio disponible entre todos aquellos componentes que tienen
                                un weight. Como solo lo tiene el Text, pues le asignará el máximo espacio al texto
                                salvo el necesario para el resto (el mic)
                                 */
                        )
                        if (note.type == Note.Type.AUDIO) {
                            //contentDescription to inform at system in case the use for accessibility
                            Icon(
                                imageVector = Icons.Default.Mic,
                                contentDescription = null
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(note.description)
                }
            }
        }
    }
}