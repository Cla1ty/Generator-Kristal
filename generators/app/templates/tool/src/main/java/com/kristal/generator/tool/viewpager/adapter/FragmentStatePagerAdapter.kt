package <%= appPackage %>.tool.viewpager.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import java.util.*

/**
 * Created by Kristal on 5/22/2017.
 */

class FragmentStatePagerAdapter(fm: FragmentManager) : android.support.v4.app.FragmentStatePagerAdapter(fm) {
    private val data = ArrayList<Entity>()

    override fun getPageTitle(position: Int): CharSequence = data[position].title
    override fun getItem(i: Int): Fragment = data[i].createFragmentListener.invoke()
    override fun getCount(): Int = data.size

    fun addPage(title: String, onCreateFragmentListener: () -> Fragment) {
        data.add(Entity(title, onCreateFragmentListener))
    }

    private class Entity (val title: String, val createFragmentListener: () -> Fragment)
}
