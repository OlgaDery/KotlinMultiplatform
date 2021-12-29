package com.example.testapp

class UserRepo(val user: User) {

    //therapyIsRequired - level - the level of stress, abuse level, difference between values and satisfaction, emotions????
    //the level of understanding of the problems and readiness for the therapy
    //the level of the personal complexity
    //optional - the level of maturity
    //patterns of personality

    //Building the profile digital index:
    //1st digit - general accessibility level (excluding people with serious conditions)
    //2nd - general disbalance level
    //3th - general stress level
    //4th - parental abuse level
    //5th - current family abuse level
    //6th - mismatch between values and satisfaction level

    //TODO psycopatic aspect and unbalanced psychotic
    //can not be melancholic

    val innerResourcetandingLevel1 = "Судя по результатам тестирования, вы неплохо понимаете свои желания и потребности. " +
            "Это очень важно для поддержания психологического баланса."
    val innerResourceUnderstandingLevel2 = "Судя по результатам тестирования, вы можете частично идентифицировать ваши желания и потребности. При этом ваша " +
            "личность слишком сильно формировалась под влиянием окружающих, поэтому на поверку многие " +
            "ваши желания могут оказаться навязанными извне (или они появились как реакция на давление). Рекомендуем вам посвятить некоторое время упражнениям, представленным в соответствующем разделе, " +
            "чтобы усвоить более экологичный подход к осознанию своих желаний."
    val innerResourceUnderstandingLevel3 = "Судя по результатам тестирования, у вас очень насыщенная внутренняя жизнь, " +
            "скорее всего, наполненная воображаемыми ситуациями и персонажами. " +
            "Но при этом что вы знаете о своих истинных желаниях и интересах, не основанных на стремлении сбежать от реальности? " +
            "У вас есть возможность начать это увлекательное путешествие!"

    val cognitiveDistortionsLevel1 = "Вы на достаточно хорошей волне с реальностью. Вам свойственны некоторые " +
            "когнитивные искажения (ложные убеждения) касаемо вас и ваших отношений с миром, но в целом они не оказывают " +
            "существенного влияния на вашу жизнь. Вы достаточно гибкий человек, готовый отказываться от своих предрассудков."
    val cognitiveDistortionsLevel2 = "У вас достаточно много ложных убеждений, которые могут существенно осложнять " +
            "вашу жизнь, мешать с достижении целей и в выстраивании отношений с окружающими. Разумеется, это не ваша вина " +
            "- скорее всего, значительная часть этих убеждений сформировались еще в детстве."
    val cognitiveDistortionsLevel3 = "Судя по вашим ответам, у вас существенный отрыв от реальности, " +
            "и вы изрядно держитесь за свои когнитивные искажения. Это может существенно осложнять отношения с окружающими."

    val adaptivityHighestLevel = "У вас достаточно хорошая адаптивность, то есть развиты механизмы психики, позволяющие вам справиться со стрессом. " +
            "Видимо, вы умеете выключать себя из непродуктивных мыслей и правильно утилизировать токсичные эмоции. "

    val adaptivityModeratetLevel = "У вас средняя адаптивность, то есть развиты механизмы психики, позволяющие вам справиться со стрессом. " +
            "При этом, судя по всему, у вас отлажены механизмы управления стрессом только в определенных областях жизни - возможно, " +
            "на работе или в общении с близкими людьми. Остальные незнакомые или стрессовые ситуации могут " +
            "выглядеть для вас настолько пугающими, что вы можете выключить из своей жизни целые важные аспекты, лишь бы избежать потенциально травматичного опыта."

    val adaptivityLowLevel = "Вы - чемпион по избеганию потенциальных проблем, и ваш уровень сопротивления стрессу очень низок. " +
            "Это не может не влиять на качество жизни. "

    val emotionsSupressed = "Вы склонны подавлять свои эмоции и минимально принимать их во внимание, что не очень хорошо с точки " +
            "зрения психического здоровья. Рекомендуем вам заняться эмоциональным самонаблюдением и побольше внимания уделять этой сфере вашнй жизни."

    val emotionsNormal = "У вас все неплохо с управлением эмоциями - вы не застреваете в негативе и ваш эмоциональный мир вполне сбалансирован."

    val emotionsHystericHighLevel = "Вы человек излишне эмоциональный во всем - и в горе и в радости. " +
            "Вам сложно контролировать эмоции, зачастую это доставляет неудобства."

    val emotionsNeurotic = "У вас есть некоторый дисбаланс в сторону переживания чувства вины и тревоги за близких вам людей. " +
            "Тем не менее, в целом вы владеете механизмом управления токсичными эмоциями."

    val emotionsUncontrolled = "Вы человек очень эмоциональный, даже если это не проявляется открыто. " +
            "Ваши эмоции интенсивны и насыщены, при этом зачастую вы более подверженны негативным переживаниям и не очень понимаете, как с ними совладать."

    val competenceUnderstandingHighLevel = "Вы достаточно хорошо осведомлены о своих сильных сторонах - " +
            "не только о профессиональных, но и о том, что называется soft skills - это эмпатия, целеустремленность и тд."

    val competenceUnderstandingMediumLevel = "Скорее всего, у вас несколько однобокое представление о ваших сильных сторонах " +
            "- вы культивируете определенные свои качества или компетенции, но игнорируете другие."

    val competenceUnderstandingLowLevel = "Согласно результатам тестирования, вы достаточно " +
            "слабо представляете себе свои сильные стороны и даже, скорее всего, вообще сомневаетесь в их наличие."

    val generalPsycologicalDeviationLevel: Int by lazy {
        calculateGeneralPsycologicalDeviationLevel()
    }

    val emotionalDisbalanceLevel: Int by lazy {
        calculateEmotionallDisbalanceLevel()
    }

    val parentalAbuseLevel: Int by lazy {
        calculateParentalAbuseLevel()
    }

    val lifeDissatisfactionLevel: Int by lazy {
        calculateLifeDissatisfactionLevel()
    }

    val currentFamilyAbuseLevel: Int by lazy {
        calculateCurrentFamilyAbuseLevel()
    }

    val generalStressLevel: Int by lazy {
        calculateGeneralStressLevel()
    }

    val neurotic: Int by lazy {
        calculateIfNeurotic()
    }
    val psychotic: Int by lazy {
        calculateIfPsychotic()
    }

    val narcissist: Int by lazy {
        calculateIfNarcissist()
    }

    val mazohist: Int by lazy {
        calculateIfMazohist()
    }

    val resourceless: Int by lazy {
        calculateIfResourceless()
    }

    val schizoid: Int by lazy {
        calculateIfSchizoid()
    }

    val paranoid: Int by lazy {
        calculateIfParanoid()
    }

    val passiveAggressive: Int by lazy {
        calculateIfPassiveAggressive()
    }

    var sortedListOfAccentuations = mutableListOf<Pair<String, Int>>()
        get() {
            return mutableListOf<Pair<String, Int>>().apply {
                add(Pair(StaticStrings.NARCISSIST, narcissist))
                add(Pair(StaticStrings.NEUROTIC, neurotic))
                add(Pair(StaticStrings.PARANOID, paranoid))
                add(Pair(StaticStrings.PSYCHOTIC, psychotic))
                add(Pair(StaticStrings.SCHIZOID, schizoid))
                add(Pair(StaticStrings.HYSTERICAL, resourceless))
                add(Pair(StaticStrings.MAZOCHIST, mazohist))
                add(Pair(StaticStrings.DEPRESSIVE, depressive))
                add(Pair(StaticStrings.PASSIVE_AGGRESSIVE, passiveAggressive))
                sortByDescending { it.second }
            }
        }

    val emotionsEvaluation: String
        get(){
            return when  {
                (allPatterns[0].second > 7) -> {
                    if (allPatterns[0].first == StaticStrings.SCHIZOID || allPatterns[0].first == StaticStrings.MAZOCHIST) {
                        emotionsSupressed
                    }
                    else if (allPatterns[0].first == StaticStrings.NARCISSIST || allPatterns[0].first == StaticStrings.PASSIVE_AGGRESSIVE
                        || allPatterns[0].first == StaticStrings.PARANOID || allPatterns[0].first == StaticStrings.PSYCHOTIC
                        || allPatterns[0].first == StaticStrings.DEPRESSIVE) {
                        emotionsUncontrolled
                    }
                    else if (allPatterns[0].first == StaticStrings.NEUROTIC) {
                        emotionsNeurotic
                    } else {
                        emotionsHystericHighLevel
                    }
                }

                else -> {emotionsNormal}
            }
        }

    val competenceEvaluation: String
        get(){
            return when  {
                (allPatterns[0].second > 10) -> {
                    if (allPatterns[0].first == StaticStrings.PASSIVE_AGGRESSIVE || allPatterns[0].first == StaticStrings.MAZOCHIST) {
                        competenceUnderstandingLowLevel
                    }
                    else if (allPatterns[0].first == StaticStrings.NARCISSIST || allPatterns[0].first == StaticStrings.SCHIZOID
                        || allPatterns[0].first == StaticStrings.PARANOID || allPatterns[0].first == StaticStrings.PSYCHOTIC
                        || allPatterns[0].first == StaticStrings.DEPRESSIVE) {
                        competenceUnderstandingMediumLevel
                    }
                    else {
                        competenceUnderstandingMediumLevel
                    }
                }
                (allPatterns[0].second in 7..10) -> {
                    if (allPatterns[0].first == StaticStrings.PASSIVE_AGGRESSIVE || allPatterns[0].first == StaticStrings.MAZOCHIST) {
                        competenceUnderstandingMediumLevel
                    }
                    else if (allPatterns[0].first == StaticStrings.NARCISSIST || allPatterns[0].first == StaticStrings.SCHIZOID
                        || allPatterns[0].first == StaticStrings.PARANOID || allPatterns[0].first == StaticStrings.PSYCHOTIC
                        || allPatterns[0].first == StaticStrings.DEPRESSIVE) {
                        competenceUnderstandingMediumLevel
                    }
                    else {
                        competenceUnderstandingHighLevel
                    }
                }

                else -> {competenceUnderstandingHighLevel}
            }
        }

    val abuseLevel: String by lazy {
        when (parentalAbuseLevel) {
            4 -> {
                "В родительской семье вы жили в крайне неблагоприятных условиях и подвергались " +
                        "эмоциональному и физическому насилию, что, возможно, сейчас сказывается на вашей психике и на отношениях " +
                        "с окружающими. Скорее всего, ваши родители были психически нездоровы, и мы настоятельно рекомендуем обсудить вашу семейную историю с психологом."
            }
            3 -> {
                "Достаточно высокий уровень родительского абьюза, что, скорее всего, не прошло для вас бесследно. " +
                        "Скорее всего, у ваших родителей были эмоциональные проблемы. Помимо работы с приложением, потратьте некоторое количество времени " +
                        "на изучение публикаций в Интернете по этой теме."
            }
            2 -> {
                "Средний уровень агрессии в родительской семье. Скорее всего, ваши родители неосознанно использовали усвоенные ими в их " +
                        "собственной семье паттерны манипуляции, ошибочно принимая их за эффективные воспитательные инструменты. " +
                        "Тем не менее, уровень абьюза не выглядит патологическим."
            }
            1 -> {
                "Возможно, ваши родители были не идеальны, но в целом семейная атмосфера была здоровой и " +
                        "вам были созданы предпосылки вырасти достаточно психически здоровым человеком."
            }
            else -> {""}
        }
    }

    val pessimismLevel: String by lazy {
        when  {
            (depressive in 12..16) -> {
                "К сожалению, вы совсем не верите, что у вас вас в жизни еще есть новые возможности и горизонты. К счастью, это поправимо!"
            }
            (depressive in 8..11) -> {
                "Вы достаточно пессимистично смотрите в будущее. Уделяйте рекомендуем вам работать над развитием ядра личности, над своими " +
                        "убеждениями, и делать упражнения из этого блока не реже нескольких раз в неделю!"
            }
            (depressive in 5..7) -> {
                "Вы немного дезориентированы, но в целом понимаете, что у вас есть потенциал и перед вами открыты множество дверей."
            }
            (depressive < 5) -> {
                "Вашему оптимизму можно позавидовать! Видимо, у вас здравая самооценка и правильное понимание того, как выстраивать отношения с окружаюзим миром."
            }
            else -> {""}
        }
    }

    val innerResourceEvaluation: String
        get(){
            return when  {
                (allPatterns[0].second > 10) -> {
                    if (allPatterns[0].first == StaticStrings.SCHIZOID || allPatterns[0].first == StaticStrings.PSYCHOTIC ||
                        allPatterns[0].first == StaticStrings.PARANOID) {
                        innerResourceUnderstandingLevel3
                    }
                    else if (allPatterns[0].first == StaticStrings.MAZOCHIST || allPatterns[0].first == StaticStrings.DEPRESSIVE) {
                        innerResourceUnderstandingLevel3
                    }
                    else if (allPatterns[0].first == StaticStrings.NARCISSIST || allPatterns[0].first == StaticStrings.PASSIVE_AGGRESSIVE) {
                        innerResourceUnderstandingLevel2
                    }
                    innerResourceUnderstandingLevel2
                }
                (allPatterns[0].second in 5..10) -> {
                    if (allPatterns[0].first == StaticStrings.SCHIZOID || allPatterns[0].first == StaticStrings.PSYCHOTIC
                        || allPatterns[0].first == StaticStrings.PARANOID) {
                        innerResourceUnderstandingLevel2
                    }
                    else if (allPatterns[0].first == StaticStrings.MAZOCHIST
                        || allPatterns[0].first == StaticStrings.DEPRESSIVE) {
                        innerResourceUnderstandingLevel2
                    }
                    else innerResourcetandingLevel1
                }

                else -> {innerResourcetandingLevel1}
            }
        }

    val temperamentEvaluation: String

        get() {
            val builder = StringBuilder()
            when  {
                (user.melancholic!! > user.phlegmatic!! && (user.melancholic!! > user.sanguine!!) && (user.melancholic!! > user.choleric!!)) -> {
                    return builder.append("Тип нервной системы - слабый, неуровновешенный, высокая чувствительность и низкая выносливость. Низкая адаптивность " +
                            "и устойчивость к фрустрации. Характеристики инертности/подвижности (способность к многозадачности и смене видов деятельности) могут варьироваться.").append("\n").toString()
                }
                (user.phlegmatic!! > user.melancholic!! && (user.phlegmatic!! > user.sanguine!!) && (user.phlegmatic!! > user.choleric!!)) -> {
                    return builder.append("Тип высшей нервной деятельности уравновешенный инертный — с сильными процессами возбуждения и торможения и с низкой подвижностью, испытывающий затруднения при переключении " +
                            "с одного вида деятельности на другой. Высокая устойчивость к фрустрации.").append("\n").toString()
                }
                (user.sanguine!! > user.melancholic!! && (user.sanguine!! > user.phlegmatic!!) && (user.sanguine!! > user.choleric!!)) -> {
                    return builder.append("Тип высшей нервной деятельности сильный уравновешенный подвижный — имеет одинаково сильные процессы возбуждения и торможения с хорошей их подвижностью, " +
                            "что обеспечивает высокие адаптивные возможности и устойчивость к фрустрации.").append("\n").toString()
                }
                (user.choleric!! > user.melancholic!! && (user.choleric!! > user.phlegmatic!!) && (user.choleric!! > user.sanguine!!)) -> {
                    return builder.append("Тип высшей нервной деятельности сильный неуравновешенный подвижный — " +
                            "процессы возбуждения более интенсивны, чем процессы торможения, благодаря чему нервная система быстро истощается." +
                            "Изначально низкая устойчивость к фрустрации, но есть неплохой потенциал к тренировке нервной системы.").append("\n").toString()}
            }
            return " Смешанный тип нервной системы. Нет выраженности характеристик по силе-слабости,  неуровновешенности и чувствительности."
        }

    val adaptivityEvaluation: String
        get() {
            return when  {
                (allPatterns[0].second > 10) -> {
                    if (allPatterns[0].first == StaticStrings.SCHIZOID || allPatterns[0].first == StaticStrings.PSYCHOTIC
                        || allPatterns[0].first == StaticStrings.PARANOID) {
                        adaptivityLowLevel
                    }
                    else if (allPatterns[0].first == StaticStrings.MAZOCHIST) {
                        adaptivityLowLevel
                    }
                    else if (allPatterns[0].first == StaticStrings.NARCISSIST || allPatterns[0].first == StaticStrings.PASSIVE_AGGRESSIVE
                        || allPatterns[0].first == StaticStrings.PARANOID) {
                        adaptivityModeratetLevel
                    } else {
                        adaptivityModeratetLevel
                    }

                }
                (allPatterns[0].second in 5..10) -> {
                    if (allPatterns[0].first == StaticStrings.SCHIZOID || allPatterns[0].first == StaticStrings.PSYCHOTIC
                        || allPatterns[0].first == StaticStrings.PARANOID || allPatterns[0].first == StaticStrings.DEPRESSIVE) {
                        adaptivityModeratetLevel
                    }
                    else if (allPatterns[0].first == StaticStrings.MAZOCHIST) {
                        adaptivityModeratetLevel
                    }
                    else if (allPatterns[0].first == StaticStrings.NARCISSIST || allPatterns[0].first == StaticStrings.PASSIVE_AGGRESSIVE) {
                        adaptivityModeratetLevel

                    } else {
                        adaptivityHighestLevel
                    }

                }
                else -> {adaptivityHighestLevel}
            }
        }

    val goalsAchievementEvaluation: String by lazy {
        when (lifeDissatisfactionLevel) {
            4 -> { "У вас очень сильный разрыв между желаемым и действительным. " +
                    "Это может быть связано с разными причинами - низкая самооценка, непонимание своих истинных желаний и возможностей,  " +
                    "слабые волевые качества или слишком много ложных убеждений, которые мешают вам достигать желаемого." }
            3 -> {"У вас существенный разрыв между желаемым и действительным. Это может быть связано с разными причинами - низкая самооценка, непонимание своих истинных желаний " +
                    "и возможностей, слабые волевые качества или слишком много ложных убеждений, которые мешают вам достигать желаемого." }
            2 -> {"У вас есть некоторый разрыв между желаемым и действительным, но в целом тенденция положительная " +
                    "- у вас есть мотивация и понимание того, как ставить цели и достигать их." }
            1 -> {"Поздравляем, у вас минимальный разрыв между желаемым и действительным! " +
                    "Вы виртуозны не только в постановке целей, но и в понимании того, что вам нужно на самом деле." }
            else -> {""}
        }
    }

    val locusAndSelfEsteemEvaluation: String by lazy {
        if (schizoid > 10 || psychotic > 10 || paranoid > 10 || depressive > 10) {
            cognitiveDistortionsLevel3
        } else if (narcissist > 8 || passiveAggressive > 8 || mazohist > 8 || depressive > 8) {
            cognitiveDistortionsLevel2
        } else if (schizoid in 6..10 || psychotic in 6..10 || paranoid in 6..10) {
            cognitiveDistortionsLevel2
        } else {
            cognitiveDistortionsLevel1
        }
    }

    fun calculateSection2Description (): String {
        val builder = StringBuilder()
        user.apply {
            //The highest level of risk, may be block the app access
            if (allPatterns[0].first == StaticStrings.PSYCHOTIC) {
                //dangerous level, blocking the app
                builder.append("В первую очередь рекомендуем " +
                        "вам обратить внимание на упражнения из разделов МОЙ РЕСУРС, УБЕЖДЕНИЯ и АДАПТАЦИЯ.").append("\n")
                    .append(innerResourceEvaluation).append("\n")
                    .append(locusAndSelfEsteemEvaluation).append("\n")
                    .append(adaptivityEvaluation).append("\n")
            }
            else if (allPatterns[0].first == StaticStrings.NARCISSIST ||
                allPatterns[0].first == StaticStrings.PASSIVE_AGGRESSIVE) {
                //dangerous level, blocking the app
                builder.append("В первую очередь рекомендуем " +
                        "вам обратить внимание на упражнения из разделов УБЕЖДЕНИЯ, ЭМОЦИИ и МОЙ РЕСУРС.").append("\n")
                    .append(locusAndSelfEsteemEvaluation).append("\n")
                    .append(emotionsEvaluation).append("\n")
                    .append(innerResourceEvaluation).append("\n")
            }
            else if (allPatterns[0].first == StaticStrings.PARANOID) {
                builder.append("В первую очередь рекомендуем " +
                        "вам обратить внимание на упражнения из разделов УБЕЖДЕНИЯ, ЭМОЦИИ и АДАПТАЦИЯ.").append("\n")
                    .append(locusAndSelfEsteemEvaluation).append("\n")
                    .append(emotionsEvaluation).append("\n")
                    .append(adaptivityEvaluation).append("\n")
            }
            else if (allPatterns[0].first == StaticStrings.SCHIZOID) {
                builder.append("В первую очередь рекомендуем " +
                        "вам обратить внимание на упражнения из разделов МОЙ РЕСУРС, ЭМОЦИИ и АДАПТАЦИЯ.").append("\n")
                    .append(innerResourceEvaluation).append("\n")
                    .append(emotionsEvaluation).append("\n")
                    .append(adaptivityEvaluation).append("\n")

            }
            else if (allPatterns[0].first == StaticStrings.MAZOCHIST || allPatterns[0].first == StaticStrings.DEPRESSIVE) {
                builder.append("В первую очередь рекомендуем " +
                        "вам обратить внимание на упражнения из разделов МОЙ РЕСУРС, ЦЕЛЕПОЛАГАНИЕ и УБЕЖДЕНИЯ.").append("\n")
                    .append(innerResourceEvaluation).append("\n")
                    .append(goalsAchievementEvaluation).append("\n")
                    .append(locusAndSelfEsteemEvaluation).append("\n")

            }
            else if (allPatterns[0].first == StaticStrings.HYSTERICAL) {
                builder.append("В первую очередь рекомендуем " +
                        "вам обратить внимание на упражнения из разделов ЦЕЛЕПОЛАГАНИЕ, УБЕЖДЕНИЯ и МОЙ РЕСУРС.").append("\n")
                    .append(goalsAchievementEvaluation).append("\n")
                    .append(locusAndSelfEsteemEvaluation).append("\n")

            }
            else if (allPatterns[0].first == StaticStrings.NEUROTIC) {
                //dangerous level, blocking the app
                builder.append("В первую очередь рекомендуем " +
                        "вам обратить внимание на упражнения из разделов ЭМОЦИИ, МОЙ РЕСУРС и УБЕЖДЕНИЯ.").append("\n")
                    .append(emotionsEvaluation).append("\n")
                    .append(innerResourceEvaluation).append("\n")
                    .append(locusAndSelfEsteemEvaluation).append("\n")
            }

        }
        return builder.toString()
    }

    fun calculateSection1Description (): String {
        val builder = StringBuilder()
        user.apply {
            //The highest level of risk, may be block the app access
            builder.append("Общий уровень психической стабильности:").append("\n")

            when  {
                allPatterns[0].second > 15 -> {
                    if (allPatterns[0].first == StaticStrings.PARANOID || allPatterns[0].first == StaticStrings.PSYCHOTIC ||
                        allPatterns[0].first == StaticStrings.SCHIZOID || allPatterns[0].first == StaticStrings.DEPRESSIVE) {
                        builder.append("У вас явно серьезные проблемы с психологической стабильностью, если есть возможность, " +
                                "обратитесь к очному психотерапевту. Если такой возможности нет, обязательно выполняйте упражнения в приложении, " +
                                "и следите за своим состоянием!").append("\n")
                    }
                    else if (allPatterns[0].first == StaticStrings.NARCISSIST || allPatterns[0].first == StaticStrings.MAZOCHIST ||
                        allPatterns[0].first == StaticStrings.PASSIVE_AGGRESSIVE) {
                        builder.append("Несмотря на то, что у вас нет проблем в клиническом смысле, по результатам ответа на вопросы создается впечатление, что вы не очень " +
                                "довольны тем, как складывается ваша жизнь и отношения с окружающими. Если у вас нет возможности обратиться к психологу, " +
                                "пройдите серию упражнений в приложении. Имейте в виду, что ваша готовность к изменениям может " +
                                "быть ниже вашей реальной потребности, и это может повлиять на эффективность.").append("\n")
                    }
                    else if (allPatterns[0].first == StaticStrings.NEUROTIC || allPatterns[0].first == StaticStrings.HYSTERICAL) {
                        builder.append("У вас нет никаких серьезных (тем более клинических) проблем, требующих профессионального вмешательства. " +
                                "Тем не менее, создается ощущение, что вы не очень довольны своей жизнью или собой, обязательно пройдите серию упражнений в приложении!").append("\n")
                    }
                }
                allPatterns[0].second in 7..15 -> {
                    if (allPatterns[0].first == StaticStrings.PARANOID || allPatterns[0].first == StaticStrings.PSYCHOTIC ||
                        allPatterns[0].first == StaticStrings.SCHIZOID) {
                        builder.append("Мы наблюдаем в вашем состоянии некоторые тревожные симптомы, свидетельствующие о том, что в вашем состоянии все не идеально. " +
                                "Если у вас нет возможности обратиться к психологу, обязательно пройдите серию упражнений в приложении!").append("\n")
                    }
                    else if (allPatterns[0].first == StaticStrings.NARCISSIST || allPatterns[0].first == StaticStrings.MAZOCHIST ||
                        allPatterns[0].first == StaticStrings.PASSIVE_AGGRESSIVE) {
                        builder.append("Вы сравнительно неплохо справляетесь со стрессом и жизненными неурядицами, в то же время нельзя сказать, что вы являетесь эталоном " +
                                "самоконтроля, и вас все полностью устраивает в вашей жизни. Возможно, сейчас вам не требуется профессиональная помощь, но мы " +
                                "рекомендуем вам пройти курс упражнений в приложении.").append("\n")
                    }
                    else {
                        builder.append("У вас все достаточно неплохо, скорее всего, на текущий момент вы вполне успешно справляетесь со своими жизненными неурядицами. " +
                                "Тем не менее, пройти серию упражнений, предложенных нашим приложением, никогда не помешает.").append("\n")
                    }
                }
                allPatterns[0].second < 7 -> {
                    if (allPatterns[0].first == StaticStrings.PARANOID || allPatterns[0].first == StaticStrings.PSYCHOTIC ||
                        allPatterns[0].first == StaticStrings.SCHIZOID) {
                        //dangerous level, blocking the app
                        builder.append("На текущий момент у вас все достаточно неплохо, но, исходя из ответов на вопросы профиля, " +
                                "у нас есть основания полагать, что в вашей жизни были намного более тяжелые периоды. " +
                                "Продолжайте работать над собой и внимательно следите за своим состоянием!").append("\n")
                    }
                    else {
                        builder.append("У вас все достаточно неплохо, скорее всего, на текущий момент вы вполне успешно справляетесь со своими жизненными неурядицами. " +
                                "Тем не менее, пройти серию упражнений, предложенных нашим приложением, никогда не помешает").append("\n")
                    }
                }
            }
        }
        return builder.toString()
    }

    fun calculateStructureOfPatterns(): String {
        val builder = StringBuilder()
        mutableListOf<Pair<String, Int>>().apply {
            add(Pair(StaticStrings.NARCISSIST, narcissist))
            add(Pair(StaticStrings.NEUROTIC, neurotic))
            add(Pair(StaticStrings.PARANOID, paranoid))
            add(Pair(StaticStrings.PSYCHOTIC, psychotic))
            add(Pair(StaticStrings.SCHIZOID, schizoid))
            add(Pair(StaticStrings.HYSTERICAL, resourceless))
            add(Pair(StaticStrings.MAZOCHIST, mazohist))
            add(Pair(StaticStrings.PASSIVE_AGGRESSIVE, passiveAggressive))
            add(Pair(StaticStrings.DEPRESSIVE, depressive))
            sortByDescending { it.second }
            forEach {
                builder.append(it.first).append(": ").append(it.second.toDouble()/20*100).append(" процентов").append(("\n"))
            }
        }
        return builder.toString()
    }

    fun calculateGeneralPsycologicalDeviationLevel(): Int {
        //TODO calculate psychopats
        var coeff = 0
        return user.run {
            if (selfRejection!! > 75 || selfDestructionLevel!!> 75 || abnormalConditionsDetected!! > 75) {
                coeff = 4
            }
            else if (selfRejection!! in 50..74 || selfDestructionLevel!! in 50..74 || abnormalConditionsDetected!! in 50..74)  {
                coeff = 3
            } else if (selfRejection!! in 25..49 || selfDestructionLevel!! in 25..49 || abnormalConditionsDetected!! in 25..49) {
                coeff = 2

            } else if (selfRejection!! in 10..25 || selfDestructionLevel!! in 10..25 || abnormalConditionsDetected!! in 10..25) {
                coeff = 1
            }
            coeff
        }
    }

    // how to call it, disbalance? Do we need to count the addictions and the phobias and the panic attacks at the same parameter?
    fun calculateEmotionallDisbalanceLevel(): Int { //max currently is 4
        var coeff = 0
        // var returnValue = 0
        return user.run {
            chemicalAddictionLevel?.let {
                when {
                    it > 75 -> {
                        return 4
                    }
                    it in 50..74 -> { coeff += 5 }
                    it in 25..49 -> { coeff += 1 }
                }
            }
            chemicalAddiction1_Level?.let {
                when {
                    it > 75 -> {
                        // returnValue = 4
                        return 4
                    }
                    it in 50..74 -> { coeff += 5 }
                    it in 25..49 -> { coeff += 1 }
                }
            }
            otherAddictionLevel?.let {
                when {
                    it > 75 -> {
                        //  returnValue = 4
                        return 4
                    }
                    it in 50..74 -> { coeff += 5 }
                    it in 25..49 -> { coeff += 1 }
                }
            }
            fearsLevel?.let {
                when {
                    it > 75 -> {
                        // returnValue = 4
                        return 4
                    }
                    it in 50..74 -> { coeff += 5 }
                    it in 25..49 -> { coeff += 1 }
                }
            }
            panicAttacksLevel?.let {
                when {
                    it > 75 -> {
                        // returnValue = 4
                        return 4
                    }
                    it in 50..75 -> { coeff += 5 }
                    it in 25..49 -> { coeff += 1 }
                }
            }
            obsessionLevel?.let {
                when {
                    it > 75 -> {
                        return 4//returnValue
                    }
                    it in 50..74 -> { coeff += 5 }
                    it in 25..49 -> { coeff += 1 }
                }
            }
            uncontrolledEmotion1?.let {
                when {
                    it > 75 -> { coeff += 2 }
                    it in 50..74 -> { coeff += 4 }
                }
            }
            uncontrolledEmotion2?.let {
                when {
                    it > 75 -> { coeff += 2 }
                    it in 50..74 -> { coeff += 4 }
                }
            }
            uncontrolledEmotion3?.let {
                when {
                    it > 75 -> { coeff += 2 }
                    it in 50..74 -> { coeff += 4 }
                }
            }
            iCanNotRelaxLevel?.let {
                if (it > 75) {
                    coeff += 10
                }
                if (it > 50) {
                    coeff += 1
                }
            }
            balanceSatisfactionLevel?.let {
                if (it < 25) {
                    coeff += 10
                }
            }

            if (allCurrentNegativeEmotions.contains(Emotions.DESPAIR.code)
                || allCurrentNegativeEmotions.contains(Emotions.HORROR.code)) {

            }

            when {
                //super hight
                coeff > 20 -> { 4 }
                //very hight
                coeff in 15..20 -> { 3 }
                //average
                coeff in 10..14 -> { 2 }
                //low
                else -> { 1 }
            }
        }
    }

    fun calculateLifeDissatisfactionLevel(): Int { //max currently is 4
        var coeff = 0
        return user.run {
            var returnValue = 0
            if (generalSatisfactionLevel!! < 55) {
                coeff += 2
            }
            if ((healthImportanceLevel!! - healthSatisfactionLevel!!) > 40) {
                coeff += 1
            }
            if ((appearanceImportanceLevel!! - appearanceSatisfactionLevel!!) > 40) {
                coeff += 1
            }
            if ((financesImportanceLevel!! - financesSatisfactionLevel!!) > 40) {
                coeff += 1
            }
            if ((socialSuccessImportanceLevel!! - socialSuccessSatisfactionLevel!!) > 40) {
                coeff += 1
            }
            if ((actualizationImportanceLevel!! - actualizationSatisfactionLevel!!) > 40) {
                coeff += 1
            }
            if ((actualizationImportanceLevel!! - actualizationSatisfactionLevel!!) > 40) {
                coeff += 1
            }
            if ((emotionsImportanceLevel!! - emotionsSatisfactionLevel!!) > 40) {
                coeff += 1
            }
            if ((balanceImportanceLevel!! - balanceSatisfactionLevel!!) > 40) {
                coeff += 1
            }
            if ((significantPeopleImportanceLevel!! - significantPeopleSatisfactionLevel!!) > 40) {
                coeff += 1
            }
            if ((socialLifeImportanceLevel!! - socialLifeSatisfactionLevel!!) > 40) {
                coeff += 1
            }
            if (fulfillingGoalsLevel!! < 40) {
                coeff += 1
            }
            if (selfDestructionLevel!! in 25..50) {
                coeff += 2

            } else if (selfDestructionLevel!! in 50..75) {
                coeff += 6
            }
            if (selfRejection!! in 25..50) {
                coeff += 2

            } else if (selfRejection!! in 50..75) {
                coeff += 6
            }
            //TODO if there is a big difference between satisfaction and self rejection the user may be in troubles
            returnValue = when {
                //TODO maybe add the winner interpretation
                coeff > 10 -> { 4 }
                coeff in 7..9 -> { 3 }
                coeff in 3..6 -> { 2 }
                else -> { 1 }
            }
            returnValue
        }
    }

    fun calculateGeneralStressLevel (): Int {
        return user.run {
            0
        }
    } //max 5

    fun calculateParentalAbuseLevel (): Int {
        return user.run {
            try {
                var coeff = 0
                if (parentalFamilySexualAbuseLevel!! >= 1) {
                    coeff += 100
                }
                if (parentalFamilyPhysicalPunishmentLevel!! > 75) {
                    coeff += 100
                } else if (parentalFamilyPhysicalPunishmentLevel!! > 50) {
                    coeff += 30
                }
                if (parentalFamilyNeglectanceLevel!! > 75) {
                    coeff += 100
                } else if (parentalFamilyNeglectanceLevel!! > 50) {
                    coeff += 60
                }
                if (parentalFamilyChronicalDeceptionLevel!! > 75) {
                    coeff += 100
                } else if (parentalFamilyChronicalDeceptionLevel!! > 50) {
                    coeff += 60
                }
                val average = (parentalFamilyEmotionsDevaluationLevel!! + parentalFamilyIntellectualDevaluationLevel!! + parentalFamilyValuesDevaluationLevel!!
                        + parentalFamilyAppearanceDevaluationLevel!! + parentalFamilySuccessDevaluationLevel!! + parentalFamilyGuiltPunishmentLevel!!
                        + parentalFamilyNeedsDevaluationLevel!! + parentalFamilySocialIsolationLevel!! + parentalFamilyPrivacyOffenceLevel!!
                        + parentalFamilyFinancialAbuseLevel!! + parentalFamilyComparisonLevel!!
                        + parentalFamilyDemonstrativeIgnoranceLevel!! + parentalFamilyEmotionalAggressionLevel!!)/13

                coeff += average
                when {
                    //critically high level of abuse, recommend to go to therapist
                    coeff > 100 -> { 4 }
                    // very high level of abuse, recommend to go to therapist
                    coeff in 51..99 -> { 3 }
                    // pretty high level of abuse
                    coeff in 30..50 -> { 2 }
                    // general of abuse, may not affect the personality
                    else -> { 1 }
                }
            } catch (e: Exception) {
                0
            }
        }
    }

    fun calculateCurrentFamilyAbuseLevel(): Int {
        return user.run {
            try {
                var coeff = 0
                if (currentFamilySexualAbuseLevel!! >= 1) {
                    coeff += 100
                }
                if (currentFamilyPhysicalViolenceLevel!! > 75) {
                    coeff += 100
                } else if (currentFamilyPhysicalViolenceLevel!! > 50) {
                    coeff += 40
                }
                if (currentFamilyNeglectanceLevel!! > 75) {
                    coeff += 100
                } else if (currentFamilyNeglectanceLevel!! > 25) {
                    coeff += 60
                }

                if (currentFamilyChronicalDeceptionLevel!! > 75) {
                    coeff += 100
                } else if (currentFamilyChronicalDeceptionLevel!! > 50) {
                    coeff += 60
                }

                val average = (currentFamilyEmotionsDevaluationLevel!! + currentFamilyIntellectualDevaluationLevel!! + currentFamilyValuesDevaluationLevel!!
                        + currentFamilyAppearanceDevaluationLevel!! + currentFamilySuccessDevaluationLevel!! + currentFamilyGuiltPunishmentLevel!!
                        + currentFamilyNeedsDevaluationLevel!! + currentFamilySocialIsolationLevel!! + currentFamilyPrivacyOffenceLevel!!
                        + currentFamilyFinancialAbuseLevel!! + currentFamilyComparisonLevel!!
                        + currentFamilyDemonstrativeIgnoranceLevel!! + currentFamilyEmotionalAggressionLevel!!)/13

                coeff += average
                when {
                    coeff > 100 -> { 4 }
                    coeff in 51..99 -> { 3 }
                    coeff in 25..50 -> { 2 }
                    else -> { 1 }
                }
            } catch (e: NullPointerException) {
                0
            }
        }
    }

//    <array name="most_typical_attitude">
//    <item>Я наслаждаюсь им и жду, что он ответит взаимностью</item> - 0
//    <item>Я за все в ответе и должен поступать правильно</item> - 1
//    <item>Я должен покорить его и добиться признания своих успехов</item> - 2
//    <item>Я постоянно вынужден сопротивляться давлению</item> - 3
//    <item>Мне здесь не очень комфортно, потому что люди кажутся мне непонятными</item> - 4
//    <item>Он слишком часто делает мне больно</item> - 5
//    <item>В нем мало порядка и справедливости</item> - 6
//    <item>Я не претендую на ведущую роль на сцене жизни, для меня главное - комфорт и безопасность </item> - 7
//    </array>

    fun calculateIfNeurotic(): Int { //20
        return user.run {
            var coeff = 0
            //locus of control
            if ((myCommitmentInFailsLevel!! > otherSideCommitmentInFailsLevel!!) && (myCommitmentInFailsLevel!! > 55)) {
                coeff+=2
            }
            // relationships with significant people are the most important
            if (significantPeopleImportanceLevel!! > 75) {
                coeff+=4
            }

            if (iCanNotSayNoLevel!! > 75 && iCanNotSayNoReason!! == 0) {
                coeff += 5
            } else if (iCanNotSayNoLevel!! > 50 && iCanNotSayNoReason!! == 0) {
                coeff += 2
            }

            if (iProcrastinateLevel!! > 50 && iProcrastinateReason!! == 0) {
                coeff+= 1
            }

            if (commonNegativeEmotion1 == Emotions.GUILT.code
                || commonNegativeChildhoodEmotion2 == Emotions.GUILT.code
                || commonNegativeEmotion3 == Emotions.GUILT.code ) {
                coeff += 2
            }

            if (commonNegativeChildhoodEmotion2 == Emotions.GUILT.code
                || commonNegativeChildhoodEmotion1 == Emotions.GUILT.code
                || commonNegativeChildhoodEmotion3 == Emotions.GUILT.code) {
                coeff += 2
            }

            if (mostCommonAttitude == 1) {
                coeff += 5
            }
            coeff
        }
    }

    fun calculateIfNarcissist(): Int { //20
        return user.run {

            var coeff = 0
            //locus of control
            if (myCommitmentInFailsLevel!! < otherSideCommitmentInFailsLevel!! &&
                (myCommitmentInSuccessLevel!! > otherSideCommitmentInSuccessLevel!!)) {
                coeff +=3
            }

            if (mostCommonAttitude == 2) {
                coeff +=4
            }

            if (iCanNotRelaxLevel!! > 75 && iCanNotRelaxReason!! == 0) {
                coeff +=3
            } else if (iCanNotRelaxLevel!! > 50 && iCanNotRelaxReason!! == 0) {
                coeff +=1
            }

            if (socialSuccessImportanceLevel!! > 75 || appearanceImportanceLevel!! > 75 || beingExceptionalImportanceLevel!! > 75) {
                coeff += 4
            } else if (socialSuccessImportanceLevel!! > 60 || appearanceImportanceLevel!! > 60 || beingExceptionalImportanceLevel!! > 60) {
                coeff += 2
            }

            if (iAmConflictProneLevel!! > 75 && iAmConflictProneLevel!! == 1) {
                coeff += 2
            } else if (iAmConflictProneLevel!! > 50 && iAmConflictProneLevel!! == 1) {
                coeff += 1
            }
            //// shame is the less common emotion check, should be shame
            if (uncommonNegativeEmotion3 == Emotions.SHAME.code || uncommonNegativeEmotion2 == Emotions.SHAME.code
                || uncommonNegativeEmotion1 == Emotions.SHAME.code) {
                coeff += 2
            }

            if (allCurrentNegativeEmotions.contains(Emotions.CONTEMPT.code) || allCurrentNegativeEmotions.contains(Emotions.DISAPPOINTMENT.code)) {
                coeff += 1
            }

            if (!mostWantedEmotions.contains(Emotions.GRATEFULNESS.code) || !mostWantedEmotions.contains(Emotions.EMPATHY.code)) {
                coeff += 1
            }

            coeff
        }
    }

    fun calculateIfParanoid(): Int {//20
        return user.run {
            try {
                var coeff = 0
                when {
                    obsessionLevel!! > 75 -> {
                        coeff += 3
                    }
                    obsessionLevel!! in 50..74 -> {
                        coeff += 2
                    }
                    obsessionLevel!! in 25..49 -> {
                        coeff += 1
                    }
                }
                if (mostCommonAttitude == 6) {
                    coeff += 4
                }

                if (peopleAlwaysConfrontMe!! > 75) {
                    coeff += 5
                } else if (peopleAlwaysConfrontMe!! > 50) {
                    coeff += 2
                }

                if (iAmAfraidOfLostLevel!! > 75 && iAmAfraidOfLostReason!! == 0) {
                    coeff+=4
                } else if (iAmAfraidOfLostLevel!! > 50 && iAmAfraidOfLostReason!! == 0) {
                    coeff += 2
                }

                if (iAmConflictProneLevel!! > 75 && iAmConflictProneReason!! == 0) {
                    coeff+=4
                } else if (iAmConflictProneLevel!! > 50 && iAmConflictProneReason!! == 0) {
                    coeff += 1
                }
                coeff
            } catch (e: NullPointerException) {
                0
            }
        }
    }

    fun calculateIfPsychotic(): Int { //20
        return user.run {
            try {
                var coeff = 0
                if (emotionalDisbalanceLevel >= 3) {
                    coeff +=1
                }

                if (psychologicGender == 2 || meDefinitionDifficultiesLevel!! > 75) {
                    coeff +=1
                }

                if (mostCommonAttitude == 5) {
                    coeff += 5
                }

                if (iCanNotApproachPeopleLevel!! > 75 && iCanNotApproachPeopleReason!! == 0) {
                    coeff +=2
                } else if (iCanNotApproachPeopleLevel!! > 50 && iCanNotApproachPeopleReason!! == 0) {
                    coeff +=1
                }

                if (iAmAfraidOfFutureLevel!! > 75 && iAmAfraidOfFutureReason!! == 2) {
                    coeff +=2
                } else if (iAmAfraidOfFutureLevel!! > 50 && iAmAfraidOfFutureReason!! == 2) {
                    coeff +=1
                }

                if (iAmAfraidOfCompetitionLevel!! > 75 && iAmAfraidOfCompetitionReason!! == 0) {
                    coeff +=2
                } else if (iAmAfraidOfCompetitionLevel!! > 50 && iAmAfraidOfCompetitionReason!! == 0) {
                    coeff +=1
                }

                if (selfRejection!! > 75 && (usersNeedOfTherapy!! > 50 || needOfExternalChanges!! > 50 )) {
                    coeff +=4
                } else if (selfRejection!! > 50) {
                    coeff +=1
                }

                if ((allChildhoodEmotions.contains(Emotions.GUILT.code) || allChildhoodEmotions.contains(Emotions.SHAME.code))
                    && (allChildhoodEmotions.contains(Emotions.DESPAIR.code) || allChildhoodEmotions.contains(Emotions.FEAR.code))) {
                    coeff += 2
                }

                if (allCurrentNegativeEmotions.contains(Emotions.SHAME.code)) {
                    coeff += 1
                }

                coeff
            } catch (e: NullPointerException) {
                0
            }
        }
    }

    fun calculateIfMazohist(): Int { //20
        return user.run {
            try {
                var coeff = 0
                if (hypochondriaLevel!! >= 2) { // add hypochondria
                    coeff += 1
                }

                if (mostCommonAttitude == 7) {
                    coeff += 4
                }

                // anger is among the most banned emotions
                if (iCanNotSayNoLevel!! > 75 && iCanNotSayNoReason!! == 1) {
                    coeff += 3
                } else if (iCanNotSayNoLevel!! > 50 && iCanNotSayNoReason!! == 1) {
                    coeff += 1
                }

                if (iProcrastinateLevel!! > 75 && iProcrastinateReason!! == 4) { //maybe iProcrastinateReason = 1
                    coeff += 3
                } else if (iProcrastinateLevel!! > 50 && iProcrastinateReason!! == 4) {
                    coeff += 1
                }

                if (iAmAfraidOfFutureLevel!! > 75 && iAmAfraidOfFutureReason!! == 0) {
                    coeff+=2
                } else if (iAmAfraidOfFutureLevel!! > 50 && iAmAfraidOfFutureReason!! == 0) {
                    coeff += 1
                }
                // goals achievement
                if (fulfillingGoalsLevel!! < 40) {
                    coeff += 2
                }

                if (learningFromMistakes!! < 30 || obstaclesEvaluationLevel!! < 30) {
                    coeff += 2
                }

                if (lifeDissatisfactionLevel >= 3) {
                    coeff++
                }

                if (currentFamilyAbuseLevel >= 3) {
                    coeff += 3
                }
                coeff
            } catch (e: NullPointerException) {
                0
            }
        }
    }

    fun calculateIfResourceless(): Int {//20

        return user.run {
            var coeff = 0

            if (mostCommonAttitude == 0) {
                coeff += 3
            }

            if (selfRejection!! < 30) {
                coeff += 2
            } else if (selfRejection!! < 20) {
                coeff += 3
            }

            if (peopleAlwaysConfrontMe!! < 30) {
                coeff += 2
            } else if (peopleAlwaysConfrontMe!! < 20) {
                coeff += 3
            }

            //add points for low depression, low peopleAlwaysConfrontMe, low selfRejection
            if (myCommitmentInFailsLevel!! < otherSideCommitmentInFailsLevel!!
                && myCommitmentInSuccessLevel!! < otherSideCommitmentInSuccessLevel!!) {
                coeff += 1
            }

            if (iAmConflictProneLevel!! > 75 && iAmConflictProneReason!! == 2) {
                coeff += 2
            } else if(iAmConflictProneLevel!! > 50 && iAmConflictProneReason!! == 2) {
                coeff += 1
            }

            if (iProcrastinateLevel!! > 75 && iProcrastinateReason!! == 1) { //maybe iProcrastinateReason = 1
                coeff += 2
            } else if(iProcrastinateLevel!! > 50 && iProcrastinateReason!! == 1) {
                coeff += 1
            }

            if(iAmAfraidOfCompetitionLevel!! > 50 && iAmAfraidOfCompetitionReason!! == 1) {
                coeff += 1
            }

            if(relationshipAvoidanceLevel!! > 50 && relationshipAvoidanceReason!! == 0) {
                coeff += 1
            }

            // maybe a main characteristics is not reaching the goals
            if (fulfillingGoalsLevel!! < 40) {
                coeff += 2
            }
            if (learningFromMistakes!! < 30 || obstaclesEvaluationLevel!! < 30) {
                coeff += 2
            }
            coeff
        }
    }

    fun calculateIfSchizoid(): Int { //20
        return user.run {
            // temperament check - 2
            var coeff = 0
            if (meDefinitionDifficultiesLevel!! > 50) {
                coeff += 1
            }

            if (mostCommonAttitude == 4) {
                coeff += 4
            }

            if (iCanNotApproachPeopleLevel!! > 75 && iCanNotApproachPeopleReason!! == 1) {
                coeff +=3
            } else if (iCanNotApproachPeopleLevel!! > 50 && iCanNotApproachPeopleReason!! == 1) {
                coeff++
            }

            if (iAmNotOpenLevel!! > 75 && iAmNotOpenReason!! == 0) {
                coeff +=3
            } else if (iAmNotOpenLevel!! > 50 && iAmNotOpenReason!! == 0) {
                coeff++
            }

            if (emotionsIndicating!! < 25 || emotionsImportanceLevel!! < 25) {
                coeff +=2
            }

            if (otherPeopleEmotionsIndicating!! < 25) {
                coeff +=2
            }

            if (socialSuccessImportanceLevel!! < 25 || socialLifeImportanceLevel!! < 25) {
                coeff +=2
            } else if (socialSuccessImportanceLevel!! < 40 || socialLifeImportanceLevel!! < 40) {
                coeff +=1
            }

            if (relationshipAvoidanceLevel!! > 50 && relationshipAvoidanceReason!! == 1) {
                coeff++
            } else if (relationshipAvoidanceLevel!! > 75 && relationshipAvoidanceReason!! == 1) {
                coeff +=3
            }
            coeff
        }
    }

    fun calculateIfPassiveAggressive(): Int { //20
        return user.run {

            var coeff = 0
            if (mostCommonAttitude == 3) {
                coeff += 4
            }

            if (iAmAfraidOfFutureLevel!! > 75 && iAmAfraidOfFutureReason!! == 0) {
                coeff+=2
            } else if (iAmAfraidOfFutureLevel!! > 50 && iAmAfraidOfFutureReason!! == 0) {
                coeff += 1
            }

            if (fulfillingGoalsLevel!! < 40) {
                coeff += 2
            }

            if (lifeDissatisfactionLevel >= 3) {
                coeff+=2
            }
            //conflicts avoidance
            if (iCanNotSayNoLevel!! > 75 && iCanNotSayNoReason!! == 1) {
                coeff += 3
            } else if (iCanNotSayNoLevel!! > 50 && iCanNotSayNoReason!! == 1) {
                coeff += 1
            }
            //procrastination = 3
            if (iProcrastinateLevel!! > 75 && iProcrastinateReason!! == 3) { //maybe iProcrastinateReason = 1
                coeff += 4
            } else if(iProcrastinateLevel!! > 50 && iProcrastinateReason!! == 3) {
                coeff += 2
            }

            if ((allCurrentNegativeEmotions.contains(Emotions.IRRITATION.code) || allCurrentNegativeEmotions.contains(Emotions.ANGER.code))
                && (allCurrentNegativeEmotions.contains(Emotions.EMPTINESS.code) || allCurrentNegativeEmotions.contains(Emotions.MELANCHOLY.code))) {
                coeff += 3
            }

            coeff
        }
    }

    val personalImmaturityLevel: Int by lazy {
        //maximum 4
        user.run {
            var coeff = 0
            //compare user level of a therapy need and our evaluation
            if ((user.needOfExternalChanges!! - user.usersNeedOfTherapy!!) > 30) {
                coeff++
            }
            if (myCommitmentInFailsLevel!! < otherSideCommitmentInFailsLevel!! &&
                (myCommitmentInSuccessLevel!! > otherSideCommitmentInSuccessLevel!!)) {
                coeff++
            }
            if (myRightToControlOtherPeopleLifeLevel!! > 25) {
                coeff +=2
            } else if (myRightToControlOtherPeopleLifeLevel!! > 50) {
                return@run 4
            }

            if (iHaveToControlOtherPeopleLifeLevel!! > 25) {
                coeff +=2
            } else if (iHaveToControlOtherPeopleLifeLevel!! > 50) {
                return@run 4
            }

            if (iAmConflictProneLevel!! > 50) {
                coeff++
            }

            if (mostCommonAttitude != 7) {
                coeff++
            }
            if (coeff > 4){
                return@run 4
            }
            coeff
        }
    }

    val selfEsteemProblemsLevel: Int by lazy { //max 16
        user.run {
            var coeff = 0
            if (personalTraitsSatisfactionLevel in 25..50) {
                coeff+=2

            } else if (personalTraitsSatisfactionLevel in 1..25){
                coeff +=4
            }
            if (appearanceSatisfactionLevel in 25..50) {
                coeff+=2

            } else if (appearanceSatisfactionLevel in 1..25){
                coeff +=4
            }
            if (myCommitmentInFailsLevel!! > otherSideCommitmentInFailsLevel!!+10) {
                coeff++

            } else if (myCommitmentInFailsLevel!! > otherSideCommitmentInFailsLevel!!+30) {
                coeff +=4
            }
            if (myCommitmentInSuccessLevel!! < otherSideCommitmentInSuccessLevel!!-10) {
                coeff++

            } else if (myCommitmentInSuccessLevel!! > otherSideCommitmentInSuccessLevel!!-30) {
                coeff +=4
            }
            coeff
        }
    }

    val depressive: Int by lazy { //max 20
        user.run {
            var coeff = 0
            if (generalSatisfactionLevel!! in 25..50 || lifeDissatisfactionLevel == 3) {
                coeff +=2
            } else if (generalSatisfactionLevel!! < 25 || lifeDissatisfactionLevel == 4) {
                coeff +=4
            }

            if (iAmAfraidOfFutureLevel!! > 75) {
                coeff +=4
            } else if (iAmAfraidOfFutureLevel!! > 50) {
                coeff +=2
            }

            if (problemsObservabilityLevel!! < 25) {
                coeff +=4
            } else if (problemsObservabilityLevel!! < 50) {
                coeff +=2
            }
            ////selfRejectionLevel
            if (lifeMeaningfulnessLevel!! in 25..50) {
                coeff +=2
            } else if (lifeMeaningfulnessLevel!! < 25) {
                coeff +=4
            }

            if (selfEsteemProblemsLevel in 6..8) {
                coeff +=2
            } else if (selfEsteemProblemsLevel in 9..11) {
                coeff +=3
            } else if (selfEsteemProblemsLevel in 12..16) {
                coeff +=4
            }

            coeff
        }
    }

    val allChildhoodEmotions = mutableListOf<Int>().apply {
        add(user.commonNegativeChildhoodEmotion2!!)
        add(user.commonNegativeChildhoodEmotion1!!)
        add(user.commonNegativeChildhoodEmotion3!!)
    }
    val allCurrentNegativeEmotions = mutableListOf<Int>().apply {
        add(user.commonNegativeEmotion1!!)
        add(user.commonNegativeEmotion2!!)
        add(user.commonNegativeEmotion3!!)
        add(user.uncontrolledEmotion1!!)
        add(user.uncontrolledEmotion2!!)
        add(user.uncontrolledEmotion3!!)
    }
    val mostWantedEmotions = mutableListOf<Int>().apply {
        add(user.wantedEmotion1!!)
        add(user.wantedEmotion2!!)
        add(user.wantedEmotion3!!)
    }

    val allPatterns = mutableListOf<Pair<String, Int>>().apply {
        add(Pair(StaticStrings.NARCISSIST, narcissist))
        add(Pair(StaticStrings.NEUROTIC, neurotic))
        add(Pair(StaticStrings.PARANOID, paranoid))
        add(Pair(StaticStrings.PSYCHOTIC, psychotic))
        add(Pair(StaticStrings.SCHIZOID, schizoid))
        add(Pair(StaticStrings.HYSTERICAL, resourceless))
        add(Pair(StaticStrings.MAZOCHIST, mazohist))
        add(Pair(StaticStrings.PASSIVE_AGGRESSIVE, passiveAggressive))
        add(Pair(StaticStrings.DEPRESSIVE, depressive))
        sortByDescending { it.second }
    }

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

object StaticStrings {

    const val BASIC_DECOMPOSIT_ME_TYPE = 0
    const val BASIC_DECOMPOSIT_THEY_TYPE = 1
    const val ALTER_NARCISS_DECOMPOSIT_ME_TYPE = 2
    const val ALTER_NARCISS_DECOMPOSIT_THEY_TYPE = 3
    const val ALTER_NEUROTIC_DECOMPOSIT = 4
    const val ALTER_PSYCHOTIC_DECOMPOSIT = 5
    const val ALTER_HYSTERIC_DECOMPOSIT = 6
    const val ALTER_HELPLESS_DECOMPOSIT = 7
    const val ALTER_OCD_DECOMPOSIT = 8
    const val BASIC_DECOMPOSIT_POTENTIAL_IMPROV = 9
    const val BASIC_DECOMPOSIT_CARD = 10
    const val NO_DECOMPOSIT_DISORDERS_DETECTED_HW = 11
    const val NO_DECOMPOSIT_BAD_TRIGGER_DETECTED_HW = 12
    const val DECOMPOSIT_SIGN_PERSON_INVOLVED_HW = 13
    const val DECOMPOSIT_OFFENCE_DETECTED_HW = 14
    const val NO_DECOMPOSIT_NO_TRIGGER_CARD = 15
    const val DECOMPOSIT_FEELS_LIKE_UNIQUE = 16
    const val DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION = 17
    const val DECOMPOSIT_ABUSE = 18
    const val NO_DECOMPOSIT_NO_TRIGGER_3_STORIES = 19
    const val DEFAULT = 20
    const val NO_DECOMPOSIT_WORK_WITH_EXPECTATIONS = 21

    val layoutTypes = arrayListOf("horizontal_swipe", "single_mark_item", "prioretize_profile_aspects")

    const val LAYOUT_HORIZONTAL_SWIPE = "horizontal_swipe"
    const val LAYOUT_SINGLE_MARK_ITEM = "single_mark_item"
    const val LAYOUT_PRIORETIZE_PROFILE_ASPECTS = "prioretize_profile_aspects"
    const val LAYOUT_DIARY = "diary"
    const val LAYOUT_HOME_PAGER = "layout_home_pager"
    const val TAKE_PHOTO_REQUEST_CODE = 101
    const val WRITE_EXTERNAL_REQUEST_CODE = 102
    const val SELECT_PHOTO_REQUEST_CODE = 103

    const val NARCISSIST = "Нарциссический"
    const val NEUROTIC = "Невротический"
    const val PARANOID = "Параноидальный"
    const val PSYCHOTIC = "Психотический"
    const val SCHIZOID = "Шизоидный"
    const val HYSTERICAL = "Истероидный"
    const val MAZOCHIST = "Мазохистический"
    const val DEPRESSIVE = "Депрессивный"
    const val PASSIVE_AGGRESSIVE = "Пассивно-агрессивный"

    const val TEMPERAMENT = "TEMPERAMENT"
    const val EXPERIENCE = "EXPERIENCE"
    const val GOALS = "GOALS"
    const val MYTHOLOGY = "PURPOSE"
    const val LOCUS = "LOCUS"
    const val CORE = "CORE"
    const val ABILITIES = "ABILITIES"
    const val EMOTIONS = "EMOTIONS"
    const val HABITS = "HABITS"
    const val BEHAVIOUR = "RESISTANCE"

    const val DATE_FORMAT = "dd/MM/yy"
}

