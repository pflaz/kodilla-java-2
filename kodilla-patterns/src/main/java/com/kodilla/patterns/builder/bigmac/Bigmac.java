package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final String roll;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static final String ROLL_WITH_SESAME_SEEDS = "Roll with sesame seeds";
    public static final String ROLL_WITHOUT_SEEDS = "Roll without seeds";

    public static final String SAUCE_STANDARD = "Standard sauce";
    public static final String SAUCE_1000_ISLANDS = "1000 Islands sauce";
    public static final String SAUCE_BARBEQUE = "Barbeque sauce";

    public static final String LETTUCE = "lettuce";
    public static final String ONION = "onion";
    public static final String BACON = "bacon";
    public static final String CUCUMBER = "cucumber";
    public static final String CHILI_PEPPERS = "chili peppers";
    public static final String MUSHROOMS = "mushrooms";
    public static final String SHRIMP = "shrimp";
    public static final String CHEESE = "cheese";

    public static class BigmacBuilder {
        private String roll;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder roll(String roll) {
            if (!(roll.equals(ROLL_WITH_SESAME_SEEDS) || roll.equals(ROLL_WITHOUT_SEEDS))) {
                throw new IllegalStateException("Roll should be with or without seeds.");
            }
            this.roll = roll;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers < 0) {
                throw new IllegalStateException("Burgers should not be negative value");
            }
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (!sauce.equals(SAUCE_STANDARD) && !sauce.equals(SAUCE_1000_ISLANDS) && !sauce.equals(SAUCE_BARBEQUE)) {
                throw new IllegalStateException("The sauce should be: standard, 1000 islands or barbeque");
            }
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            if (!ingredient.equals(LETTUCE) && !ingredient.equals(ONION) && !ingredient.equals(BACON) && !ingredient.equals(CUCUMBER)
                    && !ingredient.equals(CHILI_PEPPERS) && !ingredient.equals(MUSHROOMS) && !ingredient.equals(SHRIMP) && !ingredient.equals(CHEESE)) {
                throw new IllegalStateException("The ingredient should be chosen from the predefined list.");
            }
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(roll, burgers, sauce, ingredients);
        }
    }

    private Bigmac(String roll, int burgers, String sauce, List<String> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll='" + roll + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
