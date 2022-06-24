package br.com.collections.list.integrated;

public class UnityTime {
    private UnityTimeEnum unityTimeEnum;
    private final long timeInNanoseconds;
    private long resultTime;


    public static UnityTime getInstance(final long valueInNanoseconds) {
        return new UnityTime(valueInNanoseconds);
    }

    private UnityTime(final long timeInNanoseconds) {
        super();
        this.timeInNanoseconds = timeInNanoseconds;
        this.buildUnityTime();
    }

    private void buildUnityTime() {
        if (this.isUinityInSeconds())
            this.unityTimeEnum = UnityTimeEnum.NANOSECONDS_IN_SECONDS;
        else if (isUnityInMilliseconds())
            this.unityTimeEnum = UnityTimeEnum.NANOSECONDS_IN_MILLISECONDS;
        else
            this.unityTimeEnum = UnityTimeEnum.NANOSECONDS;

        this.resultTime = this.timeInNanoseconds / this.unityTimeEnum.getValue();

    }

    private boolean isUinityInSeconds() {
        return this.timeInNanoseconds >= UnityTimeEnum.NANOSECONDS_IN_SECONDS.getValue();
    }

    private boolean isUnityInMilliseconds() {
        return this.timeInNanoseconds >= UnityTimeEnum.NANOSECONDS_IN_MILLISECONDS.getValue() &&
                timeInNanoseconds < UnityTimeEnum.NANOSECONDS_IN_SECONDS.getValue();
    }

    public long getResultTime() {
        return this.resultTime;
    }

    public String getUnity() {
        return unityTimeEnum.getUnity();
    }
}
