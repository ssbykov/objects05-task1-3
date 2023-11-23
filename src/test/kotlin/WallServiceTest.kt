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

    @Test
    fun addPost() {
        val post1 = service.addPost(Post(text = "Post1"))
        post1.attachments.add(
            PhotoAttachment(
                id = 3,
                ownerId = 2,
                attachmentData = Photo("some_photo_link", "another_photo_link")
            )
        )
        assertEquals(1, post1.id)
        assertEquals(1, post1.attachments.size)

    }

    @Test
    fun updateIsTrue() {
        service.addPost(Post(text = "Post1"))
        service.addPost(Post(text = "Post2"))

        val update = Post(text = "Post3", id = 2)
        val result = service.update(update)

        assertTrue { result }

    }

    @Test
    fun updateIsFalse() {
        service.addPost(Post(text = "Post1"))

        val update = Post(text = "Post2", id = 2)
        val result = service.update(update)

        assertFalse { result }
    }


}