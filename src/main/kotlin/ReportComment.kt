data class ReportComment (
    val ownerId: Int = 0,
    val commentId: Int,
    val reason: Reason
)

enum class Reason(val reason: String) {
    SPAM("0 — спам"),
    PORNO("1 — порнография"),
    EXTREMISM("2 — экстремизм"),
    VIOLENCE("3 — насилие"),
    DRUG("4 — пропаганда наркотиков"),
    OFFENSE("5 — оскорбление"),
    SUICIDE("6 — призывы к суициду"),

}