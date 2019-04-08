package br.com.joffer.carmanufacture.features.carmodel.model

data class PageCarModel(val page: Int,
                        val pageSize: Int,
                        val totalPageCount: Int,
                        val wkda: Map<String, String>): CarModel.Model