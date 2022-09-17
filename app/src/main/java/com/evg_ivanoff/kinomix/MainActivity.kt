package com.evg_ivanoff.kinomix

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.evg_ivanoff.kinomix.databinding.ActivityMainBinding
import com.evg_ivanoff.kinomix.fragments.FavoritesFragment
import com.evg_ivanoff.kinomix.fragments.SearchFragment
import com.evg_ivanoff.kinomix.models.FavoriteFilmsViewModel
import com.evg_ivanoff.kinomix.models.FavoriteFilmsViewModelFactory
import com.evg_ivanoff.kinomix.models.FilmViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var activityRestored = false
    private val favoriteFilmViewModel: FavoriteFilmsViewModel by viewModels {
        FavoriteFilmsViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRestored = savedInstanceState?.getBoolean("RESTORED") != null
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (activityRestored == false) {
            startFragment(SearchFragment(), R.id.search_fragment)
        }

        favoriteFilmViewModel.allFavoriteFilms.observe(this, {
            it?.let { }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.favorites -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.search_fragment, FavoritesFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putBoolean("RESTORED", true)
        super.onSaveInstanceState(outState, outPersistentState)
    }

    private fun startFragment(fragment: Fragment, id: Int) {
        supportFragmentManager.beginTransaction()
            .replace(id, fragment)
            .commit()
    }
}