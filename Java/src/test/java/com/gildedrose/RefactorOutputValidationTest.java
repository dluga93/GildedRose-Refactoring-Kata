package com.gildedrose;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefactorOutputValidationTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testNoOutputChangeWithoutConjuredItems() throws URISyntaxException, IOException {
        List<String> originalOutput = Files.readAllLines(Paths.get(Objects.requireNonNull(
            getClass().getClassLoader().getResource("before_refactor_20days.txt")).toURI()));

        TexttestFixture.main(new String[] {});

        List<String> newOutput = Arrays.asList(outputStreamCaptor.toString()
                .split(System.lineSeparator()));

        assertEquals(originalOutput.size(), newOutput.size(), "Different number of lines in output");

        for (int i = 0; i < originalOutput.size(); ++i) {
            if (originalOutput.get(i).startsWith("Conjured") && newOutput.get(i).startsWith("Conjured")) {
                continue;
            }

            assertEquals(originalOutput.get(i), newOutput.get(i), String.format("Line %d does not match", i+1));
        }
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
