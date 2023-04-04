package com.example.k1109_chc_test

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.k1109_chc_test.databinding.FragmentMainBinding
import com.example.k1109_chc_test.model.Walking
import com.example.k1109_chc_test.recycler.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {
    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val serviceKey = "PEeVd6bkb6u8P3npBc4jNKCcgpdciJCldzTr5YYBlA3UPq6aFSnlr0lZaXAmRjv6Ac55vxhIAtA2krRGXfh54A=="


        val userListCall = MyApplication.networkService.getList(serviceKey, 1, 46, "json")
        Log.d("chc", "url:" + userListCall.request().url().toString())

        userListCall.enqueue(object : Callback<Walking> {
            override fun onResponse(call: Call<Walking>, response: Response<Walking>) {

                val userList = response.body()
                Log.d("chc","userList data 값 : ${userList?.getWalkingKr?.item}")
                //.......................................

                binding.recyclerView.adapter= MyAdapter(activity as Context, userList?.getWalkingKr?.item)

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