data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val copyright: Copyright? = null,
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String = "post", // post, copy, reply, postpone, suggest
    val postSource: PostSource? = null,
    val geo: Geo? = null,
    val signerId: Int = 0,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isFavorite: Boolean = false,
    val attachments: MutableList<Attachment> = mutableListOf(),
    )

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false,
)

data class Copyright(
    val id: Int = 0,
    val link: String = "",
    val name: String = "",
    val type: String = "",
)

data class Reposts(
    val count: Int = 0,
    val userReposted: Boolean = false,
)

//в документации нет описания параметров этого класса
data class PostSource(
    val source: String = ""
)

data class Geo(
    val type: String,
    val coordinates : String,
    val place: String?,
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = false
)

data class Views(
    val count: Int = 0,
)