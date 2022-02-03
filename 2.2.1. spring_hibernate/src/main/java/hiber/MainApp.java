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
      User userI = new User("User1", "Lastname1", "user1@mail.ru");
      userI.setCar(new Car("Car.I",1));
      User userII = new User("User2", "Lastname2", "user2@mail.ru");
      userII.setCar(new Car("Car.II",2));
      User userIII = new User("User3", "Lastname3", "user3@mail.ru");
      userIII.setCar(new Car("Car.III",3));
      User userIV = new User("User4", "Lastname4", "user4@mail.ru");
      userIV.setCar(new Car("Car.IV",4));

      userService.add(userI);
      userService.add(userII);
      userService.add(userIII);
      userService.add(userIV);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }
//      System.out.println(userService.findUserByCar("Car.IV",4));
      context.close();
   }
}
