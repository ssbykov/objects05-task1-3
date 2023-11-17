object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0
    fun addPost(post: Post): Post {
        posts += post.copy(id = id++)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, findPost) in posts.withIndex()) {
            if (findPost.id == post.id) {
                posts[index] = post.copy(id = findPost.id)
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