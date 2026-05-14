package com.glektarssza.player_handling_customizer.utils.tests;

import java.util.Locale;
import java.util.Random;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.annotation.Testable;

import net.datafaker.Faker;

import com.glektarssza.player_handling_customizer.utils.ArrayUtils;

/**
 * Unit tests for the {@link ArrayUtils} class.
 */
@Testable
public final class ArrayUtilsSpec {
    /**
     * The {@link Faker} instance for this unit test suite.
     */
    public static final Faker FAKER = new Faker(
        Locale.CANADA,
        new Random(
            Long
                .parseLong(
                    System
                        .getProperties()
                        .getProperty(
                            "FAKER_SEED",
                            Long
                                .toString(
                                    System.currentTimeMillis()
                                )
                        )
                )
        )
    );

    public static String[] generateRandomWordList(int wordCount) {
        String[] data = new String[wordCount];
        for (int i = 0; i < wordCount; i += 1) {
            data[i] = FAKER.lorem().word();
        }
        return data;
    }

    public static Stream<Arguments> generateRandomWordLists() {
        int listCount = FAKER.random().nextInt(10, 20);
        int wordCount = FAKER.random().nextInt(1, 20);
        Arguments[] args = new Arguments[listCount];
        for (int i = 0; i < listCount; i += 1) {
            args[i] = Arguments.of((Object)generateRandomWordList(wordCount));
        }
        return Stream.of(args);
    }

    @ParameterizedTest
    @MethodSource("generateRandomWordLists")
    public void test_join_generatesCorrectOutput(String[] wordList) {
        // -- Given
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordList.length - 1; i += 1) {
            sb.append(wordList[i]);
            sb.append(", ");
        }
        sb.append(wordList[wordList.length - 1]);
        final String result = sb.toString();

        // -- When
        final String r = ArrayUtils.join(wordList, ", ");

        // -- Then
        Assertions.assertThat(r).isEqualTo(result);
    }
}
