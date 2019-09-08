package Task3;

import java.util.Objects;

public class Test {

    @Save public String name;
    @Save private int year;
    private String day;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        Test test = (Test) o;
        return year == test.year &&
                Objects.equals(name, test.name) &&
                Objects.equals(day, test.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, day);
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", day='" + day + '\'' +
                '}';
    }
}
