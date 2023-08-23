package com.desafiolatam.adapterm5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafiolatam.adapterm5.adapter.Contact
import com.desafiolatam.adapterm5.adapter.ContactAdapter
import com.desafiolatam.adapterm5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ContactAdapter(dummyData())
        binding.rvContact.layoutManager = LinearLayoutManager(this)
        binding.rvContact.adapter = adapter


        adapter.onClick= {
            Log.d("ContactsFragment", "adapter.onClick: $it")
        }


    }

    private fun dummyData(): List<Contact> = listOf(
        Contact(
            id = 1,
            name = "Samuel Taylor Coleridge",
            phoneNumber = "+56 234 1231"
        ),
        Contact(
            id = 2,
            name = "Edgar Alan Poe",
            phoneNumber = "+56 234 1134"
        ),
        Contact(
            id = 3,
            name = "H.P. Lovecraft",
            phoneNumber = "+46 264 1134"
        ),
    )
}