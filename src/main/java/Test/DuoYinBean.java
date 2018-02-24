package main.java.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;


/**
 * @ClassName: DuoYinUtil
 * @Description: 加载多音字库
 * @author _guobin
 * @date 2016年9月1日 上午1:47:11
 */
public class DuoYinBean {

	private Resource resource; // 资源文件
	public static Map<String, List<String>> duoyinMap;// 多音字map集合
	
	public void _init(){
		try {
			duoyinMap = initPinyin(resource.getFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: DuoYinBean
	 * @Description: 初始化 所有的多音字词组 
	 * @author _guobin
	 * @date 2016年9月1日 上午3:06:25
	 * @param file
	 * @return
	 */
    public static Map<String, List<String>> initPinyin(File file) {  
    	Map<String, List<String>> pinyinMap = new HashMap<String, List<String>>();  
        // 读取多音字的全部拼音表;  
    	InputStreamReader read = null;
		BufferedReader br = null;
		try {
			//考虑到编码格式
			read = new InputStreamReader(new FileInputStream(file), "UTF-8");
			br = new BufferedReader(read);
		}catch (Exception e) {
			e.printStackTrace();
		}
        String s = null;  
        try {  
            while ((s = br.readLine()) != null) {  
                if (s != null) {  
                    String[] arr = s.split("#");  
                    String pinyin = arr[0];  
                    String chinese = arr[1];  
  
                    if(chinese!=null){  
                        String[] strs = chinese.split(" ");  
                        List<String> list = Arrays.asList(strs);  
                        pinyinMap.put(pinyin, list);  
                    }  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
            	br.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return pinyinMap;
    }  
    
	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
