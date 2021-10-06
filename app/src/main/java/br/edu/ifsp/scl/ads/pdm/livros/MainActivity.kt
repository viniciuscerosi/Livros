package br.edu.ifsp.scl.ads.pdm.livros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import br.edu.ifsp.scl.ads.pdm.livros.databinding.ActivityMainBinding
import br.edu.ifsp.scl.ads.pdm.livros.model.Livro

class MainActivity : AppCompatActivity() {
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val livrosList: MutableList<Livro> = mutableListOf()

    private val livrosAdapter: ArrayAdapter<String> by lazy {
        ArrayAdapter(this, android.R.layout.simple_list_item_1, livrosList.run {
            val livrosStringList = mutableListOf<String>()
            this.forEach{ livro -> livrosStringList.add(livro.toString()) }
            livrosStringList
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializadorLivrosList()

        activityMainBinding.livrosLv.adapter = livrosAdapter

    }

    private fun inicializadorLivrosList(){
        for (indice in 1..10){
            Livro(
                "Título ${indice}",
                "Isbn ${indice}",
                "Primeiro Autor ${indice}",
                "Editor ${indice}",
                indice,
                indice
            )
        }
    }
}