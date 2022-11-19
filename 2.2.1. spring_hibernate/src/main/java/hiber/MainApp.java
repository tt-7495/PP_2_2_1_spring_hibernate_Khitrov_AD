package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Anatolii", "Khitrov", "tt-7495@mail.ru", new Car("Mersedes-beng", 220)));
      userService.add(new User("Alexandr", "Russkin", "Russkin163@mail.ru", new Car("BMW", 7)));
      userService.add(new User("Ivan", "Ivanov", "Ivanov777@mail.ru", new Car("Lada", 5)));
      userService.add(new User("Dmitrii", "Medvedev", "Medvedev@mail.ru", new Car("Lada", 2110)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Model = " + user.getCar().getModel());
         System.out.println("Series = " + user.getCar().getSeries());
         System.out.println();
      }

      List<User> users2 = userService.getUserByCar("Mersedes-beng", 220);
      for (User user : users2) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
