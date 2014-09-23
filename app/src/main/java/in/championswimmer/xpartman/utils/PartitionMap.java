package in.championswimmer.xpartman.utils;

/**
 * Created by championswimmer on 10/9/14.
 */
public class PartitionMap {
    static String BASE_PATH = "/dev/block/platform/msm_sdcc.1/by-name";
    public static final int PARTITION_BOOT = 0;
    public static final int PARTITION_RECOVERY = 1;
    public static final int PARTITION_SYSTEM = 2;
    public static final int PARTITION_DATA = 3;
    public static final int PARTITION_TA = 4;
    public static final int PARTITION_CACHE = 5;

    public static String getPartitionPath(int partitionType, ModelInfo deviceModel) {
        switch (partitionType) {
            case PARTITION_BOOT:
                return BASE_PATH + deviceModel.getPartBoot();
            case PARTITION_RECOVERY:
                return BASE_PATH + deviceModel.getPartRecovery();
            case PARTITION_SYSTEM:
                return BASE_PATH + deviceModel.getPartSystem();
            case PARTITION_DATA:
                return BASE_PATH + deviceModel.getPartData();
            case PARTITION_CACHE:
                return BASE_PATH + deviceModel.getPartCache();
            case PARTITION_TA:
                return BASE_PATH + deviceModel.getPartTA();
        }
        return "";
    }

}
