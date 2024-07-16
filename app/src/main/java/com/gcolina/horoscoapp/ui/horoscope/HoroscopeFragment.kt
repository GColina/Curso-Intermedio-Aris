package com.gcolina.horoscoapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gcolina.horoscoapp.databinding.FragmentHoroscopeBinding
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Aquarius
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Aries
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Cancer
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Capricorn
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Gemini
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Leo
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Libra
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Pisces
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Sagittarius
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Scorpio
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Taurus
import com.gcolina.horoscoapp.domain.model.HoroscopeInfo.Virgo
import com.gcolina.horoscoapp.domain.model.HoroscopeModel
import com.gcolina.horoscoapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {
    // private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private val horoscopeViewModel: HoroscopeViewModel by viewModels()

    private lateinit var horoscopeAdapter: HoroscopeAdapter
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initRecyclerView()
        initUIState()
    }

    // InitList
    private fun initRecyclerView() {
        horoscopeAdapter = HoroscopeAdapter(
            onItemSelected = {
                val type = when (it) {
                    Aquarius -> HoroscopeModel.Aquarius
                    Aries -> HoroscopeModel.Aries
                    Cancer -> HoroscopeModel.Cancer
                    Capricorn -> HoroscopeModel.Capricorn
                    Gemini -> HoroscopeModel.Gemini
                    Leo -> HoroscopeModel.Leo
                    Libra -> HoroscopeModel.Libra
                    Pisces -> HoroscopeModel.Pisces
                    Sagittarius -> HoroscopeModel.Sagittarius
                    Scorpio -> HoroscopeModel.Scorpio
                    Taurus -> HoroscopeModel.Taurus
                    Virgo -> HoroscopeModel.Virgo
                }

                findNavController().navigate(
                    HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(
                        type
                    )
                )
            }
        )
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
        /*
        Con el apply nos ahorramos a poner
        todo el rato
          binding.rvHoroscope...... , son pequeñas cositas para que quede mas Pro.

        binding.rvHoroscope.layoutManager = LinearLayoutManager(context)
        binding.rvHoroscope.adapter = horoscopeAdapter*/
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
