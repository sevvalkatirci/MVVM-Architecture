package com.example.mvvmarchitecture.UI.Quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.Data.QuoteRepository
import com.example.mvvmarchitecture.Data.Quote

class QuotesViewModel(private val quoteRepository: QuoteRepository) :ViewModel() {
    fun getQuotes()=quoteRepository.getQuotes()
    fun addQuotes(quote: Quote)=quoteRepository.addQuote(quote)

}