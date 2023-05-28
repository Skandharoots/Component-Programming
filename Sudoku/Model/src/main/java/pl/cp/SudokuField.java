package pl.cp;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class SudokuField implements Comparable<SudokuField>, Cloneable {

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

    @Override
    public int compareTo(SudokuField arg) {
        if (arg == null) {
            throw new NullPointerException("Null pointer");
        }
        return new CompareToBuilder()
                .append(value, arg.value)
                .toComparison();
    }

    @Override
    public SudokuField clone() throws CloneNotSupportedException {
        return (SudokuField) super.clone();
    }
}
