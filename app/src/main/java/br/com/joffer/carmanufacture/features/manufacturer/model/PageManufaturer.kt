package br.com.joffer.carmanufacture.features.manufacturer.model

data class PageManufaturer(val page: Int,
                           val pageSize: Int,
                           val totalPageCount: Int,
                           val wkda: Map<String, String>): Manufaturer.Model