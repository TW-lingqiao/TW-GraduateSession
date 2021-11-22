package com.example.adapterpattern.example_2;


import com.adapter.service.example_2.RoundHole;
import com.adapter.service.example_2.RoundPeg;
import com.adapter.service.example_2.SquarePeg;
import com.adapter.service.example_2.SquarePegAdapter;
import com.adapter.service.example_2.SquarePegAdapter1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AdapterTest {
    private RoundHole roundHole;

    @BeforeAll
    void setAll() {
        roundHole = new RoundHole(5);
    }

    @Test
    void should_success_with_roundPeg() {
        // given
        RoundPeg roundPeg = new RoundPeg(5);

        // when
        boolean fits = roundHole.fits(roundPeg);

        // then
        Assertions.assertTrue(fits);
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class SquarePegTest {
        private SquarePeg squarePeg;

        @BeforeAll
        void setSquarePeg() {
            squarePeg = new SquarePeg(5);
        }

        @Test
        @DisplayName("不使用adapter，通过函数重载的方式实现功能")
        void should_success_with_squarePeg_by_overloaded() {
            // when
            boolean fits = roundHole.fits(squarePeg);

            // then
            Assertions.assertTrue(fits);
        }

        @Test
        @DisplayName("继承的方式实现adapter")
        void should_success_with_squarePeg_by_adapter() {
            // given
            SquarePegAdapter squarePegAdapter = new SquarePegAdapter(squarePeg);

            // when
            boolean fits = roundHole.fits(squarePegAdapter);

            // then
            Assertions.assertTrue(fits);
        }

        @Test
        @DisplayName("引入变量的方式实现adapter")
        void should_success_with_squarePeg_by_adapter1() {
            // given
            SquarePegAdapter1 squarePegAdapter = new SquarePegAdapter1(squarePeg);

            // when
            boolean fits = roundHole.fits(squarePegAdapter.roundPeg);

            // then
            Assertions.assertTrue(fits);
        }
    }
}
