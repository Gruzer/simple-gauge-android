package com.ekn.gruzer.gaugelibrary;

import com.ekn.gruzer.gaugelibrary.contract.ValueFormatter;

public class ValueFormatterImpl implements ValueFormatter {
    @Override
    public String getFormattedValue(double value) {
        return String.valueOf(value);
    }
}
