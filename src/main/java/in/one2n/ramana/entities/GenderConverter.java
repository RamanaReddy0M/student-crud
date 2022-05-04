package in.one2n.ramana.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter
public class GenderConverter implements AttributeConverter<Gender, String> {
    @Override
    public String convertToDatabaseColumn(Gender gender) {
        if(gender == null) return null;
        return gender.getGender();
    }

    @Override
    public Gender convertToEntityAttribute(String s) {
        if(s == null) return null;
        return Stream.of(Gender.values())
                .filter(g -> g.getGender().equalsIgnoreCase(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
