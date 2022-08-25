package com.br.usemobile.poc_library.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.br.usemobile.poc_library.common.LoginViewModelFactory
import com.br.usemobile.poc_library.data.repository.LoginRepositoryImp
import com.br.usemobile.poc_library.data.service.FirebaseServiceTestImp
import com.br.usemobile.poc_library.data.service.user.UserFirebaseImp
import com.br.usemobile.poc_library.databinding.FragmentLoginBinding
import com.br.usemobile.poc_library.domain.repository.LoginRepository
import com.br.usemobile.poc_library.domain.usecase.login.LoginUseCase
import com.br.usemobile.poc_library.domain.usecase.login.LoginUseCaseImp
import com.br.usemobile.poc_library.external.ChatManager

internal class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by lazy {
        val auth = FirebaseServiceTestImp()
        val repository: LoginRepository = LoginRepositoryImp(auth)
        val useCase: LoginUseCase = LoginUseCaseImp(repository)
        val factory = LoginViewModelFactory(useCase)
        ViewModelProvider(requireActivity(), factory)[LoginViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.apply {
            createAccount.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), "Success create account", Toast.LENGTH_SHORT)
                    .show()
            }
            errorCreateAccount.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), "Error create account", Toast.LENGTH_SHORT).show()
            }
            login.observe(viewLifecycleOwner) { user ->
                ChatManager.getManager().notifyOnAuth()
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToListConversationsFragment(
                    user?.uid ?: ""
                ))
            }
            errorLogin.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), "Error login account", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setUpListeners() {
        binding.apply {
            buttonSignIn.setOnClickListener {
                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()
                viewModel.signInWithEmailAndPassword(email, password)
            }
            buttonCreateUser.setOnClickListener {
                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()
                viewModel.createUserWithEmailAndPassword(email, password)
            }
        }
    }

}

