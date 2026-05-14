package com.glektarssza.player_handling_customizer.utils.tests;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import com.glektarssza.player_handling_customizer.utils.TypeUtils;

/**
 * Unit tests for the {@link TypeUtils} class.
 */
@Testable
public final class TypeUtilsSpec {
    @Test
    public void test_ensureNotNull_passesIfNotNull() {
        // -- Given
        Object value = new Object();

        // -- When
        ThrowingCallable method = () -> {
            Object r = TypeUtils.ensureNotNull(value);
            Assertions.assertThat(r).isSameAs(value);
        };

        // -- Then
        Assertions
            .assertThatNoException()
            .isThrownBy(method);
    }
}
