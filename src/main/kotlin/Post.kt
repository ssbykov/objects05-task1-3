data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val likes: Likes = Likes(),
    val views: Views = Views(),
    val postType: String = "post", // post, copy, reply, postpone, suggest
    val signerId: Int = 0,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isFavorite: Boolean = false,

    )

data class Likes(
    var count: Int = 0,
    var userLikes: Boolean = false,
    var canLike: Boolean = false
)

data class Views(
    var count: Int = 0,
)