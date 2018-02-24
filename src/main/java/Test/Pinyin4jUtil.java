package main.java.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;



/**
 * @ClassName: Pinyin4jUtil 
 * @Description: 汉字拼音码转换
 * @author _guobin
 * @date 2016年9月1日 上午12:03:45
 */
public class Pinyin4jUtil {  
	 
	/**
	 * @Title: Pinyin4jUtil
	 * @Description: 获取中文汉字拼音 默认输出 
	 * @author _guobin
	 * @date 2016年9月1日 上午12:04:30
	 * @param chinese
	 * @return
	 */
    public static String getPinyin(String chinese) {  
        return convertChineseToPinyin(chinese);  
    }  
  
    /**
     * @Title: Pinyin4jUtil
     * @Description: 拼音大写输出
     * @author _guobin
     * @date 2016年9月1日 上午12:04:54
     * @param chinese
     * @return
     */
    public static String getPinyinToUpperCase(String chinese) {  
        return convertChineseToPinyin(chinese).toUpperCase();  
    }  
  
    /**
     * @Title: Pinyin4jUtil
     * @Description: 拼音小写输出 
     * @author _guobin
     * @date 2016年9月1日 上午12:05:04
     * @param chinese
     * @return
     */
    public static String getPinyinToLowerCase(String chinese) {  
        return convertChineseToPinyin(chinese).toLowerCase();  
    }  
  
    /**
     * @Title: Pinyin4jUtil
     * @Description: 首字母大写输出 
     * @author _guobin
     * @date 2016年9月1日 上午12:05:20
     * @param chinese
     * @return
     */
    public static String getPinyinFirstToUpperCase(String chinese) {  
        return getPinyin(chinese);  
    }  
  
    /** 
     * @Title: Pinyin4jUtil
     * @Description: 拼音简拼输出 
     * @author _guobin
     * @date 2016年9月1日 上午12:05:33
     * @param chinese
     * @return
     */
    public static String getPinyinJianPin(String chinese) {  
        return getPinyinConvertJianPin(getPinyin(chinese));  
    }  
  
  
    /**
     * @Title: Pinyin4jUtil
     * @Description: Default Format 默认输出格式 
     * @author _guobin
     * @date 2016年9月1日 上午12:06:45
     * @return
     */
    private static HanyuPinyinOutputFormat getDefaultOutputFormat() {  
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();  
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写  
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 没有音调数字  
        format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);// u显示  
        return format;  
    }  
  
    /**
     * @Title: Pinyin4jUtil
     * @Description: 获取每个拼音的简称 
     * @author _guobin
     * @date 2016年9月1日 上午12:08:38
     * @param chinese
     * @return
     */
    private static String getPinyinConvertJianPin(String chinese) {  
        String strChar = "";  
        char arr[] = chinese.toCharArray(); // 将字符串转化成char型数组  
        for (int i = 0; i < arr.length; i++) {  
        	if (arr[i] < 97 || arr[i] > 122) { // 判断是否是小写字母 ,非小写字母则直接输出 
                strChar += new String(arr[i] + "");  
            }  
        }  
        return strChar; 
    }  
    
    /** 
     * @Title: Pinyin4jUtil
     * @Description: 将某个字符串的首字母 大写 
     * @author _guobin
     * @date 2016年9月1日 上午1:10:18
     * @param str
     * @return
     */
    public static String convertInitialToUpperCase(String str){  
        if(str==null){  
            return null;  
        }  
        StringBuffer sb = new StringBuffer();  
        char[] arr = str.toCharArray();  
        for(int i=0;i<arr.length;i++){  
            char ch = arr[i];  
            if(i==0){  
                sb.append(String.valueOf(ch).toUpperCase());  
            }else{  
                sb.append(ch);  
            }  
        }  
          
        return sb.toString();  
    }  
    
    /**
     * @Title: Pinyin4jUtil
     * @Description: 汉字转拼音 最大匹配优先 
     * @author _guobin
     * @date 2016年9月1日 上午1:10:05
     * @param chinese
     * @return
     */
    private static String convertChineseToPinyin(String chinese) {
    	if (chinese == null) {
			return null;
		}
        StringBuffer pinyin = new StringBuffer();  
        char[] arr = chinese.toCharArray();  
        for (int i = 0; i < arr.length; i++) {  
            char ch = arr[i];  
            if (ch > 128) { // 非ASCII码  
                // 取得当前汉字的所有全拼  
                try {  
                    String[] results = PinyinHelper.toHanyuPinyinStringArray(ch, getDefaultOutputFormat());  
                    if (results == null) {  //非中文  
                        return "";  
                    } else {  
                        int len = results.length;  
                        if (len == 0) {//未取到
                        	 continue;  
						}
                        if (len == 1) { // 不是多音字  
                            String py = results[0];       
                            if(py.contains("u:")){  //过滤 u:  
                                py = py.replace("u:", "v");  
                            }  
                            pinyin.append(convertInitialToUpperCase(py));  
                        }else if(results[0].equals(results[1])){    //非多音字 有多个音，取第一个  
                            pinyin.append(convertInitialToUpperCase(results[0]));  
                        }else { // 多音字  
                            int length = chinese.length();  
                            boolean flag = false;  
                            String s = null;  
                            List<String> keyList =null;  
                            for (int x = 0; x < len; x++) {  
                                String py = results[x];  
                                if(py.contains("u:")){  //过滤 u:  
                                    py = py.replace("u:", "v");  
                                }  
                                keyList = DuoYinBean.duoyinMap.get(py);  
                                if (i + 3 <= length) {   //后向匹配2个汉字  大西洋   
                                    s = chinese.substring(i, i + 3);  
                                    if (keyList != null && (keyList.contains(s))) {  
                                        pinyin.append(convertInitialToUpperCase(py));  
                                        flag = true;  
                                        break;  
                                    }  
                                }  
                                
                                if (i + 2 <= length) {   //后向匹配 1个汉字  大西  
                                    s = chinese.substring(i, i + 2);  
                                    if (keyList != null && (keyList.contains(s))) {  
                                        pinyin.append(convertInitialToUpperCase(py));  
                                        flag = true;  
                                        break;  
                                    }  
                                }  
                                
                                if ((i - 2 >= 0) && (i+1<=length)) {  // 前向匹配2个汉字 龙固大  
                                    s = chinese.substring(i - 2, i+1);  
                                    if (keyList != null && (keyList.contains(s))) {  
                                        pinyin.append(convertInitialToUpperCase(py));  
                                        flag = true;  
                                        break;  
                                    }  
                                }  
                                  
                                if ((i - 1 >= 0) && (i+1<=length)) {  // 前向匹配1个汉字   固大  
                                    s = chinese.substring(i - 1, i+1);  
                                    if (keyList != null && (keyList.contains(s))) {  
                                        pinyin.append(convertInitialToUpperCase(py));  
                                        flag = true;  
                                        break;  
                                    }  
                                }  
                                  
                                if ((i - 1 >= 0) && (i+2<=length)) {  //前向1个，后向1个      固大西  
                                    s = chinese.substring(i - 1, i+2);  
                                    if (keyList != null && (keyList.contains(s))) {  
                                        pinyin.append(convertInitialToUpperCase(py));  
                                        flag = true;  
                                        break;  
                                    }  
                                }  
                            }  
                            //都没有找到，匹配默认的 读音  大     
                            if (!flag) {    
                                s = String.valueOf(ch);  
                                for (int x = 0; x < len; x++) {  
                                    String py = results[x];  
                                    if(py.contains("u:")){  //过滤 u:  
                                        py = py.replace("u:", "v");  
                                    }  
                                    keyList = DuoYinBean.duoyinMap.get(py);  
                                    if (keyList != null && (keyList.contains(s))) {  
                                        pinyin.append(convertInitialToUpperCase(py));//拼音首字母 大写  
                                        break;  
                                    }  
                                }  
                            }  
                        }  
                    }  
  
                } catch (BadHanyuPinyinOutputFormatCombination e) {  
                    e.printStackTrace();  
                }  
            } else {  
                pinyin.append(convertInitialToUpperCase(String.valueOf(arr[i])));  
            }  
        }  
        return pinyin.toString();  
    }  
  
    /**
     * 获取首字母
     * @Title: Pinyin4jUtil
     * @author qiaoenyin
     * @date 2017年10月24日 下午5:09:27
     * @param chines
     * @return
     */
    public static String getFirstAlpha(String chines) {
        chines = cleanChar(chines);
        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName.substring(0, 1);
    }
    
    public static String cleanChar(String chines) {
        chines = chines.replaceAll("[\\p{Punct}\\p{Space}]+", ""); // 正则去掉所有字符操作
        // 正则表达式去掉所有中文的特殊符号
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}<>《》【】‘；：”“’。，、？]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(chines);
        chines = matcher.replaceAll("").trim();
        return chines;
    }
    /**
     * Test 测试输出 
     */
    public static void main(String[] args) {  
    	String str = "阿玛尼";  
        //System.out.println("小写输出：" + getPinyinToLowerCase(str));  
        //System.out.println("大写输出：" + getPinyinToUpperCase(str));  
        //System.out.println("首字母大写输出：" + getPinyinFirstToUpperCase(str));  
        //System.out.println("全拼输出：" + getPinyin(str)); 
        //System.out.println("简拼输出：" + getPinyinJianPin(str)); 
        System.out.println("首字母大写输出："+ getFirstAlpha(str));
    }  
} 