package com.example.prohappymultiplatform

object Constants {
    const val SCREENING_HEADER = "Please respond the following questions:"
    const val SELECT_MESSAGES_BUTTON = "Messages to future"
    const val START_SESSION_BUTTON = "Start session"
    const val SELECT_EMOTION_HEADER = "Select emotion"
    const val SELECT_SEVERITY_HEADER = "How severe your discomfort is?"
    const val RESPONSIBILITY_HEADER = "Was you the person who caused this situation or responsible for it?"
    const val NEXT_PAGE_BUTTON = "Next"
    const val METAPHORIC_CARD_HEADER = "Work with the metaphoric card"
    const val CARD_EMOTION = "What do you feel when looking at the card?"
    const val CONNECTION_WITH_YOUR_LIFE = "Is there anything about your life?"
    const val TODAY_RESOLUTION = "What is your resolution in relation to the current situation?"
    const val MESSAGE_TO_FUTURE = "Leave yourself a message describing your findings and insights in relation to this card"
}

enum class Emotions (val code: Int) {
    ANXIETY (0),//"тревога"
    FEAR (1),//"страх"
    HORROR (2),//"ужас"
    EMPATHY (3),//"сочуствие"
    DELIGHT (4),//"радость"
    CURIOSITY (5),//"интерес"
    ASTONISHMENT (6),//"удивление"
    GRATEFULNESS (7),//"благодарность"
    TENDERNESS (8),//"нежность"
    LOVE (9),//"любовь"
    DISAPPOINTMENT (10),//"разочарование"
    REGRET (11),//"сожаление"
    OFFENCE (12),//"обида"
    SADNESS (13),//"печаль"
    MELANCHOLY (14),//"тоска"
    DESPAIR (15),//"отчаяние"
    EMBARRASSMENT (16),//"смущение"
    SHAME (17),//"стыд"
    GUILT (18),//"вина"
    CONTEMPT (19),//"презрение"
    JEALOUSY (20),//"зависть"
    DISGUST (21),//"отвращение"
    EMPTINESS (22),//"пустота"
    IRRITATION (23),//"раздражение"
    ANGER(24)//"гнев"
}

enum class Severity (val code: Int) {
    MILD (0),
    MODERATE (1),
    SEVERE (2)
}