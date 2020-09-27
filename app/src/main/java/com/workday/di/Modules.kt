package com.workday.di

import com.workday.data.GifsRepo
import com.workday.data.WorkdayClient
import org.koin.dsl.module

val coreModule = module {
    single { WorkdayClient() }
    single { GifsRepo(get()) }
}