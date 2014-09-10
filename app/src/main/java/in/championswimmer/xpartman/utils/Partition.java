package in.championswimmer.xpartman.utils;

/**
 * Created by championswimmer on 10/9/14.
 */
public class Partition {
    static String BASE_PATH = "/dev/block/platform/msm_sdcc.1/by-name";
    public static final int PARTITION_BOOT = 0;
    public static final int PARTITION_RECOVERY = 1;
    public static final int PARTITION_SYSTEM = 2;
    public static final int PARTITION_DATA = 3;
    public static final int PARTITION_TA = 4;
    public static final int PARTITION_CACHE = 5;

    public static Partition getPartition(int partitionType, ModelInfo deviceModel) {
        Partition p = new Partition();
        return p;
    }

}
