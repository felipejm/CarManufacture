package br.com.joffer.carmanufacture.features.manufacturer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout.VERTICAL
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.joffer.carmanufacture.R
import br.com.joffer.carmanufacture.features.carmodel.CarModelActivity
import br.com.joffer.carmanufacture.features.carmodel.CarModelAdapter
import kotlinx.android.synthetic.main.activity_manufaturer.*

class ManufaturerActivity : AppCompatActivity() {

    private var viewModel: ManufaturerViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manufaturer)

        viewModel = ViewModelProviders.of(this).get(ManufaturerViewModel::class.java)
        loadData()
    }

    private fun loadData() {
        showLoading()
        viewModel?.manufaturers?.observe(this, Observer {
            hideLoading()
            configureRecyclerView(it)
        })
    }

    private fun configureRecyclerView(manufaturers: List<Pair<String, String>>){
        val adapter = ManufaturerAdapter(manufaturers)
        adapter.onClickListener = {
            CarModelActivity.starter(it, this)
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
