package com.example.fooddeliveri.model

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


const val apikey = "96694ffc0d914663b47114252230110"
private fun getData(city: String, context: Context,
                    dataapi: MutableState<List<data>>,
                     ) {
    val url = "https://api.weatherapi.com/v1/forecast.json?key=$apikey" +
            "&q=$city" +
            "&days=3" +
            "&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        { response ->
            val list= getWetherByDays(response)
            dataapi.value=list
            Log.d("MyLog", "Response:$response") },
        { Log.d("MyLog", "VolleyError:$it") }
    )
    queue.add(sRequest)
}

private fun getWetherByDays(response: String): List<data> {
    if (response.isEmpty()) return listOf()
    val list = ArrayList<data>()
    val mainObject = JSONObject(response)
    val city = mainObject.getJSONObject("location").getString("name")
    val days = mainObject.getJSONObject("forecast").getJSONArray("forecastday")
    for (i in 0 until days.length()) {
        val item = days[i] as JSONObject
        list.add(
            data(
                item.getJSONObject("day").getJSONObject("condition").getString("text"),
                item.getJSONObject("day").getJSONObject("condition").getString("icon"),
                item.getJSONObject("day").getString("maxtemp_c"),
                item.getJSONObject("day").getString("mintemp_c"),

            )
        )
    }


    return  list
}