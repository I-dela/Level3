package com.example.studentportal

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.*
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter(private val portals: List<Portal>) :
    RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(portal: Portal) {
            itemView.tvPortalTitle.text = portal.portalTitle
            itemView.tvPortalUrl.text = portal.portalUrl

            itemView.setOnClickListener{
                val uris = Uri.parse(portal.portalUrl)
                val intents = Intent(Intent.ACTION_VIEW, uris)
                val b = Bundle()

                b.putBoolean("new_window", true)
                intents.putExtras(b)
                var context: Context = itemView.context
                context.startActivity(intents)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return portals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }
}