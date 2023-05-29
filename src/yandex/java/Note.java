package yandex.java;

public enum Note {

    FIFTY(50L),
    HUNDRED(100L),
    FIVE_HUNDRED(500L),
    THOUSAND(1000L),
    FIVE_THOUSAND(5000L);

    Note(Long value) {
        this.value = value;
    }

    private final Long value;

    public Long value() {
        return value;
    }

}
