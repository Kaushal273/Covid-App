package com.example.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_covid_cases.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CovidCases : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_cases)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        val serviceGenerator = ServiceGenerator.buildService(ApiService :: class.java)
        val call = serviceGenerator.getStats()

        call.enqueue(object : Callback<MutableList<InfoModel>>{
            override fun onResponse(
                call: Call<MutableList<InfoModel>>,
                response: Response<MutableList<InfoModel>>
            ) {
                if(response.isSuccessful){
                    rv_covid.apply {
                        layoutManager = LinearLayoutManager(this@CovidCases)
                        adapter = CovidAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<InfoModel>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error",t.message.toString())
            }

        })

    }

}