package com.example;

import org.springframework.data.annotation.AccessType;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * @author Petar Tahchiev
 * @since 1.2
 */
@Embeddable
@AccessType(AccessType.Type.FIELD)
public class LocalizedValue implements ILocalizable {

    /**
     * Default serial version uid.
     */
    private final static long serialVersionUID = 42L;

    /**
     * The {@code value} of the {@link LocalizedValue}.
     */
    @Column(name = "val")
    private String value;

    /**
     * A getter method for the {@code value}.
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * A setter method for the {@code value}.
     *
     * @param value The value to set
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }
        LocalizedValue that = ((LocalizedValue) o);
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
