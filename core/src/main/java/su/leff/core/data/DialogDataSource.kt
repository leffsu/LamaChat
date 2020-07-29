package su.leff.core.data

interface DialogDataSource {

    suspend fun add(dialog: Dialog)

    suspend fun readAll(): List<Dialog>

    suspend fun remove(dialog: Dialog)

}