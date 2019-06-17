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

import com.ekn.gruzer.simplegaugeexample.R
import kotlinx.android.synthetic.main.fragment_full_gauge.*
import kotlinx.android.synthetic.main.fragment_multi_gauge.*


class FullGauge : Fragment() {


    companion object {
        fun newInstance() = FullGauge()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_gauge, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


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

        fullGauge.minValue = 0.0
        fullGauge.maxValue = 150.0
        fullGauge.value = 35.0


        fullGauge.addRange(range)
        fullGauge.addRange(range2)
        fullGauge.addRange(range3)

        fullGauge.isUseRangeBGColor = true
        fullGauge.isDisplayValuePoint = true

        full_gauge_update_btn.setOnClickListener {
            fullGauge.value = full_gauge_value_ed.text.toString().toDouble()
        }


    }


}
