package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User("Ben", "Potter", "potoir@hogwarts.com");
      User user2 = new User("Larry", "Granger", "granhr@hogwarts.com");
      User user3 = new User("Den", "Weasley", "wghyey@hogwarts.com");
      User user4 = new User("Remus", "Lupin", "lkjn@hogwarts.com");

      Car car1 = new Car("Lightning", 2021);
      Car car2 = new Car("Light", 1001);
      Car car3 = new Car("Black", 7);
      Car car4 = new Car("Porch", 290);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }
      System.out.println(userService.getUserByCar("Porch", 290));

      context.close();
   }
}
