object WallService {
    private var posts = emptyArray<Post>()
    private var reportComments = emptyArray<ReportComment>()
    private var id = 0

//    метод добавления поста
    fun addPost(post: Post): Post {
        posts += post.copy(
            id = ++id,
            likes = post.likes.copy(),
            views = post.views.copy()
        )
        return posts.last()
    }

//    метод обновления поста
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

//    метод создания комментария к посту
    fun createComment(postId: Int, comment: Comment): Comment {
        return posts.run {
            (find { it.id == postId } ?: throw PostNotFoundException()).let {
                it.comments.add(comment.copy())
                it.comments.last()
            }
        }
    }

//    метод создания жалобы на комментарий к посту
    fun createReportComment(commentId: Int, reportComment: ReportComment): ReportComment {
        posts.find {
            it.comments.find { comment -> comment.id == commentId } != null
        } ?: throw CommentNotFoundException()
        reportComments += reportComment.copy(commentId = commentId)
        return reportComments.last()
    }

//    метод очистки данных
    fun clear() {
        posts = emptyArray()
        id = 0
        reportComments = emptyArray()
    }

}