package br.com.collections.list.integrated;

public class UnityTime {
    private UnityTimeEnum unityTimeEnum;
    private final long timeInNanoseconds;
    private long resultTime;


    public static UnityTime getUnityInstance(final long valueInNanoseconds) {
        return new UnityTime(valueInNanoseconds);
    }

    public UnityTime(final long timeInNanoseconds) {
        super();
        this.timeInNanoseconds = timeInNanoseconds;
        this.buildUnityTime();
    }


    //TODO ajustar calculo de unidade de tempo
    private void buildUnityTime() {
        if (this.isUinityInSeconds()) {
            this.unityTimeEnum = UnityTimeEnum.NANOSECONDS_IN_SECONDS;
            this.resultTime = this.timeInNanoseconds / UnityTimeEnum.NANOSECONDS_IN_SECONDS.getValue();
        } else if (isUnityInMilliseconds()) {
            this.unityTimeEnum = UnityTimeEnum.NANOSECONDS_IN_MILLISECONDS;
            this.resultTime = this.timeInNanoseconds / UnityTimeEnum.NANOSECONDS_IN_MILLISECONDS.getValue();
        } else {
            this.unityTimeEnum = UnityTimeEnum.NANOSECONDS;
            this.resultTime = this.timeInNanoseconds / UnityTimeEnum.NANOSECONDS.getValue();
        }


    }

    private boolean isUinityInSeconds() {
        return this.timeInNanoseconds >= UnityTimeEnum.NANOSECONDS_IN_SECONDS.getValue();
    }

    private boolean isUnityInMilliseconds() {
        return this.timeInNanoseconds >= UnityTimeEnum.NANOSECONDS_IN_MILLISECONDS.getValue() &&
                timeInNanoseconds < UnityTimeEnum.NANOSECONDS_IN_SECONDS.getValue();
    }

    public long differenceTime(final long longerTime, final long shorterTime) {
        return longerTime - shorterTime;
    }

    public long getResultTime() {
        return this.resultTime;
    }


    public long getTimeInNanoseconds() {
        return this.timeInNanoseconds;
    }

    public String getUnity() {
        return unityTimeEnum.getUnity();
    }
}
