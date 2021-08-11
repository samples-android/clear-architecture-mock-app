package br.org.project.mockapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.org.project.mockapp.databinding.ItemPersonBinding
import br.org.project.mockapp.data.model.PersonDTO
import br.org.project.mockapp.domain.model.PersonEntity


class PersonAdapter : ListAdapter<PersonEntity, PersonAdapter.PersonViewHolder>(object :
    DiffUtil.ItemCallback<PersonEntity>() {
    override fun areItemsTheSame(oldItem: PersonEntity, newItem: PersonEntity): Boolean =
        oldItem.name === newItem.name

    override fun areContentsTheSame(oldItem: PersonEntity, newItem: PersonEntity): Boolean =
        oldItem.name == newItem.name
}) {


    inner class PersonViewHolder(private val itemPersonBinding: ItemPersonBinding) :
        RecyclerView.ViewHolder(itemPersonBinding.root) {

        fun bind(person: PersonEntity) {
            itemPersonBinding.name.text = person.name
            itemPersonBinding.age.text = person.age
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
        PersonViewHolder(
            ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}