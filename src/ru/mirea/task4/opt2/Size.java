package ru.mirea.task4.opt2;

public enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    S(36),
    M(38),
    L(40);

    private final int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    // По умолчанию — взрослый размер
    public String getDescription() {
        return "Взрослый размер";
    }
}