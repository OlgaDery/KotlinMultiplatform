package com.example.testapp

class UserRepo(val user: User) {

    val listOfSessionPatterns = mutableListOf<Int>()
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

enum class NavigationAction {
    StartSession, FirstScreeningCompleted, ExplanationDone, ExerciseDone, MessageDone
}
