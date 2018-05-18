package ml.jinggo.data.utils;

/**
 * 权重随机实体类
 * 数组生成具体的实体类
 */
public class RandomWeight {
    // 权重
    private static double[] weightArrays = {8.0, 2.0, 11.0, 79.0, 110.0};  // 数组下标是要返回的值，数组值为数组下标的权重

    public static void main(String[] args) {
        System.out.println(run(weightArrays));
    }
    // 执行随机生成
    public static int run(double[] weightArrays) {
        WeightRandom weightRandom = new WeightRandom();
        int weightValue = weightRandom.getWeightRandom(weightArrays);
        return weightValue;
    }
}

/**
 * 权重随机
 */
class WeightRandom {
    // 随机类
    java.util.Random r = new java.util.Random();
    // 权重随机
    private double weightArraySum(double[] weightArrays) {
        double weightSum = 0;//初始化权重计算
        for (double weightValue : weightArrays) {
            weightSum += weightValue;// 计算数组的权重
        }
        return weightSum;
    }
    // 获取权重随机
    public int getWeightRandom(double[] weightArrays) {
        // 计算权重量
        double weightSum = weightArraySum(weightArrays);
        // 阶段权重初始化
        double stepWeightSum = 0;
        for (int i = 0; i < weightArrays.length; i++) {
            stepWeightSum += weightArrays[i];// 对当前权重数组下标叠加
            // 按照概率计算
            // 通过Math.random()生成任意随机，去和总权重/当前随机权重去对比，如果大于i，则返回。
            if (Math.random() <= stepWeightSum / weightSum) {
                //System.out.println(i);
                return i;
            }
        }
        System.out.println("出错误了");
        return -1;
    }
}
