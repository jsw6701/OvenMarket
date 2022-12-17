package com.example.ovenmarket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ovenmarket.model.User
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var mGoogleSignInClient : GoogleSignInClient? = null
    val database = Firebase.firestore

    private var uid: String? = null
    private var email: String? = null
    private var nickName: String? = null
    private var profileImgUri: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .requestProfile()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        auth = FirebaseAuth.getInstance()

        val loginButton = findViewById<SignInButton>(R.id.googleSignInBtn)
        loginButton.setOnClickListener {
            googleLogin()
        }
    }

    fun googleLogin() {
        val signInIntent = mGoogleSignInClient!!.signInIntent
        googleLoginLauncher.launch(signInIntent)
    }

    var googleLoginLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result : ActivityResult ->

        val TAG = "구글 로그인 결과"

        if (result.resultCode == -1) { //result.resultCode == RESULT_OK
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.getResult(ApiException::class.java)

                account.idToken?.let { idToken ->
                    // 데이터 스토어에 유저 정보 저장
                    email = account.email
                    nickName = account.displayName
                    profileImgUri = account.photoUrl.toString()
                }
                firebaseAuthWithGoogle(account.idToken!!)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            catch (e: ApiException) {
                Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            }
        } else {
            Log.d(TAG, "${result.resultCode} , ${result.data}")
            Log.d(TAG, "${auth}")
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val TAG = "구글 로그인 결과"
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        database.collection("users")
            .add(User(user!!.uid, email, nickName, profileImgUri))
    }
}