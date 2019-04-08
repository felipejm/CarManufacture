package br.com.joffer.carmanufacture.features.builtdates

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout.VERTICAL
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.joffer.carmanufacture.R
import br.com.joffer.carmanufacture.infra.viewModelFactory
import kotlinx.android.synthetic.main.activity_manufaturer.*

class BuiltDatesActivity : AppCompatActivity() {

    companion object {
        private const val MANUFATURER = "MANUFATURER"
        private const val MAIN_TYPE = "MAIN_TYPE"

        fun starter(manufaturer: String, mainType: String, context: Context){
            val intent = Intent(context, BuiltDatesActivity::class.java)
            intent.putExtra(MANUFATURER, manufaturer)
            intent.putExtra(MAIN_TYPE, mainType)
            context.startActivity(intent)
        }
    }

    private var viewModel: BuiltDatesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manufaturer)

        val manufaturers = intent.getStringExtra(MANUFATURER)
        val mainType = intent.getStringExtra(MAIN_TYPE)
        viewModel = ViewModelProviders.of(this, viewModelFactory { BuiltDatesViewModel(manufaturers, mainType) })
            .get(BuiltDatesViewModel::class.java)
        loadData()
    }

    private fun loadData() {
        showLoading()
        viewModel?.carModels?.observe(this, Observer {
            hideLoading()
            configureRecyclerView(it)
        })
    }

    private fun configureRecyclerView(carModels: List<Pair<String, String>>){
        val adapter = BuiltDatesAdapter(carModels)
        adapter.onClickListener = {
        }

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(DividerItemDecoration(this, VERTICAL))
        recycler_view.adapter = adapter
    }

    private fun showLoading(){
        progress_bar.visibility = View.VISIBLE
        recycler_view.visibility = View.GONE
    }

    private fun hideLoading(){
        progress_bar.visibility = View.GONE
        recycler_view.visibility = View.VISIBLE
    }
}
