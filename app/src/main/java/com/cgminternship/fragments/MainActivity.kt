package com.cgminternship.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), ListingFragment.OnListingItemClick {

    companion object {
        private const val DETAILS_FRAGMENT_TAG = "details_fragment_tag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.containerFragment, DetailsFragment(), DETAILS_FRAGMENT_TAG)
            ft.addToBackStack(null)
//            ft.setTransition()
            ft.commit()

            supportFragmentManager.addOnBackStackChangedListener {

            }
        }
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)

        if (fragment is ListingFragment) {
            fragment.setItemClickListener(this)
        }
    }

    override fun onButtonClick() {
        var detailsFragment =
            supportFragmentManager.findFragmentByTag(DETAILS_FRAGMENT_TAG) as DetailsFragment?

        if (detailsFragment == null) {
            detailsFragment = DetailsFragment()
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.containerFragment, detailsFragment)
            ft.addToBackStack(null)
            ft.commit()
        }

        detailsFragment.setNewText("new text")

    }


    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
