package service.impl;

import component.ChromeSeleniumComponent;
import enums.EnumLoggingToken;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import service.ChromeSeleniumService;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: collect
 * @Package: service.impl
 * @ClassName: ChromeSeleniumServiceImpl
 * @Author: 一条小咸鱼
 * @Description: ${description}
 * @Date: 2019/1/30 16:00
 * @Version: 1.0
 */
public class ChromeSeleniumServiceImpl implements ChromeSeleniumService {

    private static WebDriver webDriver = ChromeSeleniumComponent.getInstance();
    private final static String validFlag =  EnumLoggingToken.VALID_DATA.getValue();
    private static Logs logs = webDriver.manage().logs();

    @Override
    public List<String> getCurrentLog() {
        return this.getMessageToList(logs,"");
    }

    @Override
    public List<String> getCurrentValidLog() {
        return this.getMessageToList(logs,validFlag);
    }

    /**
     * 获取logEntries中的日志,可以通过
     * @param logs
     * @param screeningFlag 筛选使用的标记,空字符串标识无需过滤
     * @return
     */
    private List<String> getMessageToList(Logs logs,String screeningFlag){
        LogEntries logEntries = logs.get(LogType.BROWSER);
        List<String> modelList = new ArrayList<>();
        //迭代监控到的日志,获取控制台所有日志
        for(LogEntry entry : logEntries) {
            System.out.println(entry.getMessage());
            int pos =StringUtils.isExist(entry.getMessage(),screeningFlag);
            if(pos>=0){
                modelList.add(entry.getMessage());
            }
        }
        return modelList;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static String getValidFlag() {
        return validFlag;
    }

    public static Logs getLogs() {
        return logs;
    }
}
