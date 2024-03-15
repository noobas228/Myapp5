package com.example.myapplication2.network


import java.util.Objects

data class RickAndMorty(val result: ArrayList<CharacterData>) {
    val results: List<CharacterData>? = null
}

//data class CharacterData(val name: String?, val species: String?,  val image: String?, val status: String?, val original: Objects?, val locational: Objects?)*/
data class CharacterData(
    val created: String? = "",
    val episode: List<String>? = arrayListOf(),
    val gender: String? = "",
    val id: Int? = 0,
    val image: String? = "",
    val location: Location? = Location("", ""),
    val name: String? = "",
    val origin: Origin? = Origin("", ""),
    val species: String? = "",
    val status: String? = "",
    val type: String? = "",
    val url: String? = ""
){
    data class Origin(
        val name: String?,
        val url: String?
    )
    data class Location(
        val name: String?,
        val url: String?
    )
}
