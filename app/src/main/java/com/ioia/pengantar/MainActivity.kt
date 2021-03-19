package com.ioia.pengantar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.ioia.pengantar.resources.DrawableActivity
import com.ioia.pengantar.resources.XmlActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLevel()
    }

    private fun initLevel(){
        val components = mutableMapOf(
            "Res Drawable" to DrawableActivity::class.java,
            "Res XML - Soon" to XmlActivity::class.java
        )

        components.forEach {
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            val button = MaterialButton(this, null, R.attr.materialButtonStyle)

            params.setMargins(16, 16, 16, 16)
            button.layoutParams = params
            button.text = it.key
            button.setOnClickListener {v ->
                startActivity(Intent(this, it.value))
            }

            ll_main.addView(button)
        }
    }

}
