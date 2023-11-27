data class Attachment(
    val type: AttachmentType,
    val attachment: AttachmentObject
)

enum class AttachmentType {
    AUDIO, VIDEO, PHOTO, DOC, MARKET
}

interface AttachmentObject {
    val id: Int
    val ownerId: Int
}

interface Photo {
    val photo130: String
    val photo604: String
}

data class PhotoAttachment(
    override val id: Int,
    override val ownerId: Int,
    override val photo130: String,
    override val photo604: String
) : AttachmentObject, Photo

interface Video {
    val title: String
    val description: String
    val duration: Int
}

data class VideoAttachment(
    override val id: Int,
    override val ownerId: Int,
    override val title: String,
    override val description: String,
    override val duration: Int
) : AttachmentObject, Video

interface Audio {
    val artist: String
    val title: String
    val duration: Int
    val url: String
}

data class AudioAttachment(
    override val id: Int,
    override val ownerId: Int,
    override val artist: String,
    override val title: String,
    override val duration: Int,
    override val url: String
) : AttachmentObject, Audio

interface Doc {
    val title: String
    val size: Int
    val ext: String
    val url: String
}

data class DocAttachment(
    override val id: Int,
    override val ownerId: Int,
    override val title: String,
    override val size: Int,
    override val ext: String,
    override val url: String
) : AttachmentObject, Doc

interface Market {
    val title: String
    val description: String
    val price: Int
    val weight: Int
}

data class MarketAttachment(
    override val id: Int,
    override val ownerId: Int,
    override val title: String,
    override val description: String,
    override val price: Int,
    override val weight: Int
) : AttachmentObject, Market