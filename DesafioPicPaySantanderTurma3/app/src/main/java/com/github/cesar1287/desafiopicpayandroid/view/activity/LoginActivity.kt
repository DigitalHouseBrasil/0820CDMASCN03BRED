package com.github.cesar1287.desafiopicpayandroid.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.firebase.ui.auth.IdpResponse.*
import com.github.cesar1287.desafiopicpayandroid.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FacebookAuthCredential
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val RC_SIGN_IN = 999

    private val callbackManager by lazy {
        CallbackManager.Factory.create()
    }

    private val providers by lazy {
        arrayListOf(
           AuthUI.IdpConfig.EmailBuilder().build(),
           AuthUI.IdpConfig.AnonymousBuilder().build(),
           AuthUI.IdpConfig.FacebookBuilder().build(),
           AuthUI.IdpConfig.AppleBuilder().build(),
           AuthUI.IdpConfig.TwitterBuilder().build(),
           AuthUI.IdpConfig.GoogleBuilder().build()
        )
    }

    private lateinit var signInClient: GoogleSignInClient

    private val firebaseAuth by lazy {
        Firebase.auth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        signUp()
//
//        //login google
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestEmail()
//            .build()
//
//        binding.signInButton.setOnClickListener {
//            val signInIntent: Intent = signInClient.signInIntent
//            startActivityForResult(signInIntent, RC_SIGN_IN)
//        }
//
//        signInClient = GoogleSignIn.getClient(this, gso)
//
//        LoginManager.getInstance().registerCallback(callbackManager,
//            object : FacebookCallback<LoginResult?> {
//                override fun onSuccess(loginResult: LoginResult?) {
//                    val token = loginResult?.accessToken
//                    val facebookCredential = FacebookAuthProvider.getCredential(token?.token ?: "")
//                    firebaseAuth.signInWithCredential(facebookCredential)
//                        .addOnSuccessListener {
//                            binding.tvLoginUserName.text = it.user?.displayName
//                        }.addOnFailureListener {
//                            Log.i("teste", it.toString())
//                            when(it) {
//                                is FirebaseAuthWeakPasswordException -> {
//                                    Toast.makeText(this@LoginActivity, "Senha fraca", Toast.LENGTH_SHORT).show()
//                                }
//                                is FirebaseAuthUserCollisionException -> {
//                                    Toast.makeText(this@LoginActivity, "Esse usuário já existe", Toast.LENGTH_SHORT).show()
//                                }
//                                else -> {
//                                    Toast.makeText(this@LoginActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
//                                }
//                            }
//                        }
//                }
//
//                override fun onCancel() {
//                    Log.i("teste", "teste")
//                }
//
//                override fun onError(exception: FacebookException) {
//                    exception
//                }
//            })
    }

    private fun signUp() {
        binding.btLoginSignUpEmail.setOnClickListener {
            firebaseAuth.createUserWithEmailAndPassword("teste1@teste.com", "123456")
                .addOnSuccessListener {
                    binding.tvLoginUserName.text = it.user?.displayName
                }.addOnFailureListener {
                    Log.i("teste", it.toString())
                    when(it) {
                        is FirebaseAuthWeakPasswordException -> {
                            Toast.makeText(this@LoginActivity, "Senha fraca", Toast.LENGTH_SHORT).show()
                        }
                        is FirebaseAuthUserCollisionException -> {
                        Toast.makeText(this@LoginActivity, "Esse usuário já existe", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(this@LoginActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }

        binding.btLoginSignUpAnonymous.setOnClickListener {
            firebaseAuth.signInAnonymously()
                .addOnSuccessListener {
                    binding.tvLoginUserName.text = "Usuário anônimo"
                }.addOnFailureListener {
                    Toast.makeText(this@LoginActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
                }
        }
    }

    override fun onResume() {
        super.onResume()
        firebaseAuth.currentUser?.let {
            binding.tvLoginUserName.text = it.displayName
        } ?: run {
            // Create and launch sign-in intent
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(),
                RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)

//        if (requestCode == RC_SIGN_IN) {
//            val task: Task<GoogleSignInAccount> =
//                GoogleSignIn.getSignedInAccountFromIntent(data)
//            handleSignInResult(task)
//        }

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

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            binding.signInButton.isVisible = false
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("TAG", "signInResult:failed code=" + e.statusCode)
        }
    }
}