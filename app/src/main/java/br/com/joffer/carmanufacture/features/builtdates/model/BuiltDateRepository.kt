package br.com.joffer.carmanufacture.features.builtdates.model

import br.com.joffer.carmanufacture.BuildConfig
import br.com.joffer.carmanufacture.infra.RetrofitService
import io.reactivex.Observable

class BuiltDateRepository: BuiltDateModel.Repository{

    private val waKey = "coding-puzzle-client-449cc9d"

    private val service = RetrofitService(BuiltDateApi::class.java, BuildConfig.BASE_URL).apiService

    override fun fetch(manufaturer: String, mainType: String, page: Int, pageSize: Int): Observable<PageBuiltDate> {
        return service.fetch(manufaturer, mainType, page, pageSize, waKey)
    }
}