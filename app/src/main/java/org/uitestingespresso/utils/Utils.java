package org.uitestingespresso.utils;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";


    public final static boolean isValidEmail(CharSequence target) {
        if (target.equals("")) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public final static boolean isValidPassword(CharSequence password){
        pattern = Pattern.compile(PASSWORD_PATTERN);
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        else{
            matcher=pattern.matcher(password);
            return matcher.matches();

        }
    }
}
