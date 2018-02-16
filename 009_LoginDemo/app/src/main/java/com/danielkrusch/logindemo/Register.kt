package com.danielkrusch.logindemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.register.*
import java.util.prefs.Preferences

/**
 * Created by Daniel on 2/15/2018.
 */

class Register: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        var username: EditText = txtUserReg
        var password: EditText = txtPassReg
        var email: EditText = txtEmailReg
        var btnRegister: View = btnRegister

        btnRegister.setOnClickListener(View.OnClickListener
        {
            fun onRegister(v: View)
            {
                var preferences: SharedPreferences = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE)
                var newUser = username.getText().toString()
                var newPassword = username.getText().toString()
                var newEmail = username.getText().toString()

                var editor: SharedPreferences.Editor = preferences.edit()

                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail)
                editor.commit()
            }
        })
    }
}
