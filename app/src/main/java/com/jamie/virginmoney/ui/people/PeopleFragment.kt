package com.jamie.virginmoney.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jamie.virginmoney.R
import com.jamie.virginmoney.data.model.People
import com.jamie.virginmoney.data.service.Resource
import com.jamie.virginmoney.databinding.FragmentPeopleBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text

@AndroidEntryPoint
class PeopleFragment : Fragment(), ItemClick {

    private val _peopleViewModel: PeopleViewModel by viewModels()
    private lateinit var _binding: FragmentPeopleBinding
    private lateinit var _adapter: PeopleListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        _peopleViewModel.people.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    _binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) {
                        setPeopleListAdapter(ArrayList(it.data))
                    }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    _binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setPeopleListAdapter(dataSet: ArrayList<People>) {
        _adapter = PeopleListAdapter(dataSet, this)
        _binding.peopleRecyclerId.layoutManager = LinearLayoutManager(requireContext())
        _binding.peopleRecyclerId.adapter = _adapter
    }

    override fun onItemClick(people: People) {
        showPersonDetailsBottomSheet(people)
    }

    private fun showPersonDetailsBottomSheet(item:People){

        val dialog = activity?.let { BottomSheetDialog(it) }

        val view = layoutInflater.inflate(R.layout.layout_people_details, null)

        val avatar = view.findViewById<ImageView>(R.id.iv_avatar)
        val name = view.findViewById<TextView>(R.id.name)
        val job = view.findViewById<TextView>(R.id.job)
        val email = view.findViewById<TextView>(R.id.email)
        val favouriteColor = view.findViewById<TextView>(R.id.favouriteColor)
        val createdDate = view.findViewById<TextView>(R.id.created)
        val btnClose = view.findViewById<Button>(R.id.btn_close)


        "Full Name : ${item.firstName}  ${item.lastName}".also { name.text = it }
        "Email : ${item.email}".also { email.text = it }
        "Job : ${item.jobTitle}".also { job.text = it }
        "Favourite Color : ${item.favouriteColor}".also { favouriteColor.text = it }
        "Created : ${item.createdAt}".also { createdDate.text = it }
        Picasso.get().load(item.avatar).into(avatar);

        btnClose.setOnClickListener {
            dialog?.dismiss()
        }

        dialog!!.setCancelable(true)
        dialog.setContentView(view)

        dialog.show()

    }
}