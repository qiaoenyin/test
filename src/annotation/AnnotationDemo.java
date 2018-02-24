package annotation;

public class AnnotationDemo {
	@MyTag(name = "audi11111", size = 10)  
    private Car car;  
  
    public Car getCar() {  
        return car;  
    }  
  
    public void setCar(Car car) {  
        this.car = car;  
    }  
  
    @Override  
    public String toString() {  
        return "Annotation [car=" + car + "]";  
    }  
}
