package cache

import com.example.testapp.shared.cache.AppDatabase

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    private fun mapEntryToSession(_id: String, _addedBy: String, _problemID: String, _severity: Int, _whenAdded: Int,
                                  _irrationalConvictionCode: Int, _emotionCode: Int, _criticalConditionConfirmed: Boolean?,
                                  _dangerousTriggerConfirmed: Boolean?, _abuseConfirmed: Boolean?,
                                  _ownAggressionConfirmed: Boolean, _significantPersonInvolved: Boolean?,
                                  _acceptResponsibility: Boolean?, _hiddenReasonCode: Int?, _sessionPatternCode: Int?,
                                  _homeworkName: String?, _messageToFuture: String?): Session {
        return Session(id = _id, added_by = _addedBy, problem_id = _problemID, severity = _severity,
            irrational_conviction_code = _irrationalConvictionCode, emotion_code = _emotionCode,
            critical_condition_confirmed = _criticalConditionConfirmed, dangerous_trigger_confirmed = _dangerousTriggerConfirmed
            , abuse_confirmed = _abuseConfirmed, own_aggression_confirmed = _ownAggressionConfirmed,
            significant_person_involved = _significantPersonInvolved, accept_responsibility = _acceptResponsibility,
            hidden_reason_code = _hiddenReasonCode, session_pattern_code = _sessionPatternCode, homework_name = _homeworkName,
            message_to_future = _messageToFuture, when_added = _whenAdded)
    }

    private fun insertSession(session: Session) {
        dbQuery.insertSession(id = session.id, abuse_confirmed = session.abuse_confirmed,
            accept_responsibility = session.accept_responsibility, added_by = session.added_by,
            critical_condition_confirmed = session.critical_condition_confirmed,
            dangerous_trigger_confirmed = session.dangerous_trigger_confirmed, emotion_code = session.emotion_code,
            hidden_reason_code = session.hidden_reason_code, irrational_conviction_code = session.irrational_conviction_code,
            own_aggression_confirmed = session.own_aggression_confirmed, problem_id = session.problem_id,
            session_pattern_code = session.session_pattern_code, severity = session.severity,
            significant_person_involved = session.significant_person_involved, when_added = session.when_added,
            message_to_future = session.message_to_future, homework_name = session.homework_name)
    }

    //functions to be exposed to the repository class

    internal fun getAllSessions(): List<Session> {
        return dbQuery.selectAllSessions().executeAsList()
    }

    internal fun createSession(session: Session) {
        insertSession(session)
    }

    internal fun updateSessionCode(code: Int, id: String) {
        dbQuery.updateSessionCode(code, id)
    }

    internal fun updateMessage(message: String, id: String) {
        dbQuery.updateMessageToFuture(message, id)
    }
}