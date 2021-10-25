public class Problems {
    public static int half_period1(int initialVolume, int targetValume) {
        int day;
        int volume = initialVolume;
        //循環不變量: 經過i天水的體積
        //迴圈終止條件: 水量 <= 目標值
        //迴圈繼續條件: 水量未達到目標值 (水量 > 目標值)
        for (day = 0; volume > targetValume; day++) {
            System.out.println(String.format("The volume of water after %d day: %4d mL", day, volume));
            volume /= 2;
        }
        return day;
    }

    public static int half_period2(int initialVolume, int targetValume) {
        int day = 0;
        int volume = initialVolume;

        while (true) {
            System.out.println(String.format("The volume of water after %d day: %4d mL", day, volume));
            if (volume <= targetValume) {
                break;
            }
            volume /= 2;
            day++;
        }

        return day;
    }

    public static int half_period3(int initialVolume, int targetValume) {
        return half_period3(initialVolume, targetValume, 0);
    }

    private static int half_period3(int volume, int targetValume, int day) {
        if (volume <= targetValume) {
            System.out.println(String.format("The volume of water after %d day: %4d mL", day, volume));
            return day;
        }
        System.out.println(String.format("The volume of water after %d day: %4d mL", day, volume));
        return half_period3(volume/2, targetValume, day+1);
    }

    public static void main(String[] args) {
        System.out.println(half_period1(1000, 50) + " day");
        System.out.println(half_period2(1000, 50) + " day");
        System.out.println(half_period3(1000, 50) + " day");
    }
}
