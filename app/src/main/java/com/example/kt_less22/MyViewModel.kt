package com.example.kt_less22

import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.kt_less22.api_service.HeroResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(var repo: Repository): ViewModel() {
    suspend fun fetchHeroes(listView: RecyclerView, supportFragmentManager: FragmentManager) {
        MainScope().launch {
                val response: List<HeroResponse> = GlobalScope.async {
                    repo.getHeroes()
                }.await()
                if (response.isNotEmpty()) {
                    val items = response
                    items?.let {
                        val myAdapter = MyRecyclerViewAdapter(it) { selectedItem ->
                            val detailFragment = ListFragment.newInstance(
                                selectedItem.biography.fullName,
                                selectedItem.biography.firstAppearance,
                                selectedItem.powerstats.power,
                                selectedItem.appearance.race,
                                selectedItem.images.lg
                            )
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.myFragment, detailFragment)
                                .addToBackStack(null)
                                .commit()
                            listView.visibility = View.GONE
                        }
                        listView.adapter = myAdapter
                    }
                } else {
                    throw Exception("errrorrr")
                }
        }

    }
}