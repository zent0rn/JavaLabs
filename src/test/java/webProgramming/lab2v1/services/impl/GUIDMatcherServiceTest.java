package webProgramming.lab2v1.services.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class GUIDMatcherServiceTest {
    GUIDMatcherService guidMatcherService = new GUIDMatcherService();

    @ParameterizedTest
    @ValueSource(strings = {"d3aa88e2-c754-41e0-8ba6-4198a34aa0a2",
            "{6F9619FF-8B86-D011-B42D-00CF4FC964FF}",
            "(c56a4180-65aa-42ec-a945-5fd21dec0538)"})
    @DisplayName("Ensure service works correctly if entered GUID")
    void ensureServiceWorksCorrectlyIfEnteredGUID(String actual) {
        assertThat(GUIDMatcherService.match(actual)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"C56A4180-65AA-42EC-A945-5FD21DEC",
            "x56a4180-h5aa-42ec-a945-5fd21dec0538",
            "{6F9619FF-8B86-D011-2D-00CF4FC964FF",
            "c56a4180-65aa-42ec-a945-5fd21dec0538)", " "})
    @DisplayName("Ensure service works correctly if entered NOT GUID")
    void ensureServiceWorksCorrectlyIfEnteredNotGUID(String actual) {
        assertThat(GUIDMatcherService.match(actual)).isFalse();
    }
}