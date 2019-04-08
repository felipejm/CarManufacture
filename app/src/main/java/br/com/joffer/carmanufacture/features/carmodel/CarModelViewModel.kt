package br.com.joffer.carmanufacture.features.carmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.joffer.carmanufacture.features.carmodel.model.CarModel
import br.com.joffer.carmanufacture.infra.onBackgroundThread
import io.reactivex.disposables.Disposable


class CarModelViewModel(manufaturer: String?): ViewModel() {

    private val interactor = CarModel.Interactor.instance
    private var disposable: Disposable? = null

    val carModels: MutableLiveData<List<Pair<String, String>>> = MutableLiveData()

    init {
        disposable = interactor.fetch(manufaturer ?: "", 0)
            .onBackgroundThread()
            .subscribe({
                carModels.postValue(it.wkda.map { Pair(it.value, it.key) })
            }, {
                Log.e("ViewModel",it.message, it)
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}