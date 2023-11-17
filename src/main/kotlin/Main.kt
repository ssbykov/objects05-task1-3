fun main(args: Array<String>) {

    val posts = WallService
    posts.addPost(Post(text = "Post1"))
    posts.addPost(Post(text = "Post2"))
    println(posts.update(Post(id = 2, text = "Post3")))
//    println(posts.posts[1])
}



