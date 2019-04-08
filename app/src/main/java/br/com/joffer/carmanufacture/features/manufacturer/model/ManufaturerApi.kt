package br.com.joffer.carmanufacture.features.manufacturer.model

import br.com.joffer.carmanufacture.features.carmodel.model.PageCarModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ManufaturerApi{

    @GET("/v1/car-types/manufacturer")
    fun fetch(@Query("page") page: Int, @Query("pageSize") pageSize: Int, @Query("wa_key") waKey: String): Observable<PageManufaturer>

}