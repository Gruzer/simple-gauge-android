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


package com.ekn.gruzer.gaugelibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class FullGauge extends AbstractGauge {

    private float sweepAngle = 360;
    private float startAngle = 270;
    private float gaugeBGWidth = 20f;


    public FullGauge(Context context) {
        super(context);
        init();
    }

    public FullGauge(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FullGauge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public FullGauge(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        getGaugeBackGround().setStrokeWidth(gaugeBGWidth);
        getTextPaint().setTextSize(35f);
        setPadding(20f);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.translate((getWidth() / 2f) - ((getRectRight() / 2f) * getScaleRatio()), (getHeight() / 2f) - 200f * getScaleRatio());
        canvas.scale(getScaleRatio(), getScaleRatio());
        canvas.drawArc(getRectF(), startAngle, sweepAngle, false, getGaugeBackGround());
        drawValueRange(canvas);
        canvas.restore();

        //drawText
        drawValueText(canvas);

    }


    private void drawValueText(Canvas canvas) {
        canvas.save();
        canvas.translate((getWidth() / 2f) - ((getRectRight() / 2f) * getScaleRatio()), (getHeight() / 2f) - 220f * getScaleRatio());
        canvas.scale(getScaleRatio(), getScaleRatio());
        canvas.drawText(getValue() + "", 200f, 240f, getTextPaint());
        canvas.restore();
    }

    private Paint getRangePaint(double value) {
        Paint color = new Paint(Paint.ANTI_ALIAS_FLAG);
        color.setStrokeWidth(gaugeBGWidth);
        color.setStyle(Paint.Style.STROKE);
        color.setColor(getGaugeBackGround().getColor());
        color.setStrokeCap(Paint.Cap.ROUND);

        for (Range range : getRanges()) {
            if (range.getTo() <= value)
                color.setColor(range.getColor());

            if (range.getFrom() <= value && range.getTo() >= value)
                color.setColor(range.getColor());
        }
        return color;
    }

    private void drawValueRange(Canvas canvas) {
        float sweepAngle = calculateSweepAngle(getValue());
        canvas.drawArc(getRectF(), startAngle, sweepAngle, false, getRangePaint(getValue()));
    }

    private float calculateSweepAngle(double to) {
        float valuePer = getCalculateValuePercentage(to);
        return sweepAngle / 100 * valuePer;
    }

    protected float getSweepAngle() {
        return sweepAngle;
    }

    protected void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
    }

    protected float getStartAngle() {
        return startAngle;
    }

    protected void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
    }

    protected float getGaugeBGWidth() {
        return gaugeBGWidth;
    }

    protected void setGaugeBGWidth(float gaugeBGWidth) {
        this.gaugeBGWidth = gaugeBGWidth;
    }
}
