package br.com.joffer.carmanufacture.features.carmodel

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
import br.com.joffer.carmanufacture.features.builtdates.BuiltDatesActivity
import br.com.joffer.carmanufacture.infra.viewModelFactory
import kotlinx.android.synthetic.main.activity_manufaturer.*

class CarModelActivity : AppCompatActivity() {

    private var manufaturers: String? = null

        companion object {
        private const val MANUFATURER = "MANUFATURER"

        fun starter(manufaturer: String, context: Context){
            val intent = Intent(context, CarModelActivity::class.java)
            intent.putExtra(MANUFATURER, manufaturer)
            context.startActivity(intent)
        }
    }

    private var viewModel: CarModelViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manufaturer)

        manufaturers = intent.getStringExtra(MANUFATURER)
        viewModel = ViewModelProviders.of(this, viewModelFactory { CarModelViewModel(manufaturers) })
            .get(CarModelViewModel::class.java)
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
        val adapter = CarModelAdapter(carModels)
        adapter.onClickListener = {
            BuiltDatesActivity.starter(manufaturers ?: "", it, this)
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
