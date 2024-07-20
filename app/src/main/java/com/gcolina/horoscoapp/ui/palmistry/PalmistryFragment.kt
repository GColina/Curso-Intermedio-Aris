package com.gcolina.horoscoapp.ui.palmistry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gcolina.horoscoapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        /*if (checkCameraPermission()) {
            // Tiene los permisos aceptados.
        } else {
            // Tendre que pedirle los permisos.
        }*/
    }

   /* private fun checkCameraPermission(): Boolean = PermissionChecker.checkPermission(
        requireContext(),
        android.Manifest.permission.CAMERA
    ) == PermissionChecker.PERMISSION_GRANTED*/

    private fun initUi() {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
