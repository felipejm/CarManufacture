package br.com.joffer.carmanufacture.features.manufacturer

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.joffer.carmanufacture.features.manufacturer.model.Manufaturer
import br.com.joffer.carmanufacture.infra.onBackgroundThread
import io.reactivex.disposables.Disposable

class ManufaturerViewModel : ViewModel() {

    private val interactor = Manufaturer.Interactor.instance
    private var disposable: Disposable? = null

    val manufaturers: MutableLiveData<List<Pair<String, String>>> = MutableLiveData()

    init {
        disposable = interactor.fetch(0)
            .onBackgroundThread()
            .subscribe({
                manufaturers.postValue(it.wkda.map { Pair(it.value, it.key) })
            }, {
                Log.e("ViewModel",it.message, it)
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}