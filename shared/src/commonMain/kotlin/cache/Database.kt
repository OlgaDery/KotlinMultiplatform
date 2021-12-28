package cache

import com.example.testapp.Session
import com.example.testapp.shared.cache.AppDatabase

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    private fun mapEntryToSession(_id: String, _addedBy: String, _problemID: String, _severity: Int, _whenAdded: Int,
                                  _irrationalConvictionCode: Int, _emotionCode: Int, _criticalConditionConfirmed: Boolean,
                                  _dangerousTriggerConfirmed: Boolean, _abuseConfirmed: Boolean,
                                  _ownAggressionConfirmed: Boolean, _significantPersonInvolved: Boolean,
                                  _acceptResponsibility: Boolean, _hiddenReasonCode: Int, _sessionPatternCode: Int,
                                  _homeworkName: String?, _messageToFuture: String?): Session {
        return Session(id = _id, addedBy = _addedBy, problemID = _problemID, severity = _severity,
            irrationalConvictionCode = _irrationalConvictionCode, emotionCode = _emotionCode,
            criticalConditionConfirmed = _criticalConditionConfirmed, dangerousTriggerConfirmed = _dangerousTriggerConfirmed,
            abuseConfirmed = _abuseConfirmed, ownAggressionConfirmed = _ownAggressionConfirmed,
            significantPersonInvolved = _significantPersonInvolved, acceptResponsibility = _acceptResponsibility,
            hiddenReasonCode = _hiddenReasonCode, sessionPatternCode = _sessionPatternCode, homeworkName = _homeworkName,
            messageToFuture = _messageToFuture, whenAdded = _whenAdded)
    }

    private fun insertSession(session: Session) {
        dbQuery.insertSession(id = session.id, abuseConfirmed = session.abuseConfirmed,
            acceptResponsibility = session.acceptResponsibility, addedBy = session.addedBy,
            criticalConditionConfirmed = session.criticalConditionConfirmed,
            dangerousTriggerConfirmed = session.dangerousTriggerConfirmed, emotionCode = session.emotionCode,
            hiddenReasonCode = session.hiddenReasonCode, irrationalConvictionCode = session.irrationalConvictionCode,
            ownAggressionConfirmed = session.ownAggressionConfirmed, problemId = session.problemID,
            sessionPatternCode = session.sessionPatternCode, severity = session.severity,
            significantPersonInvolved = session.significantPersonInvolved, whenAdded = session.whenAdded,
            messageToFuture = session.messageToFuture, homeworkName = session.homeworkName)
    }

    //functions to be exposed to the repository class

    internal fun getAllSessions(): List<Session> {
        return dbQuery.selectAllSessions(::mapEntryToSession).executeAsList()
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