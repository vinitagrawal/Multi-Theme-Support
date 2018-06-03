package me.vinitagrawal.multitheme

import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_settings.*

const val KEY_CURRENT_THEME = "current_theme"
const val LILAC_THEME = "lilac"
const val MINT_THEME = "mint"

class SettingsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        val currentTheme = sharedPref.getString(KEY_CURRENT_THEME, LILAC_THEME)

        mintTheme.isChecked = currentTheme == MINT_THEME
        mintTheme.setOnCheckedChangeListener { view, isChecked ->
            if (isChecked)
                sharedPref.edit().putString(KEY_CURRENT_THEME, MINT_THEME).apply()
            else
                sharedPref.edit().putString(KEY_CURRENT_THEME, LILAC_THEME).apply()
            recreate()
        }
    }

}