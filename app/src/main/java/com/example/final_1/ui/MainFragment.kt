package com.example.final_1.ui

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.final_1.R
import com.example.final_1.dao.MyDao
import com.example.final_1.dao.MyDataBase
import com.example.final_1.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val adapter = MyAdapter()
    private lateinit var dao: MyDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.recyclerView.adapter = adapter
        dao = MyDataBase.getInstance(requireContext()).myDao()

        adapter.models = dao.getAllUser()

        binding.etName.addTextChangedListener {
            adapter.models = dao.searchByName("%${it.toString()}%")
        }
    }
}