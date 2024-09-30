package zadachi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;

public class Person implements Externalizable {
    private String name;
    private LocalDate birth;
    private transient int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return birth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.birth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(birth);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        birth = (LocalDate) in.readObject();
        age = recalculateAge(birth);
    }

    public static int recalculateAge(LocalDate input) {
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - input.getYear();

        if (currentDate.getDayOfYear() < input.getDayOfYear()) {
            age--;
        }

        return age;
    }

    public String toString() {
        return String.format("person name = %s, person date of birth = %s, person age = %d", getName(), getDateOfBirth().toString(), getAge());
    }
}
