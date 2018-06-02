package me.vinitagrawal.multitheme

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*

const val KEY_CURRENT_THEME = "current_theme"
const val LILAC_THEME = "lilac"
const val MINT_THEME = "mint"

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        val currentTheme = sharedPref.getString(KEY_CURRENT_THEME, LILAC_THEME)
        setAppTheme(currentTheme)

        setContentView(R.layout.activity_settings)

        mintTheme.isChecked = currentTheme == MINT_THEME
        mintTheme.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked)
                sharedPref.edit().putString(KEY_CURRENT_THEME, MINT_THEME).apply()
            else
                sharedPref.edit().putString(KEY_CURRENT_THEME, LILAC_THEME).apply()
            recreate()
        }
    }

    private fun setAppTheme(currentTheme: String) {
        when (currentTheme) {
            MINT_THEME -> setTheme(R.style.Theme_App_Mint)
            else -> setTheme(R.style.Theme_App_Lilac)
        }
    }

}