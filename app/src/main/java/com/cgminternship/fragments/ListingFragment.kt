package com.cgminternship.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ListingFragment : Fragment() {

    private var callback: OnListingItemClick? = null

    fun setItemClickListener(listener: OnListingItemClick?) {
        callback = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listing, container, false).also {
            it.findViewById<Button>(R.id.btnListing).setOnClickListener {
                callback?.onButtonClick()
            }
        }

        /**
         * res/layout-w600dp/main_activity.xml  # For 7” tablets or any screen with 600dp
            #  available width (possibly landscape handsets)
         */
    }


    interface OnListingItemClick {
        fun onButtonClick()
    }

}