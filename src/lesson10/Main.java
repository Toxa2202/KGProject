package lesson10;

import com.sun.beans.finder.FieldFinder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by anton.sviatov on 19.08.2019.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Person person = new Person("David", 22);
        // Reflection starts here
        Class classPerson = person.getClass();
        System.out.println(classPerson.getName());
        System.out.println(classPerson.getSuperclass().getName());
        // Get list of interfaces
        for (Class interfaces: classPerson.getInterfaces()) {
            System.out.println(interfaces.getName());
        }

        // Does not have access to fields
        for (Field field: classPerson.getFields()) {
            System.out.println(field.getType() + " " + field.getName() + " " + field.get(person));
        }

        // Has access to fields
        for (Field field: classPerson.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getType() + " " + field.getName() + " " + field.get(person));
        }

        // Порушили інкапсуляцію. Переписали на Остапа ім"я
        System.out.println(person);
        Field field = classPerson.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person, "Ostap");

        System.out.println(person);


        // get count of constructors
        for (Constructor constructor : classPerson.getConstructors()) {
            System.out.println(constructor.getParameterCount());

            for (Parameter parameter : constructor.getParameters()) {
                System.out.println(parameter.getType() + " " + parameter.getName());

            }
        }

        for (Method method : classPerson.getMethods()) {
            System.out.println(method.getName());
            for (Parameter parameter : method.getParameters()) {
                System.out.println(parameter.getType() + " " + parameter.getName());
            }
        }


        /* Multithreading starts */
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new MyRunnable());
        thread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main -> " + i);
        }
    }
}

// GetFields see only public lines
// multithreading - from cores of processor
// Пріоритет запуску залежить від консолі. Вона сама вибирає який потік запускаєтсья першим.
// Biggest problem is synchronization

// HW
// В одному потоці секундомір
// В іншому потоці алгоритм - вирахувати прості числа