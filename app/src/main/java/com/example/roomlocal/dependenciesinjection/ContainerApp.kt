package com.example.roomlocal.dependenciesinjection

import android.content.Context
import com.example.roomlocal.data.database.KrsDatabase
import com.example.roomlocal.data.repository.LocalRepositoryMhs
import com.example.roomlocal.data.repository.RepositoryMhs

interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context,).mahasiswaDao())
    }
}
