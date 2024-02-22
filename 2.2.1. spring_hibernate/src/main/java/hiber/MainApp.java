package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.logging.Logger;

public class MainApp {
    // Для проверки
    private static final Logger appLogger = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user_1 = new User("User1", "Lastname1", "user1@mail.ru", new Car(1, "car_1"));
        User user_2 = new User("User2", "Lastname2", "user2@mail.ru", new Car(2, "car_2"));
        User user_3 = new User("User3", "Lastname3", "user3@mail.ru", new Car(3, "car_3"));
        User user_4 = new User("User4", "Lastname4", "user4@mail.ru", new Car(4, "car_4"));

        userService.add(user_1);
        userService.add(user_2);
        userService.add(user_3);
        userService.add(user_4);

        userService.listUsers().forEach(System.out::println);

        appLogger.info("Пробую достать юзверя!");
        System.out.println(userService.takeBasedOnTheCar(1, "car_1"));
        appLogger.info("Получилось достать юзверя по серии и модели тачки.)");

        context.close();
    }
}
