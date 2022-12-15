package com.example.ovenmarket.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ovenmarket.DBKey.Companion.DB_USER
import com.example.ovenmarket.R
import com.example.ovenmarket.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UpdateFragment: Fragment(R.layout.fragment_home) {


    private lateinit var userDB: DatabaseReference
    private var binding: FragmentHomeBinding? = null
    private val auth: FirebaseAuth by lazy {
        Firebase.auth
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentHomeBinding = FragmentHomeBinding.bind(view)

        binding = fragmentHomeBinding

        userDB = Firebase.database.reference.child(DB_USER)


        fragmentHomeBinding.addFloatingButton.setOnClickListener {
            context?.let {

                if (auth.currentUser != null) {
                    val intent = Intent(it, UpdateMypage::class.java)
                    startActivity(intent)
                } else {
                    Snackbar.make(view, "로그인 후 사용해주세요.", Snackbar.LENGTH_LONG).show()
                }

            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}