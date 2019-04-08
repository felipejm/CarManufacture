package br.com.joffer.carmanufacture.features.carmodel.model

import br.com.joffer.carmanufacture.BuildConfig
import br.com.joffer.carmanufacture.infra.RetrofitService
import io.reactivex.Observable

class CarModelRepository: CarModel.Repository{

    private val waKey = "coding-puzzle-client-449cc9d"

    private val service = RetrofitService(CarModelApi::class.java, BuildConfig.BASE_URL).apiService

    override fun fetch(manufaturer: String, page: Int, pageSize: Int): Observable<PageCarModel> {
        return service.fetch(manufaturer, page, pageSize, waKey)
    }
}