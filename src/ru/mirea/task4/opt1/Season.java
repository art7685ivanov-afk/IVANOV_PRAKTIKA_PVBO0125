package ru.mirea.task4.opt1;

public enum Season {
    WINTER("Зима", -10) {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    },
    SPRING("Весна", 10) {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    },
    SUMMER("Лето", 25) {
        @Override
        public String getDescription() {
            return "Теплое время года";
        }
    },
    AUTUMN("Осень", 8) {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    };

    private final String name;
    private final int averageTemperature;

    Season(String name, int averageTemperature) {
        this.name = name;
        this.averageTemperature = averageTemperature;
    }

    public String getName() {
        return name;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    // Базовая реализация; Лето переопределяет в константе
    public String getDescription() {
        return "Холодное время года";
    }

    @Override
    public String toString() {
        return name + " (средняя температура: " + averageTemperature + "°C)";
    }
}