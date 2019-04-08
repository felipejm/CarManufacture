package br.com.joffer.carmanufacture.features.carmodel.model

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CarModelApi{

    @GET("/v1/car-types/main-types")
    fun fetch(@Query("manufacturer") manufacturer: String, @Query("page") page: Int, @Query("pageSize") pageSize: Int, @Query("wa_key") waKey: String): Observable<PageCarModel>

}