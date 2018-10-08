package alex.com.br.espresso.features.search

import alex.com.br.espresso.R
import alex.com.br.espresso.features.detail.StarshipsDetailActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_search_starships.*

class SearchStarshipsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_starships)

        buttonSearch.setOnClickListener {
            if (editTextShip.text.toString().isEmpty())
                textInputLayoutShip.error = getString(R.string.campo_obrigatorio)
            else
                goToDetail()
        }
    }

    private fun goToDetail() {
        startActivity(StarshipsDetailActivity.newIntent(this))
    }
}
