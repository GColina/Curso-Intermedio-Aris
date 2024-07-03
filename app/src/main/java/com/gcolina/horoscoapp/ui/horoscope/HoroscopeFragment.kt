package com.gcolina.horoscoapp.ui.horoscope

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.gcolina.horoscoapp.databinding.FragmentHoroscopeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    // private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private val horoscopeViewModel: HoroscopeViewModel by viewModels()

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}