sealed interface Attachment {
    val type: AttachmentType
    val id: Int
    val ownerId: Int
}

enum class AttachmentType {
    AUDIO, VIDEO, PHOTO, DOC, MARKET
}

data class Photo(val photo130: String, val photo604: String)

data class PhotoAttachment(
    override val type: AttachmentType = AttachmentType.PHOTO,
    override var id: Int,
    override val ownerId: Int,
    val attachmentData: Photo,
) : Attachment

data class Video(val title: String, val description: String, val duration: Int)

data class VideoAttachment(
    override val type: AttachmentType = AttachmentType.VIDEO,
    override var id: Int,
    override val ownerId: Int,
    val attachmentData: Video
) : Attachment

data class Audio(val artist: String, val title: String, val duration: Int, val url: String)

data class AudioAttachment(
    override val type: AttachmentType = AttachmentType.AUDIO,
    override var id: Int,
    override val ownerId: Int,
    val attachmentData: Audio
) : Attachment

data class Doc(val title: String, val size: Int, val ext: String, val url: String)

data class DocAttachment(
    override val type: AttachmentType = AttachmentType.DOC,
    override var id: Int,
    override val ownerId: Int,
    val attachmentData: Doc
) : Attachment

data class Market(val title: String, val description: String, val price: Int, val weight: Int)

data class MarketAttachment(
    override val type: AttachmentType = AttachmentType.MARKET,
    override var id: Int,
    override val ownerId: Int,
    val attachmentData: Market
) : Attachment