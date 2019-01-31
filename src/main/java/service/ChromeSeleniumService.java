package service;

import java.util.List;

/**
 * @ProjectName: collect
 * @Package: service
 * @ClassName: ChromeSeleniumService
 * @Author: 一条小咸鱼
 * @Description: 谷歌自动化服务层
 * @Date: 2019/1/30 15:55
 * @Version: 1.0
 */
public interface ChromeSeleniumService {
    /**
     * 获取当前所在运行的谷歌浏览器中的日志消息,有且只能获取一次
     * @return
     */
    List<String> getCurrentLog();

    /**
     * 获取当前有效的数据,通过枚举类的ValidData进行过滤筛选
     * @return
     */
    List<String> getCurrentValidLog();
}
