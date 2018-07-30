package pers.lh.interestdemo.animatorDemo;

import android.animation.TypeEvaluator;

/*
 * 自定义差值器
 * */
public class MyTypeEvaluator implements TypeEvaluator {
    private int mCurrentRed;

    private int mCurrentGreen;

    private int mCurrentBlue;

    @Override
    public Object evaluate(float v, Object o, Object t1) {
        String startColor = (String) o;
        String endColor = (String) t1;

        int startRed = Integer.parseInt(startColor.substring(1, 3), 16);
        int startGreen = Integer.parseInt(startColor.substring(3, 5), 16);
        int startBlue = Integer.parseInt(startColor.substring(5, 7), 16);

        int endRed = Integer.parseInt(endColor.substring(1, 3), 16);
        int endGreen = Integer.parseInt(endColor.substring(3, 5), 16);
        int endBlue = Integer.parseInt(endColor.substring(5, 7), 16);

        // 将初始化颜色的值定义为当前需要操作的颜色值
        if (v == 0) {
            mCurrentRed = startRed;
            mCurrentGreen = startGreen;
            mCurrentBlue = startBlue;
        }

        //计算变化的绝对值
        int redDiff = Math.abs(endRed - startRed);
        int greenDiff = Math.abs(endGreen - startGreen);
        int blueDiff = Math.abs(endBlue - startBlue);
        int colorDiff = redDiff + greenDiff + blueDiff;

        if (mCurrentRed != endRed) {
            mCurrentRed = getCurrentColor(startRed, endRed, colorDiff, 0,
                    v);
        } else if (mCurrentGreen != endGreen) {
            mCurrentGreen = getCurrentColor(startGreen, endGreen, colorDiff,
                    redDiff, v);
        } else if (mCurrentBlue != endBlue) {
            mCurrentBlue = getCurrentColor(startBlue, endBlue, colorDiff,
                    redDiff + greenDiff, v);
        }

        // 将计算出的当前颜色的值组装返回
        String currentColor = "#" + getHexString(mCurrentRed)
                + getHexString(mCurrentGreen) + getHexString(mCurrentBlue);
        return currentColor;
    }

    private int getCurrentColor(int startColor, int endColor, int colorDiff,
                                int offset, float fraction) {
        int currentColor;
        if (startColor > endColor) {
            currentColor = (int) (startColor - (fraction * colorDiff - offset));
            if (currentColor < endColor) {
                currentColor = endColor;
            }
        } else {
            currentColor = (int) (startColor + (fraction * colorDiff - offset));
            if (currentColor > endColor) {
                currentColor = endColor;
            }
        }
        return currentColor;
    }

    // 关注2:将10进制颜色值转换成16进制。
    private String getHexString(int value) {
        String hexString = Integer.toHexString(value);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return hexString;
    }

}
