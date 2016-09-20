package com.example;

import java.io.Serializable;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
public interface ILocalizable extends Serializable {

    String getValue();

    void setValue(String value);

}
