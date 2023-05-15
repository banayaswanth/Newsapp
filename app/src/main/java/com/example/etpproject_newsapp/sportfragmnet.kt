package com.example.etpproject_newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


class sportfragmnet : Fragment(){
    var modelClassArrayList: ArrayList<modelclass>? = null
    var adapter: Adapter? = null
    private var recyclerViewofsports: RecyclerView? = null
    val country = "in"
    private val API_KEY = "b3b451d320574d84b513c2084cf506d7"
    val category = "sports"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val v:View = inflater.inflate(R.layout.sportfragmnet,null)
        recyclerViewofsports = v.findViewById<View>(R.id.recyclerviewofsports) as RecyclerView?
        modelClassArrayList = ArrayList()
        recyclerViewofsports!!.setLayoutManager(LinearLayoutManager(context))
        adapter = Adapter(requireContext(), modelClassArrayList!!)
        recyclerViewofsports!!.setAdapter(adapter)

        findNews()

        return v
    }
    private fun findNews() {
        apiutilities.getApiInterface().getCategoryNews(country,category, 100, API_KEY)!!.enqueue(object : Callback<news> {
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