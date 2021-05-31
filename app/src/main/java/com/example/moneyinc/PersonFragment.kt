package com.example.moneyinc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.moneyinc.databinding.FragmentPersonBinding
import retrofit2.Call
import retrofit2.Response

class PersonFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentPersonBinding>(
            inflater,
            R.layout.fragment_person,
            container,
            false
        )


        val aux: PersonFragmentArgs ?= arguments?.let { PersonFragmentArgs.fromBundle(it) }
        val id = aux?.id.toString()
        val titular1 = aux?.titular1.toString()
        val iban = aux?.iban.toString()
        val nib = aux?.nib.toString()
        val swift = aux?.swift.toString()

        Log.e("Token recebido!!", id)

        binding.textView5.text = titular1
        binding.textView6.text = iban
        binding.textView7.text = nib
        binding.textView8.text = swift



        /*binding.button4.setOnClickListener {
            val aux: NavDirections = PersonFragmentDirections.actionPersonFragmentToHomeFragment(token)
            findNavController().navigate(aux)
        }*/


        //getInfo(token)

        return binding.root
    }

    /*private fun getInfo(token: String){
        var user: UserInfo ?= null

        ServiceApi2.retrofitService.getInformation(token).enqueue(
            object : retrofit2.Callback<UserInfo>{
                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    user = response.body()
                    //Log.e("Nome", user!!.titular1)
                    //Log.e("Saldo", user!!.saldo.toString())
                    //view?.findViewById<TextView>(R.id.textView5)?.text = user!!.titular1
                    //view?.findViewById<TextView>(R.id.textView6)?.text = user!!.iban
                    //view?.findViewById<TextView>(R.id.textView7)?.text = user!!.nib
                    view?.findViewById<TextView>(R.id.textView8)?.text = user!!.id.toString()
                }

                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    Log.e("Erro!!", "Sem dados2!!")
                }

            }
        )

    }*/

}