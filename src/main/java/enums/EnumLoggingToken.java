package enums;

/**
 * @ProjectName: collect
 * @Package: enums
 * @ClassName: EnumLoggingToken
 * @Author: 一条小咸鱼
 * @Description:  存储标记的枚举类型
 * @Date: 2019/1/30 15:43
 * @Version: 1.0
 */
public enum EnumLoggingToken {

    /**
     * 伤害测试的枚举数据.用于coocs客户端,匹配需要拦截的字符串所需要的标记.
     */
    DAMAGE_TEST("伤害测试","DamageTest"),
    /**
     * 用于自动点击的事件标记
     */
    AUTO_CLICK_FLAG("自动点击标记","autoClickFlag"),
    /**
     * 用于从所有日志数据中过滤出有效的数据
     * 这个标识
     */
    VALID_DATA("有效数据","flag");
    private String key;

    private String value;

    EnumLoggingToken(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}



