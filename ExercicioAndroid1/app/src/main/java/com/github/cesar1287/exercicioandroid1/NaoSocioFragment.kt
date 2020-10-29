package com.github.cesar1287.exercicioandroid1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.cesar1287.exercicioandroid1.model.Socio
import com.google.android.material.textfield.TextInputLayout

class NaoSocioFragment : Fragment() {

    private lateinit var tilNome: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilTelefone: TextInputLayout
    private lateinit var tilSenha: TextInputLayout
    private lateinit var tilConfirmarSenha: TextInputLayout
    private lateinit var btCadastrar: Button

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nao_socio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
        setupObservables()
    }

    private fun setupObservables() {
        btCadastrar.setOnClickListener {
            var taTudoCerto = true
            val nome = tilNome.editText?.text.toString()
            val email = tilEmail.editText?.text.toString()
            val telefone = tilTelefone.editText?.text.toString()
            val senha = tilSenha.editText?.text.toString()
            val confirmarSenha = tilConfirmarSenha.editText?.text.toString()

            if (nome.isBlank()) {
                tilNome.error = getString(
                    R.string.campo_obrigatorio,
                    getString(R.string.nome_empresa)
                )
                taTudoCerto = false
            } else {
                tilNome.isErrorEnabled = false
            }

            if (email.isBlank()) {
                tilEmail.error = getString(
                    R.string.campo_obrigatorio,
                    getString(R.string.email)
                )
                taTudoCerto = false
            } else {
                tilEmail.isErrorEnabled = false
            }

            if (telefone.isBlank()) {
                tilTelefone.error = getString(
                    R.string.campo_obrigatorio,
                    getString(R.string.telefone)
                )
                taTudoCerto = false
            } else {
                tilTelefone.isErrorEnabled = false
            }

            if (senha.isBlank()) {
                tilSenha.error = getString(
                    R.string.campo_obrigatorio,
                    getString(R.string.senha)
                )
                taTudoCerto = false
            } else {
                tilSenha.isErrorEnabled = false
            }

            if (confirmarSenha.isBlank()) {
                tilConfirmarSenha.error = getString(
                    R.string.campo_obrigatorio,
                    getString(R.string.confirmar_senha)
                )
                taTudoCerto = false
            } else {
                tilConfirmarSenha.isErrorEnabled = false
            }

            if (taTudoCerto) {
                viewModel.setNovoSocio(
                    Socio(
                        nome = nome,
                        email = email,
                        telefone = telefone
                    )
                )
                viewModel.goToSocio(true)
            }
        }
    }

    private fun initComponents() {
        activity?.let {
            viewModel = ViewModelProvider(it).get(MainViewModel::class.java)

            tilNome = it.findViewById(R.id.tilNome)
            tilEmail = it.findViewById(R.id.tilEmail)
            tilTelefone = it.findViewById(R.id.tilTelefone)
            tilSenha = it.findViewById(R.id.tilSenha)
            tilConfirmarSenha = it.findViewById(R.id.tilConfirmarSenha)
            btCadastrar = it.findViewById(R.id.btCadastrar)
        }
    }
}