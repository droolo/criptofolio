package com.universae.criptofolio

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.universae.criptofolio.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    //private lateinit var adapter : CriptoAdapter
    //  private val coinList : MutableLiveData<List<Coin>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

       // initRecyclerView()
      //  loadCoins("BTC")
        /*
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/
    }

    private fun initUI()
    {
        initNavigation()
    }

    private fun initNavigation()
    {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.navController
        binding.bottomNavView.setupWithNavController(navController)
    }

    /*private fun initRecyclerView() {
        adapter = CriptoAdapter(coinList)
       // binding.rvCoins.layoutManager = LinearLayoutManager(this)
       // binding.rvCoins.adapter = adapter
    }*/
/*
    @SuppressLint("NotifyDataSetChanged")
    private fun loadCoins(name:String){
        CoroutineScope(Dispatchers.IO).launch {
            var call = getRetrofit().create(CriptoApiService::class.java).getCoinList(1, 3)
            val coinBody = call.body()

            runOnUiThread()
            {
                if(call.isSuccessful)
                {
                    coinList.value = coinBody?.data ?: emptyList()
                    //  coinList.clear()
                    //coinList.addAll(coins)
                    adapter.notifyDataSetChanged()
                }
                else
                {
                    showError()
                }
            }
        }
    }
*/
    private fun showError() {
        Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder().
                baseUrl("https://pro-api.coinmarketcap.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
/*
    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty())
        {
            loadCoins(query.lowercase(Locale.getDefault()))
            return true
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }*/
}