package <%= appPackage %>.tool.viewpager.adapter

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Created by Kristal on 3/11/2017.
 */

class ViewPagerAdapter : PagerAdapter() {
    private val data = ArrayList<Entity>()

    override fun getCount(): Int = data.size
    override fun isViewFromObject(view: View, `object`: Any): Boolean = view === `object`
    override fun getPageTitle(position: Int): CharSequence = data[position].title

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val lView = data[position].onCreateViewListener.invoke()
        container.addView(lView)
        return lView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    fun addPage(pTitle: String, pCreateView: () -> View) {
        data.add(Entity(pTitle, pCreateView))
    }

    private class Entity(val title: String, val onCreateViewListener: () -> View)

}
