package com.example.orgware.kotlinsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SampleAdapter.onClickItemListener {

    val  value = arrayOf("Bharathi","Raja","Prasanth","Bharathi","Raja","Prasanth");
    val  place= arrayOf("G.Pattanam","G.Pattanam","K.Kanmai","G.Pattanam","G.Pattanam","K.Kanmai")
    val profile= arrayOf(R.drawable.apj1,R.drawable.apj1,R.drawable.apj1,R.drawable.apj1,R.drawable.apj1,R.drawable.apj1)

    val personalItem = ArrayList<PersonDetail>()
    var sampleAdapter :SampleAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in  value.indices){
            personalItem.add(PersonDetail(value[i],place[i],profile[i]))
        }
        sampleAdapter= SampleAdapter(this,this)
        rv_namelist.layoutManager=LinearLayoutManager(this)
        rv_namelist.adapter=sampleAdapter
        sampleAdapter!!.setNameList(personalItem)

    }

    override fun onClickedItem(item: PersonDetail, position: Int) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
    }

}
