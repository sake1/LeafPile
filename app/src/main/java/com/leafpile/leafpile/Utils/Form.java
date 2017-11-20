package com.leafpile.leafpile.Utils;

/**
 * Created by USER on 04/11/2017.
 */

public interface Form {
    public boolean validate();
    public void onFormSubmitted();
    public void onFormError();
}
