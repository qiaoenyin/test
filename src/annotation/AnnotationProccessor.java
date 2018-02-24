package annotation;

import java.lang.reflect.Field;

public class AnnotationProccessor {
	public  static void annoProcess(AnnotationDemo annotation){  
        for(Field field : annotation.getClass().getDeclaredFields()){  
            if(field.isAnnotationPresent(MyTag.class)){  //如果存在MyTag标签  
                MyTag myTag = field.getAnnotation(MyTag.class);
                System.out.println("=====name======="+myTag.name());
                System.out.println("=====size======"+myTag.size());
                annotation.setCar(new Car(myTag.name(),myTag.size()));  
            }  
        }  
    } 
	
	 public static void main(String[] args) {  
        AnnotationDemo ann = new AnnotationDemo();  
        annoProcess(ann);  
        System.out.println("================"+ann.getCar());  
    }  
}
