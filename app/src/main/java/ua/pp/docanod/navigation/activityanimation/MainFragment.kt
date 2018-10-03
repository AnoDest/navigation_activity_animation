package ua.pp.docanod.navigation.activityanimation


import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnNavigate.setOnClickListener {
            // This doesn't work:
            NavHostFragment.findNavController(this).navigate(R.id.action_mainFragment_to_activity2)
        }
        btnNavigateCorrect.setOnClickListener {
            // This does work properly
            NavHostFragment.findNavController(this).navigate(R.id.action_mainFragment_to_activity2, null, null,
                    ActivityNavigator.Extras(
                            ActivityOptionsCompat.makeCustomAnimation(activity!!, R.anim.view_slide_bottom_in, R.anim.no_animation)))
        }
    }


}
