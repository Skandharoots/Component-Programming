package pl.cp;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SudokuField implements Comparable<SudokuField> {

    private int value;

    public SudokuField() {

    }

    public int getFieldValue() {
        return value;
    }

    public void setFieldValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE);
        builder.append(value);
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SudokuField)) {
            return false;
        }
        SudokuField c = (SudokuField) o;
        EqualsBuilder builder = new EqualsBuilder();
        return builder.append(value, c.value).isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        return builder.append(value).toHashCode();
    }

    public int compareTo(SudokuField arg) {
        if (arg == null) {
            throw new NullPointerException("Null pointer");
        }
        if (value == arg.value) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public SudokuField clone() throws CloneNotSupportedException {
        return this;
    }
}