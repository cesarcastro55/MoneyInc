package com.example.moneyinc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentLoginBinding
import retrofit2.Call
import retrofit2.Response


class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.editTextTextPersonName.setText("funcionario")
        //binding.editTextTextPersonName.setText("cliente")
        binding.editTextTextPassword.setText("1234!\"#\$")


        binding.button.setOnClickListener {
            var username: String = binding.editTextTextPersonName.text.toString()
            var password: String = binding.editTextTextPassword.text.toString()

            getToken(username, password)

        }

        return binding.root
    }

    private fun getToken(username: String, password: String){
        var post: TokenPost = TokenPost(username, password)

        ServiceApi.retrofitService.createToken(post).enqueue(
            object : retrofit2.Callback<Token>{
                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Toast.makeText(context, "Erro!! Credenciais Incorretas", Toast.LENGTH_LONG).show()
                    Log.e("Error!!", "Sem dados!!")
                }

                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    var PostResponse: Token? = response.body()
                    if(PostResponse != null){
                        val tempToken = response.body()!!.token
                        if(username == "cliente") {
                            val aux: NavDirections = LoginFragmentDirections.actionLoginFragmentToSelectAccountFragment(tempToken)
                            findNavController().navigate(aux)}
                        else{
                            val aux: NavDirections = LoginFragmentDirections.actionLoginFragmentToEmployeeMenuFragment(tempToken)
                            findNavController().navigate(aux)}
                    }else{
                        Log.e("Erro!!", "Sem dados1!!")
                    }
                }

            }
        )
    }


}