package alex.com.br.espresso.features.detail

import alex.com.br.espresso.R
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_starships_detail.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

const val STARSHIP = "STARSHIP"

class StarshipsDetailActivity : AppCompatActivity(), StarshipsDetailContract.View {

    override val presenter: StarshipsDetailContract.Presenter by inject{ parametersOf(this) }
    private val starship by lazy { intent.getIntExtra(STARSHIP, 9) }

    companion object {
        fun newIntent(ctx: Context, starship: Int = 9) = Intent(ctx, StarshipsDetailActivity::class.java)
                .putExtra(STARSHIP, starship)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starships_detail)
        presenter.getStarshipDetail(starship)
    }

    override fun updateView(nome: String,
                            modelo: String,
                            fabricante: String) {

        textViewValueNome.text = nome
        textViewValueModelo.text = modelo
        textViewValueFabricante.text = fabricante
    }

}
