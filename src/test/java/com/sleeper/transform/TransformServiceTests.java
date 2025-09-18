package com.sleeper.transform;

import com.sleeper.transform.models.nfl.internal.League;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class TransformServiceTests {

    @Test
    public void optionalRefresherTest() {

        League league = null;

//        System.out.println(Optional.of(null).orElse("hi")); np

        System.out.println(Optional.ofNullable(null).orElse("hi"));

//        System.out.println(Optional.of(league).map(v -> v.getId()).orElse("hi")); np

        System.out.println(Optional.ofNullable(league).map(v -> v.getId()).orElse("hi"));

        System.out.println(Optional.of(new League()).map(v -> v.getId()).orElse("hi"));

        System.out.println(Optional.ofNullable(new League()).map(v -> v.getId()).orElse("hi"));


    }

}
