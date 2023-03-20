data class Note(val title: String, val description: String, val type: Type) {
    enum class Type {
        TEXT, AUDIO
    }
}

val list = listOf(
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
)

