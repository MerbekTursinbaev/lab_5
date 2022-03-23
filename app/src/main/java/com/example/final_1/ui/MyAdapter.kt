package com.example.final_1.ui


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.final_1.dao.User
import com.example.final_1.databinding.ItemNameBinding

class MyAdapter() : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun populateModel(user: User) {
            binding.tvName.text = user.name
            binding.tvSalary.text = user.salary.toString()
            binding.tvWork.text = user.work
        }
    }

    var models: List<User> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}