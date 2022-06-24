package br.com.collections.list.integrated;

public enum UnityTimeEnum {
    NANOSECONDS(999999, "ns"),
    NANOSECONDS_IN_MILLISECONDS(1000000, "ms"),
    NANOSECONDS_IN_SECONDS(1000000000, "s");

    private final long value;
    private final String unity;

    UnityTimeEnum(final long value, final String unity) {
        this.value = value;
        this.unity = unity;
    }

    public long getValue() {
        return value;
    }

    public String getUnity() {
        return unity;
    }
}
