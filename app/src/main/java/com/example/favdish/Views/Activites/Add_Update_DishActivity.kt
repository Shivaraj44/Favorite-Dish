package com.example.favdish.Views.Activites

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.favdish.R
import com.example.favdish.databinding.ActivityAddUpdateBinding
import com.example.favdish.databinding.DailogCustomImageSlectionBinding

class Add_Update_DishActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var mbinding :ActivityAddUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mbinding = ActivityAddUpdateBinding.inflate(layoutInflater)
        setContentView(mbinding.root)
        mbinding.ivAddPhoto.setOnClickListener(this)
        setUpActionBar()
    }
    fun setUpActionBar(){
        setSupportActionBar(mbinding.addUpdareToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mbinding.addUpdareToolbar.setNavigationOnClickListener {
             onBackPressed()
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_add_photo ->{
               customImageSelectionDiaglog()
                //Toast.makeText(this,"You have clicked the photo",Toast.LENGTH_SHORT).show()
                return
            }
        }
    }
    fun customImageSelectionDiaglog(){
        val dialog = Dialog(this)
        val binding : DailogCustomImageSlectionBinding = DailogCustomImageSlectionBinding.inflate(layoutInflater )
       dialog.setContentView(binding.root)

        dialog.show()
        binding.tvCamera.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Camera Clicked",Toast.LENGTH_SHORT).show()
        })
    }
}