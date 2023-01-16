package models;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.annotation.Nonnull;

@Data
@RequiredArgsConstructor
public class Step {

    @Nonnull
    private String name;
    @Nonnull
    private String keyword;
    private String spacing;

    public static Step generateRandomStep() {
        Faker faker = new Faker();
        String testStepName = faker.name().nameWithMiddle();
        String testStepKeyWord = faker.country().name();
        return new Step(testStepName, testStepKeyWord);

    }
}
