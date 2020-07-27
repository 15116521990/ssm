package com.zking.ssm.untity;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102700769100";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC84cGkO1aV297ok29rjdFJkjPjglBEkNR0OcEnIqmph/dbtwbJ9+xwcE59mtAUP6CrBbYwmKliicDfKwhlhXMOs29VfDxXPFhkDr0itVk6/cYcRNwfrhW7NlYRe5qHOWyYsF81l0iVsOleEEw/Asw3/ZFGzyOOKWDudHOJFQAz1JPPKAbZlNpYXcPURZgROmMrBjEnPJrN5rx7VLx7LwLe1DPmo7BS45VaquxkUlKw1mAG6yVSBOyo3D1+4GqYdI8CaAoZe2IPObqD4ux7nR8ha46734/XvdLPc5ozhyVAfYSoOAbHQY0a4qjeKtPjxlXzqnYV1/zNt6rh9EFokbiPAgMBAAECggEBAKFDVmLzzp8wFAcaKdz4PiHEU80A66s+xEVfMgxJyfVWgtipUYCKzjHJkRooXVOMZ47c14pyLNxWpHdldEvJPkzk4j9oTNRmT0lOVCkYEFEPbl+gYxghN6iZYa6Xi328h31tyDwnJ++2FekbnR2HM/jx42FDZSXxKjMs9Z+qcHvOocv7g3Fti5osDqb3PGTOtISkmGyNefMr4zjHSVZcaowfpGXKWU8NCoki/qbifECeOIl65jcQy0RGAnXwI1CGGX+bq5qxYC7fsQKVhgs/h+M5FTbAQnLYX9+Yjud9/9LFh0uAZmjNWnWJyTJP8SPYUAr1uehGvAhowH6jqVM9CLECgYEA3atzsUKnXj8/ta3f2AJz3MA52tfh4WqXsRiYlJrTNV7HZvhPRi1w452vQT5N/bET9Wnn6gHwWmhDxbTAEQaE+YmtPmDjoGk0eMU0r4V/rb9+4JRSC7mdHroBW9lFNsQHjL5kZ3Yn6wO9KAcbsc+qEqOYUvE7yQtDnwbAbuLpTT0CgYEA2iJcy5tVaPTykaU0L4JSRczbjvkVyseiW1kGLDAWQXg1D00dc9SC6R/mmKDybb7q8Cxt02a9wEPBef66p/L6b6Ux9J8fcX13dpGVy2uGgJZE9gpkmWop4MPjExSJZi2+PN2qzYxSiu+Wm5Ffsg0vooHno5PgMnuBwjLTYKjuUbsCgYAzVKiNu6mWIX9XStQy6R57V+gNzT/5Ov21fMSYZOHT0gbKyWVSEuO5UaJrsUnOHVtJ0SRrA9fsl4haF+kCCEhyoHcFotoTI0mLTd9NZdSTH2z6BF6baHgBzYDTDBUDAZHd/ZiyfKHxwgPjaQH4wuXXOxri2gnGHF2kTaPyCYmM4QKBgH/iYXDlEn/EC2oj5qJrzvwpDBeYJJSL0b2oRZwmXQXpCYJ8/WVpE47FKxYUVczNf0NraL/lnh1YG9f/5UKNixFlUhJOL8sDecRDugRWd7ZvYuK0WSIwQXkKntgS1DLZYoygkICNYd8ec7ek1Ou4G1M0wa7/BRPToNFPpukmYQH9AoGBAJJYzfpBNQvAiUGjMi9h5N40FOiCnG8K2S16N4+WZdR0Bdp2hO+Au/9OsLpyVVZGj9DfIMHlXkNmCrWnAtcNWe+1E8ja4iyInVdFcV5rCqUSGsX9aCTtun2r81o/mPBh4PTqvHZS/wc00DEg6O9AGSvvBrVHVaR3Y0zv56hTwNPw";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApLgkwQg4o7EJGi6FGofeVvrQHFxlxuEbHFedyoNXHDGeRqlURgC5Tuzb/y7osNx80Dl/8HayvznWtldvTjVgMRc+c+nlUFTzuojuiVasOcvODyKnW8umfLcPUYyu2lHWMRtzXeDy270xSJ7II/78888PhyeUUKrn2/4ZQeeuPGmgUSu7uyI1f0AVPCuzE8CBJYeql0BznzRTSHLNiMZDxKTWcBNbB6AsguuQFOQF36QnLjowpx3yOYFl5L6VFddxjZ9UV1AfH8OhS5iqUZhn9ZwEI3/gZhxzaQlb/Nn8MBEFKmHgTUu2EPBHE+D2wMALw0i2mvDU9iFjfiRvRs7nswIDAQAB";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://eep9ud.natappfree.cc/ssm/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://eep9ud.natappfree.cc/ssm/retur";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
    //https://openapi.alipaydev.com/gateway.do
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "https://openapi.alipaydev.com/gateway.do";



//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

