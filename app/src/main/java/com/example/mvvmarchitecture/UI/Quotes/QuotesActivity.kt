package com.example.mvvmarchitecture.UI.Quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmarchitecture.Data.Quote
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.Utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initilaizeUi()
    }

    private fun initilaizeUi(){
        val factory=InjectorUtils.provideQuotesViewModel()
        val viewModel=ViewModelProviders.of(this,factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this,Observer{quotes->
            val stringBuilder=StringBuilder()
            quotes.forEach{quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text=stringBuilder.toString()
        })

        button_add_quote.setOnClickListener{
            val quote=Quote(editText_quote.text.toString(),editText_author.text.toString())
            viewModel.addQuotes(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}