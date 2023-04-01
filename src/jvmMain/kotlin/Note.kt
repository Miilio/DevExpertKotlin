import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

data class Note(val title: String, val description: String, val type: Type) {
    enum class Type {
        TEXT, AUDIO
    }
}

suspend fun getNotes(): List<Note> = withContext(Dispatchers.IO) {
    delay(2000)
    val notes = (1..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
    }
    notes
}

/*fun getNotes(callback: (List<Note>) -> Unit) {
    Thread.sleep(2000)
    val notes = (1..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
    }
    callback(notes)
}*/

/*fun getNotes(): List<Note> = (1..10).map {
    Note(
    "Title $it",
    "Description $it",
    if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
    )
}*/

/*val list = listOf(
    Note("title 1", "description 1", Note.Type.TEXT),
    Note("title 2", "description 2", Note.Type.AUDIO),
    Note("title 3", "description 3", Note.Type.TEXT),
    Note("title 4", "description 4", Note.Type.TEXT),
    Note("title 5", "description 5", Note.Type.TEXT),
    Note("title 6", "description 6", Note.Type.AUDIO),
    Note("title 7", "description 7", Note.Type.TEXT),
    Note("title 8", "description 8", Note.Type.TEXT),
    Note("title 9", "description 9", Note.Type.TEXT),
    Note("title 10", "description 10", Note.Type.AUDIO),
)*/

