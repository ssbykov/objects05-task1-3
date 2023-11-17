import org.junit.Test
import kotlin.test.assertEquals

class WallServiceTest {
    val service = WallService


    @Test
    fun addPost() {
        val post1 = service.addPost(Post(text = "Post1"))
        assertEquals(0, post1.id)
        assertEquals("Post1", post1.text)

        service.addPost(Post(text = "Post2"))
        service.addPost(Post(text = "Post3"))

    }

    @Test
    fun update() {
        var update = Post(text = "Post4", id = 2)

        var result = service.update(update)
        assertEquals(true, result)

        update = Post(text = "Post4", id = 3)
        result = service.update(update)
        assertEquals(false, result)


    }
}