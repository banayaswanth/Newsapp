package com.example.etpproject_newsapp

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


class homefragmnet : Fragment(){

    var modelClassArrayList: ArrayList<modelclass>? = null
    var adapter: Adapter? = null
    private var recyclerViewofhome: RecyclerView? = null
    val country = "in"
    private val API_KEY = "b3b451d320574d84b513c2084cf506d7"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.homefragmnet, null)
        recyclerViewofhome = v.findViewById<View>(R.id.recyclerviewofhome) as RecyclerView?
        modelClassArrayList = ArrayList()
        recyclerViewofhome!!.setLayoutManager(LinearLayoutManager(context))
        adapter = Adapter(requireContext(), modelClassArrayList!!)
        recyclerViewofhome!!.setAdapter(adapter)

        findNews()
        return v
    }
    private fun findNews() {
        apiutilities.getApiInterface().getNews(country, 100, API_KEY)!!.enqueue(object :Callback<news> {
            override fun onResponse(call: Call<news>, response: Response<news>) {
                if (response.isSuccessful) {
                    modelClassArrayList!!.addAll((response.body()?.getArticles() ?: emptyList()) as Collection<modelclass>)
                    adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<news>, t: Throwable) {}
        })
    }


}

internal fun <T> Call<T>.enqueue(callback: Callback<news>) {

}


