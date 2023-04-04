package com.example.walking.fragment


import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walking.MyApplication2
import com.example.walking.databinding.FragmentMainBinding
import com.example.walking.model.Walking
import com.example.walking.recycler.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        var recyclerViewState: Parcelable?
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val serviceKey =
            "ySW6Ei6Oncs0opwRU/DIeWdmLYyXDK7LXEybY0cGhExFc10LY76oPuVHH5nXFB0FM7A3I1QKOvuiIbtAkIirhw=="
//            itemBinding=ItemMainBinding.inflate(layoutInflater)
//            itemBinding.maincontent.text

        val userListCall = MyApplication2.networkService.getList(serviceKey, 1, 46, "json")
        Log.d("chc", "url:" + userListCall.request().url().toString())

        userListCall.enqueue(object : Callback<Walking> {

            override fun onResponse(call: Call<Walking>, response: Response<Walking>) {

                recyclerViewState = binding.recyclerView.layoutManager?.onSaveInstanceState()
                val userList = response.body()
//                    Log.d("chc", "userList data 값 : ${userList?.getWalkingKr?.item}")
                //.......................................
                binding.recyclerView.layoutManager?.onRestoreInstanceState(recyclerViewState)
                binding.recyclerView.adapter =
                    MyAdapter(activity as Context, userList?.getWalkingKr?.item)

                binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(activity as Context, LinearLayoutManager.VERTICAL)
                )
            }

            override fun onFailure(call: Call<Walking>, t: Throwable) {
                call.cancel()
            }
        })

        return binding.root
    }

}



