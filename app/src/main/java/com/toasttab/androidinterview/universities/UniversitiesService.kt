package com.toasttab.androidinterview.universities

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversitiesService {

    @GET("/search")
    fun listUniversities(
        @Query("country") country: String? = null,
        @Query("name") name: String? = null
    ) : Call<List<University>>
}

data class University(
    @Json(name = "state-province")
    val stateProvince: String,
    @Json(name = "alpha_two_code")
    val alphaTwoCode: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    @Json(name = "web_pages")
    val webPages: List<String>
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.createStringArrayList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(stateProvince)
        parcel.writeString(alphaTwoCode)
        parcel.writeString(country)
        parcel.writeStringList(domains)
        parcel.writeString(name)
        parcel.writeStringList(webPages)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<University> {
        override fun createFromParcel(parcel: Parcel): University {
            return University(parcel)
        }

        override fun newArray(size: Int): Array<University?> {
            return arrayOfNulls(size)
        }
    }
}