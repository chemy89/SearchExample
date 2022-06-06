package com.jeongsejong.search.ui.book

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jeongsejong.search.R
import com.jeongsejong.search.helper.PreferenceManager
import com.jeongsejong.search.network.ApiProvider
import com.jeongsejong.search.network.api.BookApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val disposables = CompositeDisposable()
    private val apiProvider: ApiProvider by inject()
    private val preferenceManager: PreferenceManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = apiProvider.createService(BookApi::class.java)
        disposables += api.requestBookList("", "", 1, 1)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { }
            .doOnComplete { }
            .subscribe({

            })
            {

            }

    }



}