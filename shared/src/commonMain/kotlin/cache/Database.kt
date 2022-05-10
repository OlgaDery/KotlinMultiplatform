package cache

import com.example.testapp.Session
import com.example.testapp.shared.cache.AppDatabase

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    private fun mapEntryToSession(_id: String, _addedBy: String, _whenAdded: Int, _severity: Int,
                                  _emotionCode: Int, _acceptResponsibility: Boolean, _sessionPatternCode: Int,
                                  _messageToFuture: String?): Session {

        return Session(id = _id, addedBy = _addedBy, whenAdded = _whenAdded, severity = _severity,
            emotionCode = _emotionCode, acceptResponsibility = _acceptResponsibility,
            sessionPatternCode = _sessionPatternCode, messageToFuture = _messageToFuture)
    }

    private fun insertSession(session: Session) {
        dbQuery.insertSession(id = session.id, acceptResponsibility = session.acceptResponsibility,
            addedBy = session.addedBy, emotionCode = session.emotionCode,
            sessionPatternCode = session.sessionPatternCode, severity = session.severity,
            whenAdded = session.whenAdded,
            messageToFuture = "")
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

    internal fun deleteAllRecords() {
        dbQuery.deleteRecords()
    }
}