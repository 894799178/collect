package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

/**
 * @ProjectName: collect
 * @Package: component
 * @ClassName: ChromeSeleniumComponent
 * @Author: 一条小咸鱼
 * @Description: 谷歌自动化框架组件获取与声明
 * @Date: 2019/1/30 15:34
 * @Version: 1.0
 */
public class ChromeSeleniumComponent {
    /**
     * 谷歌浏览器的一个实例,操作谷歌浏览器的方法由该Driver提供.
     */
    private static WebDriver webDriver= null;

    /**
     * 单例模式,获取谷歌浏览器的实例.
     * @return
     */
    public synchronized static WebDriver getInstance(){
        if (webDriver == null){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Tester\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            //设置WebDriver启动chrome为默认用户的配置信息（包括书签、扩展程序等）
            ChromeOptions options = new ChromeOptions();
            //为了获取console的日志输出
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            LoggingPreferences logPrefs = new LoggingPreferences();
            //输入为info的日志 
            logPrefs.enable(LogType.BROWSER, Level.INFO);
            caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            caps.setCapability(ChromeOptions.CAPABILITY, options);
            //传入谷歌启动器中
            WebDriver driver = new ChromeDriver(caps);
            //窗口最大化
            driver.manage().window().maximize();
            //打开测试地址
            driver.get("http://localhost:7456");
            webDriver = driver;
        }
        return  webDriver;
    }
}
