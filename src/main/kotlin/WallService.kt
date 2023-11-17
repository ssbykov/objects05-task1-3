object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0
    fun addPost(post: Post): Post {
        posts += post.copy(
            id = ++id,
            likes = post.likes.copy(),
            views = post.views.copy()
        )
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, findPost) in posts.withIndex()) {
            if (findPost.id == post.id) {
                posts[index] = post.copy(
                    likes = findPost.likes.copy(),
                    views = findPost.views.copy()
                )
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        id = 0
    }

}