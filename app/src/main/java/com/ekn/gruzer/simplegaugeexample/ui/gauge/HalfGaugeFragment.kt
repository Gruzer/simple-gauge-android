/*******************************************************************************
 * Copyright 2018 Evstafiev Konstantin

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/


package com.ekn.gruzer.simplegaugeexample.ui.gauge

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ekn.gruzer.gaugelibrary.Range
import com.ekn.gruzer.gaugelibrary.contract.ValueFormatter
import com.ekn.gruzer.simplegaugeexample.R
import kotlinx.android.synthetic.main.gauge_halfgauge_fragment.*


class HalfGaugeFragment : Fragment() {

    companion object {
        fun newInstance() = HalfGaugeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.gauge_halfgauge_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val range = Range()
        range.color = Color.parseColor("#ce0000")
        range.from =0.0
        range.to = -50.0

        val range2 = Range()
        range2.color = Color.parseColor("#E3E500")
        range2.from = -50.0
        range2.to = -100.0

        val range3 = Range()
        range3.color = Color.parseColor("#00b20b")
        range3.from = -100.0
        range3.to = -150.0

        //add color ranges to gauge
        //add color ranges to gauge
        halfGauge.addRange(range)
        halfGauge.addRange(range2)
        halfGauge.addRange(range3)

        //set min max and current value
        //set min max and current value
        halfGauge.minValue = 0.0
        halfGauge.maxValue = (-150).toDouble()
        halfGauge.value = (-80).toDouble()

        halfGauge.setNeedleColor(Color.DKGRAY)
        halfGauge.valueColor = Color.BLUE
        halfGauge.minValueTextColor = Color.RED
        halfGauge.maxValueTextColor = Color.GREEN


       /*
        val range = Range()
        range.color = Color.parseColor("#ce0000")
        range.from = 0.0
        range.to = 50.0

        val range2 = Range()
        range2.color = Color.parseColor("#E3E500")
        range2.from = 50.0
        range2.to = 100.0

        val range3 = Range()
        range3.color = Color.parseColor("#00b20b")
        range3.from = 100.0
        range3.to = 150.0

        halfGauge.addRange(range)
        halfGauge.addRange(range2)
        halfGauge.addRange(range3)

        halfGauge.minValue = 0.0
        halfGauge.maxValue = 150.0
        halfGauge.value = 0.0*/


        half_gauge_update_btn.setOnClickListener {
            halfGauge.value = half_gauge_value_ed.text.toString().toDouble()
        }

    }


}