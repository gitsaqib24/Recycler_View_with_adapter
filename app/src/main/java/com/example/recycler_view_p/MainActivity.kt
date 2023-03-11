package com.example.recycler_view_p

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myArray  = arrayOf(
            "one","two","one","two","one"
            ,"two","two","one","two","one","two")

        val myRecyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView1)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = MyAdaper(myArray)


    }
}

class MyAdaper(private val array: Array<String>) : RecyclerView.Adapter<MyAdaper.MyViewHolder>()
{
    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false) as TextView
        val newViewHolder = MyViewHolder(inflater)
        return newViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.textView.text = array[position]
    }

    override fun getItemCount() = array.size
}



