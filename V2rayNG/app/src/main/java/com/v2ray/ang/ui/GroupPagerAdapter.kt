package com.v2ray.ang.ui

import android.annotation.SuppressLint
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.v2ray.ang.dto.GroupMapItem

class GroupPagerAdapter(
    private val activity: FragmentActivity,
    var groups: List<GroupMapItem>
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = groups.size
    override fun createFragment(position: Int) = GroupServerFragment.newInstance(groups[position].id)
    override fun getItemId(position: Int): Long = groups[position].id.hashCode().toLong()
    override fun containsItem(itemId: Long): Boolean = groups.any { it.id.hashCode().toLong() == itemId }

    @SuppressLint("NotifyDataSetChanged")
    fun update(newGroups: List<GroupMapItem>) {
        this.groups = newGroups
        // Post to avoid "FragmentManager is already executing transactions" crash
        activity.window.decorView.post {
            notifyDataSetChanged()
        }
    }
}
