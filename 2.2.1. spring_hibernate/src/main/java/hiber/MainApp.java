package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class MainApp {
    private static final Logger appLogger = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user_1 = new User("User1", "Lastname1", "user1@mail.ru");
        user_1.setCar(new Car(1, "car_1"));
        User user_2 = new User("User2", "Lastname2", "user2@mail.ru");
        user_2.setCar(new Car(2, "car_2"));
        User user_3 = new User("User3", "Lastname3", "user3@mail.ru");
        user_3.setCar(new Car(3, "car_3"));
        User user_4 = new User("User4", "Lastname4", "user4@mail.ru");
        user_4.setCar(new Car(4, "car_4"));

        userService.add(user_1);
        userService.add(user_2);
        userService.add(user_3);
        userService.add(user_4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }


        appLogger.info("Пробую достать юзверя!");
        System.out.println(userService.takeBasedOnTheCar(1, "car_1"));
        appLogger.info("Получилось достать юзверя по серии и модели тачки.)");

        context.close();
    }
}
