package com.example.internshalla_2screen.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internshalla_2screen.R
import com.example.internshalla_2screen.adapter.RefineAdapter
import com.example.internshalla_2screen.adapter.adapterforservices
import com.example.internshalla_2screen.databinding.ActivityRefineBinding
import com.example.internshalla_2screen.modelclasses.modelforservices
import com.example.internshalla_2screen.modelclasses.refinemodel

class Refine : AppCompatActivity(), RefineAdapter.myinterface, adapterforservices.myinterface {
    lateinit var binding: ActivityRefineBinding
    lateinit var mAdapter: RefineAdapter
    lateinit var mSeriveAdapter: adapterforservices
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refine)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_refine)

        recyclerview1()
        recyclerview2()
        recyclerview3()
        //recyclerview4()

        val layout :ConstraintLayout = findViewById(R.id.myLayout)
        layout.setOnClickListener {
            startActivity(Intent(this,Explore::class.java))
        }

    }

    override fun onclick(dataItem: refinemodel, position: Int) {

    }

    override fun onclick(dataItem: modelforservices, position: Int) {

    }

    private fun recyclerview1() {
        binding.refineRecyclerview1.layoutManager = GridLayoutManager(
            this, 1,
            LinearLayoutManager.HORIZONTAL, false
        )
        mAdapter = RefineAdapter(this, this)
        binding.refineRecyclerview1.adapter = mAdapter

        val itemlist = ArrayList<refinemodel>()
        itemlist.add(refinemodel("Coffee"))
        itemlist.add(refinemodel("Business"))
        itemlist.add(refinemodel("Hobbies"))
        mAdapter.updatelist(itemlist)
    }

    private fun recyclerview2() {
        binding.refineRecyclerview2.layoutManager = GridLayoutManager(
            this, 1,
            LinearLayoutManager.HORIZONTAL, false
        )
        mAdapter = RefineAdapter(this, this)
        binding.refineRecyclerview2.adapter = mAdapter

        val itemlist = ArrayList<refinemodel>()
        itemlist.add(refinemodel("Friendship"))
        itemlist.add(refinemodel("Movies"))
        itemlist.add(refinemodel("Dining"))
        mAdapter.updatelist(itemlist)
    }

    private fun recyclerview3() {
        binding.refineRecyclerview3.layoutManager = GridLayoutManager(
            this, 1,
            LinearLayoutManager.HORIZONTAL, false
        )
        mAdapter = RefineAdapter(this, this)
        binding.refineRecyclerview3.adapter = mAdapter

        val itemlist = ArrayList<refinemodel>()
        itemlist.add(refinemodel("Dating"))
        itemlist.add(refinemodel("Matrimony"))
        mAdapter.updatelist(itemlist)


    }

    /*private fun recyclerview4() {
        val itemListForserivces = ArrayList<modelforservices>()
        mSeriveAdapter = adapterforservices(this, this)
        itemListForserivces.add(modelforservices(R.drawable.bell, "refine"))
        itemListForserivces.add(modelforservices(R.drawable.bell, "refine"))
        itemListForserivces.add(modelforservices(R.drawable.bell, "refine"))
        itemListForserivces.add(modelforservices(R.drawable.bell, "refine"))
        mSeriveAdapter.updatelist(itemListForserivces)

        binding.refineRecyclerviewforbottom.layoutManager =
            GridLayoutManager(this, 1, LinearLayoutManager.HORIZONTAL, false)
        binding.refineRecyclerviewforbottom.adapter = mSeriveAdapter

    }*/
}
