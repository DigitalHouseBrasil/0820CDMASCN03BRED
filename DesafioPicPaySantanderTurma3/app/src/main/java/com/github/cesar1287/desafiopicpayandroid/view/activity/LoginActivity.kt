package com.github.cesar1287.desafiopicpayandroid.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse.*
import com.github.cesar1287.desafiopicpayandroid.databinding.ActivityLoginBinding
import com.github.cesar1287.desafiopicpayandroid.model.UserFirestore
import com.google.firebase.Timestamp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val callbackManager by lazy {
        CallbackManager.Factory.create()
    }

    private val providers by lazy {
        arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.FacebookBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.AnonymousBuilder().build(),
        )
    }

    private val firebaseAuth by lazy {
        Firebase.auth
    }

    private val firebaseFirestore by lazy {
        Firebase.firestore
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservables()
    }

    private fun setupObservables() {
        binding.btLoginSave.setOnClickListener {
            val user = hashMapOf(
                "name" to binding.tieLoginName.text.toString(),
                "last_name" to binding.tieLoginLastName.text.toString(),
                "email" to binding.tieLoginEmail.text.toString(),
                "phone" to binding.tieLoginPhone.text.toString(),
                "preferences" to hashMapOf(
                    "dark_mode" to true,
                    "language" to "pt-BR",
                    "geopoint" to GeoPoint(34.0, 22.0),
                    "last_sync" to Timestamp(Date())
                )
            )

            firebaseFirestore.collection(FIRESTORE_COLLECTION_USERS).document(firebaseAuth.currentUser?.uid ?: "")
                .set(user, SetOptions.merge())
                .addOnSuccessListener {
                    Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_LONG).show()
                }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
        }

        binding.btLoginLogout.setOnClickListener {
            firebaseAuth.signOut()
            initSignUp()
        }
    }

    override fun onResume() {
        super.onResume()
        firebaseAuth.currentUser?.let {
            val documentReference = firebaseFirestore.collection(FIRESTORE_COLLECTION_USERS)
                .document(it.uid)
            documentReference.get()
                .addOnSuccessListener {
                    val user = it.toObject<UserFirestore>()
                }.addOnFailureListener {
                    it.localizedMessage
                }
        } ?: run {
            // Create and launch sign-in intent
            initSignUp()
        }
    }

    private fun initSignUp() {
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setIsSmartLockEnabled(false)
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = firebaseAuth.currentUser
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }

    companion object {
        private const val RC_SIGN_IN = 999
        private const val FIRESTORE_COLLECTION_USERS = "users"
    }
}