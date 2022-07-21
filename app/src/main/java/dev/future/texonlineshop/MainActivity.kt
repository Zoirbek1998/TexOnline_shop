package dev.future.texonlineshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dev.future.texonlineshop.databinding.ActivityMainBinding
import dev.future.texonlineshop.ui.fragment.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var homeFragment = HomeFragment.newInstance()
    var cartFragment = CartFragment.newInstance()
    var ordersFragment = OrdersFragment.newInstance()
    var walletFragment = WalletFragment.newInstance()
    var profileFragment = ProfileFragment.newInstance()
    var activityFragment: Fragment = homeFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.nav_container, homeFragment, homeFragment.tag).hide(homeFragment).commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.nav_container, cartFragment, cartFragment.tag).hide(cartFragment).commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.nav_container, ordersFragment, ordersFragment.tag).hide(ordersFragment)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.nav_container, walletFragment, walletFragment.tag).hide(walletFragment)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.nav_container, profileFragment, profileFragment.tag).hide(profileFragment)
            .commit()

        supportFragmentManager.beginTransaction().show(activityFragment).commit()

        binding.bottomMenu.setOnItemSelectedListener {
            if (it.itemId == R.id.home) {
                supportFragmentManager.beginTransaction().hide(activityFragment).show(homeFragment)
                    .commit()
                activityFragment = homeFragment
            } else if (it.itemId == R.id.cart) {
                supportFragmentManager.beginTransaction().hide(activityFragment).show(cartFragment)
                    .commit()
                activityFragment = cartFragment
            } else if (it.itemId == R.id.orders) {
                supportFragmentManager.beginTransaction().hide(activityFragment)
                    .show(ordersFragment)
                    .commit()
                activityFragment = ordersFragment
            } else if (it.itemId == R.id.wallet) {
                supportFragmentManager.beginTransaction().hide(activityFragment)
                    .show(walletFragment)
                    .commit()
                activityFragment = walletFragment
            } else if (it.itemId == R.id.profile) {
                supportFragmentManager.beginTransaction().hide(activityFragment)
                    .show(profileFragment)
                    .commit()
                activityFragment = profileFragment
            }
            return@setOnItemSelectedListener true
        }
    }
}