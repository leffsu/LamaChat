package su.leff.core.data

import su.leff.core.domain.Dialog

interface DialogDataSource {

    suspend fun add(dialog: Dialog)

    suspend fun readAll(): List<Dialog>

    suspend fun remove(dialog: Dialog)

}