package io.github.diduseetheocean.uisamples.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import io.github.diduseetheocean.uisamples.R
import io.github.diduseetheocean.uisamples.databinding.FragmentDashboardBinding
import java.text.NumberFormat
import java.util.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listAdapter = ListAdapter()
        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            adapter = listAdapter
        }
        dashboardViewModel.shareDetailsLiveData.observe(viewLifecycleOwner, {
            //(requireActivity() as? AppCompatActivity)?.supportActionBar?.title = it.shareName
            requireActivity().findViewById<TextView>(R.id.toolbar_title).apply {
                text = it.shareName
            }
            view.findViewById<TextView>(R.id.title).apply {
                text = it.shareName
            }
            view.findViewById<TextView>(R.id.accountId).apply {
                text = it.accountId
            }
            view.findViewById<TextView>(R.id.accountTotal).apply {
                text = "${NumberFormat.getNumberInstance(Locale.GERMANY).format(it.accountTotal)} €"
            }
            view.findViewById<TextView>(R.id.dateRangeHeader).apply {
                text = "Stand: ${it.date}"
            }
            view.findViewById<TextView>(R.id.performanceHeader).apply {
                text = it.secondCol
            }
            view.findViewById<TextView>(R.id.volatilityHeader).apply {
                text = it.thirdCol
            }
            it?.let {
                listAdapter.submitList(it.rows)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}