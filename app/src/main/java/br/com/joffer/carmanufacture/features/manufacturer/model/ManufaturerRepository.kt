package br.com.joffer.carmanufacture.features.manufacturer.model

import br.com.joffer.carmanufacture.BuildConfig
import br.com.joffer.carmanufacture.infra.RetrofitService
import io.reactivex.Observable

class ManufaturerRepository: Manufaturer.Repository{

    private val waKey = "coding-puzzle-client-449cc9d"

    private val service = RetrofitService(ManufaturerApi::class.java, BuildConfig.BASE_URL).apiService

    override fun fetch(page: Int, pageSize: Int): Observable<PageManufaturer> {
        return service.fetch(page, pageSize, waKey)
    }
}