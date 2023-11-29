data class Comment (
    val id: Int = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val attachments: MutableList<Attachment> = mutableListOf(),
    val parentsStack: MutableList<Int> = mutableListOf(),
    val thread: Thread = Thread()

)

data class Thread(
    val count: Int = 0,
    val isCanPost: Boolean = false,
    val isShowReplyButton : Boolean = false,
    val isGroupsCanPost : Boolean = false,
)

class CommentNotFoundException(): RuntimeException("Данного комментария не существует")