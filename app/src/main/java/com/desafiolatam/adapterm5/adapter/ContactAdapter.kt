package com.desafiolatam.adapterm5.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafiolatam.adapterm5.databinding.ItemContactBinding

class ContactAdapter(
    private val contacts: List<Contact>
): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    var onClick: ((String) -> Unit)? = null

    inner class ContactViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(contact: Contact) {
            with(binding) {
                contact.run {
                    tvContactName.text = name
                    tvContactPhoneNumber.text = phoneNumber
                    tvContactPhoneNumber.setOnClickListener {
                        onClick?.invoke(phoneNumber)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.onBind(contacts[position])
    }
}