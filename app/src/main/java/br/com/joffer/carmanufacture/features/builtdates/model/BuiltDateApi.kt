package br.com.joffer.carmanufacture.features.builtdates.model

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BuiltDateApi{

    @GET("/v1/car-types/built-dates")
    fun fetch(@Query("manufacturer") manufacturer: String,
              @Query("main-type") mainType: String,
              @Query("page") page: Int,
              @Query("pageSize") pageSize: Int,
              @Query("wa_key") waKey: String): Observable<PageBuiltDate>

}