package com.mrklie.yangtao.hanzidetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mrklie.yangtao.R
import com.mrklie.yangtao.persistence.Hanzi
import kotlinx.android.synthetic.main.activity_hanzi_detail.*

class HanziDetailActivity : AppCompatActivity() {

    private lateinit var hanzi: Hanzi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hanzi_detail)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        hanzi = intent.getParcelableExtra(KEY_HANZI)!!

        hanzi_detail_character.text = hanzi.character
        hanzi_detail_pinyin.text = hanzi.pinyin
        hanzi_detail_etymology.text = hanzi.etymology

        if (!hanzi.scanned) {
            hanzi_detail_scanned.visibility = View.INVISIBLE
        }
    }

    companion object {
        private val TAG = HanziDetailActivity::class.qualifiedName
        private const val KEY_HANZI = "KEY_HANZI"

        fun newIntent(context: Context, hanzi: Hanzi): Intent {
            val intent = Intent(context, HanziDetailActivity::class.java)
            intent.putExtra(KEY_HANZI, hanzi)
            return intent
        }
    }
}
