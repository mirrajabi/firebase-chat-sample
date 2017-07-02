package ir.mirrajabi.firebasecoolchat.infrastructure.helpers;

import android.widget.TextView;

import ir.mirrajabi.firebasecoolchat.R;

public final class FormsHelper {
    public static boolean isFormFilled(TextView... inputs) {
        boolean valid = true;
        if(inputs == null) return valid;
        if(inputs.length == 0) return valid;

        String error = inputs[0].getContext().getString(R.string.this_field_is_required);
        for(TextView input : inputs){
            if(input == null)
                continue;
            if(input.getText().toString().length() == 0) {
                valid = false;
                input.setError(error);
            }
        }
        return valid;
    }
}