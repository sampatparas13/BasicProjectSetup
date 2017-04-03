package com.imsp.basicprojectsetup.models.response;

/**
 * Created by SP on 03-04-2017.
 */

public class JsonValidatorResponse {

    String error;
    String object_or_array;
    boolean empty;
    float parse_time_nanoseconds;
    boolean validate;
    int size;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getObject_or_array() {
        return object_or_array;
    }

    public void setObject_or_array(String object_or_array) {
        this.object_or_array = object_or_array;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public float getParse_time_nanoseconds() {
        return parse_time_nanoseconds;
    }

    public void setParse_time_nanoseconds(float parse_time_nanoseconds) {
        this.parse_time_nanoseconds = parse_time_nanoseconds;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
