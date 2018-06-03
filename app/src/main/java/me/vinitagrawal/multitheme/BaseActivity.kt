package me.vinitagrawal.multitheme

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    private lateinit var currentTheme: String
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        currentTheme = sharedPref.getString(KEY_CURRENT_THEME, LILAC_THEME)
        setAppTheme(currentTheme)
    }

    override fun onResume() {
        super.onResume()
        val selectedTheme = sharedPref.getString(KEY_CURRENT_THEME, LILAC_THEME)
        if(currentTheme != selectedTheme)
            recreate()
    }

    private fun setAppTheme(currentTheme: String) {
        when (currentTheme) {
            MINT_THEME -> setTheme(R.style.Theme_App_Mint)
            else -> setTheme(R.style.Theme_App_Lilac)
        }
    }
}