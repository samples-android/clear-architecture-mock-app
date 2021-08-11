package br.org.project.mockapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.org.project.mockapp.databinding.FragmentHomeBinding
import br.org.project.mockapp.presentation.adapter.PersonAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val adapter by lazy {
        PersonAdapter()
    }

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHomeBinding.inflate(layoutInflater, container, false).run {
        binding = this
        this.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.adapter = adapter

        viewModel.run {
            fetchPersons()
            persons.observe(viewLifecycleOwner, {
                adapter.submitList(it)
            })
        }

        binding.btn.setOnClickListener {
            viewModel.fetchMockedPersons()
        }


    }
}