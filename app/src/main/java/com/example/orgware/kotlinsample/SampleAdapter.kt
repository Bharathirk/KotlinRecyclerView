package com.example.orgware.kotlinsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.bumptech.glide.Glide

class SampleAdapter(val context: Context, val listener: onClickItemListener) : RecyclerView.Adapter<SampleAdapter.MyHolder>() {

    private var nameList: ArrayList<PersonDetail>?
    private val inflater: LayoutInflater


    init {
        nameList = ArrayList();
        inflater = LayoutInflater.from(context)
    }

    interface onClickItemListener {
        fun onClickedItem(item: PersonDetail, position: Int)
    }

    fun setNameList(itemList: List<PersonDetail>) {
        if (itemList == null) {
            return
        }
        nameList!!.clear()
        nameList!!.addAll(itemList)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(inflater.inflate(R.layout.item_sample, parent, false))

    }

    override fun getItemCount(): Int {
        return nameList!!.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: PersonDetail = nameList!![position]
        holder.setData(item)
    }

   inner class MyHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        @BindView(R.id.textView)
        lateinit var textview: TextView
        @BindView(R.id.textView2)
        lateinit var textview2: TextView
       @BindView(R.id.imageView)
        lateinit var imageView: ImageView

        init {
            ButterKnife.bind(this, itemview)
        }

        fun setData(s: PersonDetail) {
//
//            if (TextUtils.isEmpty(textview.text)){
//
//            }
            textview.text = s.name
            textview2.text = s.place
            Glide.with(context).load(s.image).into(imageView)

        }

        @OnClick(R.id.textView)
        fun clickedItem() {
            if (listener != null) {
                listener.onClickedItem(nameList!!.get(adapterPosition),adapterPosition)

            }
        }
    }
}