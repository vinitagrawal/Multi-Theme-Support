package me.vinitagrawal.multitheme

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

  private lateinit var currentTheme: String
  private lateinit var sharedPref: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
    currentTheme = sharedPref.getString(KEY_CURRENT_THEME, LILAC_THEME)
    setAppTheme(currentTheme)

    setContentView(R.layout.activity_main)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.overflow_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    if (item?.itemId == R.id.settings)
      startActivity(Intent(this, SettingsActivity::class.java))

    return super.onOptionsItemSelected(item)
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
