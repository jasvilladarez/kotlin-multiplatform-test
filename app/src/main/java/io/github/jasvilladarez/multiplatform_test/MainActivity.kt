package io.github.jasvilladarez.multiplatform_test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.jasvilladarez.multiplatform_test_shared.ElloApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ElloApi().getPublicToken {
            runOnUiThread {
                test.text = it.accessToken
            }
        }
    }
}
