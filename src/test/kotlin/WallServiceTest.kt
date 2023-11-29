import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WallServiceTest {
    val service = WallService

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

//    проверка добавления поста
    @Test
    fun addPost() {
        val post1 = service.addPost(Post(text = "Post1"))
        post1.attachments.add(
            Attachment(
                type = AttachmentType.PHOTO,
                attachment = PhotoAttachment(
                    id = 3,
                    ownerId = 2,
                    photo130 = "some_photo_link",
                    photo604 = "another_photo_link"
                )
            )
        )
        assertEquals(1, post1.id)
        assertEquals(1, post1.attachments.size)

    }

//    проверка обновления поста
    @Test
    fun updateIsTrue() {
        service.addPost(Post(text = "Post1"))
        service.addPost(Post(text = "Post2"))

        val update = Post(text = "Post3", id = 2)
        val result = service.update(update)

        assertTrue { result }

    }

//  проверка неудачного обновления несуществующего поста
    @Test
    fun updateIsFalse() {
        service.addPost(Post(text = "Post1"))

        val update = Post(text = "Post2", id = 2)
        val result = service.update(update)

        assertFalse { result }
    }

//    проверка успешного добавления комментария к посту
    @Test
    fun addCommentToPostIsSuccessfully() {
        service.addPost(Post(text = "Post1"))
        val comment = service.createComment(1, Comment(id = 1))

        assertEquals(1, comment.id)
    }

//    проверка ошибки при добавлении комментария к посту
    @Test(expected = PostNotFoundException::class)
    fun addCommentToPostIsFail() {
        service.addPost(Post(text = "Post1"))
        service.createComment(2, Comment(id = 1))
    }

    //    проверка успешного добавления сообщения о нарушении в комментарии
    @Test
    fun addReportToCommentIsSuccessfully() {
        service.addPost(Post(text = "Post1"))
        val comment = service.createComment(1, Comment(id = 1))
        val report = service.createReportComment(
            commentId = 1,
            ReportComment(1, 1, Reason.OFFENSE)
        )
        assertEquals(1, report.commentId)
    }

//    проверка ошибки при добавлении сообщения о нарушении в комментарии
    @Test(expected = CommentNotFoundException::class)
    fun addReportToCommentIsFail() {
        service.addPost(Post(text = "Post1"))
        val comment = service.createComment(1, Comment(id = 1))
        service.createReportComment(
            commentId = 2,
            ReportComment(1, 1, Reason.OFFENSE)
        )
    }

}