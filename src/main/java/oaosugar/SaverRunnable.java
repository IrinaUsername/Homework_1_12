package oaosugar;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaverRunnable implements Runnable{
    private Car car;
    private String path;

    public SaverRunnable(Car car, String path){
        this.car=car;
        this.path=path;
    }
    @Override
    public void run(){
        if(this.path != null && car!= null){
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(this.path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(car);
                oos.close();
                System.out.println("Сериализация объекта Автомобиль прошла успешно. Путь файла: "+path);
            } catch (IOException ex){
                System.out.println("Ошибка сохранения объекта по указанному пути: "+this.path);
            }
        }
    }
}
