package com.edu.miu.cvapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edu.miu.cvapp.R
import com.edu.miu.cvapp.adapter.WorkAdapter
import com.edu.miu.cvapp.dialog.WorkDialog
import com.edu.miu.cvapp.model.Work

class WorkFragment : Fragment(R.layout.fragment_work) {

    private var workList = mutableListOf<Work>()
    private lateinit var adapter: WorkAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        if (context != null) {
            workList = mutableListOf(
                Work(
                    getString(R.string.company1),
                    getString(R.string.title1),
                    getString(R.string.year),
                    R.drawable.complogo
                ),
                Work(
                    getString(R.string.company2),
                    getString(R.string.title2),
                    getString(R.string.year),
                    R.drawable.complogo
                ),
                Work(
                    getString(R.string.company3),
                    getString(R.string.title3),
                    getString(R.string.year),
                    R.drawable.complogo
                ),
                Work(
                    getString(R.string.company3),
                    getString(R.string.title3),
                    getString(R.string.year),
                    R.drawable.complogo
                )
            )
            setupRecyclerView()
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { showWorkDialog() }
    }

    private fun setupRecyclerView() {
        if (::recyclerView.isInitialized) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = WorkAdapter(requireContext(), workList)
            recyclerView.adapter = adapter
        }
    }

    private fun showWorkDialog() {
        val dialog = WorkDialog()
        dialog.show(parentFragmentManager, WorkDialog::class.java.name)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onAddWOrk(work: Work) {
        workList.add(work)
        if (::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        } else {
            setupRecyclerView()
        }
    }

}