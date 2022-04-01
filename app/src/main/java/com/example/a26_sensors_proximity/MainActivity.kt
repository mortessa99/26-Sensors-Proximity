package com.example.a26_sensors_proximity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , SensorEventListener {
    var sensor:Sensor? = null
    var sensorManager: SensorManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager




        if (sensorManager!!.getDefaultSensor(Sensor.TYPE_PROXIMITY) == null){
            Toast.makeText(this,"Your Device Not Support From This Sensor",Toast.LENGTH_LONG).show()
        }else{
            sensorManager!!.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        }

    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this,sensor, SensorManager.SENSOR_STATUS_ACCURACY_HIGH)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        myTxt.text = event!!.values[0].toString() + "Cm"
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        //
    }
}