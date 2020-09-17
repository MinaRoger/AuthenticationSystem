package com.example.my_tut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.my_tut.utils.UserSharedPreference
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var title: TextView
    lateinit var price: TextView
    lateinit var description: TextView
    private val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = findViewById(R.id.title)
        price = findViewById(R.id.price)
        description = findViewById(R.id.textView)
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body()?.string()
                val gson = Gson()
                val listTutorialType = object : TypeToken<List<Product>>() {}.type
                val product: ArrayList<Product> = gson.fromJson(json, listTutorialType)
                updateUI(product)

                println("> From JSON String:\n" + product)

            }
        })
    }

    companion object {
        private const val URL = "https://my-tut.herokuapp.com/product/"
        val request: Request = Request.Builder()
            .url(URL)
            .build()
    }

    fun updateUI(product: ArrayList<Product>) {
        runOnUiThread {
            title.text = product[0].title
            price.text = product[0].price.toString() + "EGP"
            description.text = UserSharedPreference(this)
                .getToken()
        }
    }
}