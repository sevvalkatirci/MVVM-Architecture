package com.example.mvvmarchitecture.Utilities

import com.example.mvvmarchitecture.Data.FakeDataBase
import com.example.mvvmarchitecture.Data.QuoteRepository
import com.example.mvvmarchitecture.UI.Quotes.QuotesViewModel
import com.example.mvvmarchitecture.UI.Quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModel():QuotesViewModelFactory{
        val quoteRepository=QuoteRepository.getInstance(FakeDataBase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}