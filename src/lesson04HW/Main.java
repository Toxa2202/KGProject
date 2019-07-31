package lesson04HW;

import lesson04HW.Sort.SortGoodsByModel;
import lesson04HW.Sort.SortGoodsByPrice;
import lesson04HW.Sort.SortOrdersByPriceAscending;
import lesson04HW.Sort.SortOrdersByPriceDescending;
import lesson04HW.model.*;
import java.util.*;

/**
 * Created by anton.sviatov on 24.07.2019.
 */
public class Main {

    static List<Good> goods = new ArrayList<>();
    static List<Client> clients = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static List<TotalOrder> totalOrders = new ArrayList<>();
    private static String currentClientName;
    private static Integer currentClientId;
    private static String userLogin = "", userPassword = "";


    public static void main(String[] args) {
        boolean isCorrectLogin = false;
        boolean isCorrectPassword = false;
        Scanner input = new Scanner(System.in);
        initData();

//        String goodsInfo =
//                String.format("Total count of sold goods %d with price %f",
//                getCountOfSoldGoods(), getAllPriceOfSoldGoods());
//        System.out.println(goodsInfo);

        System.out.println("Welcome!" +
                "\n\t- To login as Administrator, press '1';" +
                "\n\t- To login as Client, press '2'.");
        int userInput = input.nextInt();

        if (userInput == 1) {
            adminActions(input);
        } else if (userInput == 2) {
            clientActions(isCorrectLogin, isCorrectPassword, input);
        } else {
            System.out.println("Incorrect choice. Program is close...");
        }
    }

    /** Method do actions, if Client was connect */
    private static void clientActions(boolean isCorrectLogin, boolean isCorrectPassword, Scanner input) {
        System.out.println("Client access.");

        clientSecurityCheck(isCorrectLogin, isCorrectPassword, input);
        System.out.println("\t- To view our goods, press '1';" +
                "\n\t- To Add/Remove goods from your basket, press '2';" +
                "\n\t- To make a pay, press '3';" +
                "\n\t- To EXIT, press '0'.");
        while (true){
            Integer clientChoice = input.nextInt();
            if (clientChoice == 0) {
                System.exit(1);
            }
            // choice 1
            if (clientChoice == 1) {
                /** Goods Sorting Method */
                goodsSorting(input);

                System.out.println("\t- To Add/Remove goods from your basket, press '2';" +
                        "\n\t- To make a pay, press '3'." +
                        "\n\t- To EXIT, press '0'.");

                if (clientChoice == 0) {
                    System.exit(1);
                }
                // choice 2
            } else if (clientChoice == 2) {
                System.out.println("Press '1' to Add new position, '2' to Delete position OR '0' to EXIT");
                clientChoice = input.nextInt();
                if (clientChoice == 1) {
                    System.out.println("Enter ID of position to add to wish list: ");
                    clientChoice = input.nextInt();
                    Integer lengthArray = orders.get(currentClientId).getSoldGoods().length + 1;
                    Integer[] soldGoodsNew = new Integer[lengthArray];
                    Integer[] soldGoodsOld = orders.get(currentClientId).getSoldGoods();
                    for (int i = 0; i < soldGoodsOld.length; i++) {
                        soldGoodsNew[i] = soldGoodsOld[i];
                    }
                    soldGoodsNew[soldGoodsNew.length - 1] = clientChoice;
                    // Update client order
                    orders.get(currentClientId).setSoldGoods(soldGoodsNew);
                    System.out.println("Your new wish list is: ");
                    System.out.println(getOrderDetailsByClientId(currentClientId + 1));

                } else if (clientChoice == 2) {
                    System.out.println("Your wish list is: ");
                    System.out.println(getOrderDetailsByClientId(currentClientId + 1));
                    System.out.println("Enter ID of position to remove from wish list: ");
                    while (true){
                        clientChoice = input.nextInt();
                        Integer[] soldGoodsOld = orders.get(currentClientId).getSoldGoods();
                        if (clientChoice > soldGoodsOld.length) {
                            System.out.println("Wrong ID. Try again...");
                        }
                        for (int i = 0; i < soldGoodsOld.length; i++) {
                            if (soldGoodsOld[i] == clientChoice) {
                                soldGoodsOld[i] = null;
                            }
                        }
                        break;
                    }
                    System.out.println("Your new wish list is: ");
                    System.out.println(getOrderDetailsByClientId(currentClientId));
                    System.out.println("To make payment, press '3' OR '0' to EXIT: ");

                } else if (clientChoice == 0) {
                    System.exit(1);
                }

            // choice 3
            } else if (clientChoice == 3) {
                System.out.println("Your new wish list is: ");
                System.out.println(getOrderDetailsByClientId(currentClientId));
                // From Zero...
                System.out.println(orders.get(currentClientId - 1));
                System.out.println("To make a purchase, press '1' OR '0' to EXIT: ");
                clientChoice = input.nextInt();
                if (clientChoice == 1) {
                    orders.get(currentClientId - 1).setComplete(true);
                    // From Zero...
                    System.out.println("Total price is " + getPriceOfSoldGoodsInOrder(orders.get(currentClientId - 1)));
                    System.out.println("Thank you. Have a nice day!");
                    System.out.println("To login as Administrator, press '1'" +
                            "\nTo login as Client, press '2'," +
                            "\nTo Exit, press '0': ");
                    clientChoice = input.nextInt();
                    if (clientChoice == 1) {
                        adminActions(input);
                        break;
                    } else if (clientChoice == 2) {
                        clientActions(false, false, input);
                        break;
                    } else if (clientChoice == 0) {
                        System.exit(1);
                    } else {
                        System.out.println("Wrong answer. Try again...");
                    }
                }
            }
        }
    }

    /** Method do actions, if Administrator was connect */
    private static void adminActions(Scanner input) {
        System.out.println("Administrator access. " +
                "\n\t- To see Orders, press '1';" +
                "\n\t- To change Good, press '2';" +
                "\n\t- To Exit, press '0'.");
        Integer administratorChoice = input.nextInt();
        /** Choose 1 */
        if (administratorChoice.equals(1)) {
            Boolean isCompleteOrder = false;
            System.out.println("To sort Orders by Ascending price, press '1'," +
                    "\nTo sort Orders by Descending price, press '2': ");
            int sortChoose = input.nextInt();
            if (sortChoose == 1) {
                Collections.sort(orders, new SortOrdersByPriceAscending());
            } else if (sortChoose == 2) {
                Collections.sort(orders, new SortOrdersByPriceDescending());
            }
            for (Order order : orders) {
                if (order.isComplete()){
                    isCompleteOrder = true;
                    System.out.println("Order " + (order.getId()) +
                            ". Client " + getClientNameById(order.getClientID()) +
                            ". Date of order " + order.getDateOfOrder());
                }
            }
            if (isCompleteOrder) {
                System.out.println("\nEnter the number of order For details OR '0' to Exit: ");
                Integer userInput = input.nextInt();
                while (userInput != 0) {
                    // For Exit
                    if (userInput == 0) {
                        System.exit(1);
                        // if different number of order
                    } else if (userInput > (orders.size())) {
                        System.out.println("Order does not exist! Exiting...");
                    }
                    // For get order details
                    for (Order order : orders) {
                        if (userInput.equals(order.getId())) {
                            System.out.println(getOrderDetailsByClientId(userInput));
                        }
                    }
                    System.out.println("\nTo view another order, press ID number OR '0' to Exit: ");
                    userInput = input.nextInt();
                }
            }
            System.out.println("Press '2' to Login as a Client \tOR '0' to EXIT");
            Integer userInput = input.nextInt();
            if (userInput == 2) {
                clientActions(false, false, input);
            } else if (userInput == 0) {
                System.exit(1);
            }

        /** Choose 2 */
        } else if (administratorChoice.equals(2)) {
            /** Sorting Goods Method */
            goodsSorting(input);

            System.out.println("\nTo add new position, press '1': ");
            System.out.println("To delete a position, press '2': ");
            Integer userInput = input.nextInt();

            while (userInput != 0) {

                // To add a position
                if (userInput == 1) {
                    System.out.println("Not working now. Please try again later.");
                    System.out.println("Press '2' to Login as a Client \tOR '0' to EXIT");
                    userInput = input.nextInt();
                    if (userInput == 2) {
                        clientActions(false, false, input);
                    } else if (userInput == 0) {
                        System.exit(1);
                    }
//                System.out.println("Enter new line in this order: \n" + // todo finish add to list
//                        "ID, Epson, AllInOne, 2500, 2, TypeOfGoods.PRINTER" +
//                        "\nWhere \tID - unique number of good (from 12)," +
//                        "\n\t\tEpson - name of company," +
//                        "\n\t\tAllInOne - name of good," +
//                        "\n\t\t2500 - price," +
//                        "\n\t\t2 - quantity," +
//                        "\n\t\tTypeOfGoods.PRINTER - type of device (or SMARTPHONE, MONITOR, LAPTOP.)");
//                String userCommand = input.nextLine();
//                goods.add(new Good(Arrays.asList(userCommand)));
                    System.exit(1);
                    // To delete a position
                } else if (userInput == 2) {
                    System.out.println("\nTo delete a position, enter a number of it's ID: ");
                    userInput = input.nextInt();
                    if (userInput > goods.size()) {
                        System.out.println("This ID does not exist. Exiting...");
                    } else {
                        System.out.println(goods.get(userInput - 1) + " is removed!");
                        /** Removed with ITERATOR */
                        for (Iterator<Good> iterator = goods.listIterator(); iterator.hasNext(); ) {
                            Good good = iterator.next();
                            if (good.getId().equals(userInput)) {
                                iterator.remove();
                            }
                        }
                    }
                }

                System.out.println("To see updated list of goods, press '1' OR '0' to Exit: ");
                userInput = input.nextInt();
                if (userInput == 1) {
                    for (Good good : goods) {
                        System.out.println(good);
                    }
                } else if (userInput == 0) {
                    System.exit(1);
                }
                System.out.println("To add/delete another order, press '1'/'2' OR '0' to Exit");
                userInput = input.nextInt();
            }

            System.out.println("Press '2' to Login as a Client \tOR '0' to EXIT");
            userInput = input.nextInt();
            if (userInput == 2) {
                clientActions(false, false, input);
            } else if (userInput == 0) {
                System.exit(1);
            }
        }
    }

    private static void goodsSorting(Scanner input) {
        System.out.println("To sort Goods by ID, press '1', " +
                "\nTo sort Goods by Price, press '2', " +
                "\nTo sort Goods by Model, press '3': ");
        int sortChoose = input.nextInt();
        if (sortChoose == 1) {
            for (Good good : goods) {
                System.out.println(good);
            }
        } else if (sortChoose == 2) {
            Collections.sort(goods, new SortGoodsByPrice());
            for (Good good : goods) {
                System.out.println(good);
            }
        } else if (sortChoose == 3) {
            Collections.sort(goods, new SortGoodsByModel());
            for (Good good : goods) {
                System.out.println(good);
            }
        }
    }

//    private static Order getDateOfOrder(Integer id) {
//        Order current = null;
//        for (Order order : orders) {
//            if (order.getId() == id) {
//                current = getDateOfOrder(order); // todo dateOfOrder
//            }
//        }
//    }

    /** Method return total price of goods in all orders*/
    private static Double getAllPriceOfSoldGoods() {
        Double price = 0.0;
        for (Order order : orders) {
            price += getPriceOfSoldGoodsInOrder(order);
        }
        return price;
    }

    /** Method return total price of goods in every order */
    public static Integer getPriceOfSoldGoodsInOrder(Order order) {
        Integer price = 0;
        for (Integer goodId : order.getSoldGoods()) {
            Good good = getGoodById(goodId);
            if (good != null) {
                price += good.getPrice();
            }
        }
        return price;
    }

    /** Method return number of total sold goods */
    private static int getCountOfSoldGoods() {
        int count = 0;
        for (Order order : orders) {
            count += order.getSoldGoods().length;
        }
        return count;
    }

    /** Method return order details with total price*/
    private static String getOrderDetailsByClientId(Integer id) {
        String current = "";
        Integer totalPriceInOrder = 0;
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                for (int i = 0; i < order.getSoldGoods().length; i++) {
                    current += getGoodById(order.getSoldGoods()[i])  + "\n";
                }
            }
        }
        current += "Total price in order " + getPriceOfSoldGoodsInOrder(orders.get(id - 1));
        return current;
    }

    /** Method return name of the client by ID */
    private static String getClientNameById(Integer id) {
        String current = null;
        for (Client client : clients) {
            if (client.getId() == id) {
                current = client.getName();
                break;
            }
        }
        return current;
    }

    /** Return good information by ID */
    private static Good getGoodById(Integer id) {
        Good current = null;
        for (Good good : goods) {
            if (good.getId().equals(id)) {
                current = good;
                break;
            }
        }
        return current;
    }

    /** Method checks if correct client login and password */
    private static void clientSecurityCheck(boolean isCorrectLogin, boolean isCorrectPassword, Scanner input) {
        String userLogin;
        String userPassword;
        boolean securityCheck = false;
        while (!securityCheck) {
            System.out.println("Enter your login: ");
            userLogin = input.next();
            System.out.println("Enter your password: ");
            userPassword = input.next();

            for (int i = 0; i < clients.size(); i++) {
                currentClientName = clients.get(i).getName();
                currentClientId = clients.get(i).getId();
                if (clients.get(i).getLogin().equalsIgnoreCase(userLogin) &&
                        clients.get(i).getPassword().equalsIgnoreCase(userPassword)) {
                    isCorrectLogin = true;
                    isCorrectPassword = true;
                    System.out.println("Welcome, " + currentClientName);
                    securityCheck = true;
                    break;
                }
            }

            if (!isCorrectLogin && !isCorrectPassword) {
                System.out.println("Login or password incorrect. Try again!");
            }
        }
    }

    /** Method add information to our Lists */
    public static void initData() {
        // Staff
        employees.add(new Employee(1, "Administrator", 32));
        employees.add(new Employee(2, "Client", 41));

        // Clients
        clients.add(new Client(1, "Stiven Pupkin", 30, "user", "1111"));
        clients.add(new Client(2, "Eva Pupkina", 28, "user", "2222"));
        clients.add(new Client(3, "Bob Marley", 33, "user", "3333"));
        clients.add(new Client(4, "Donald Trump", 73, "user", "4444"));
        clients.add(new Client(5, "Ivo Bobul", 67, "user", "5555"));

        // Good
        goods.add(new Good(1, "Apple", "Iphone XR", 20900, 5, TypeOfGoods.SMARTPHONE));
        goods.add(new Good(2, "Samsung", "Galaxy S10", 18900, 3, TypeOfGoods.SMARTPHONE));
        goods.add(new Good(3, "Huawei", "P30", 17900, 3, TypeOfGoods.SMARTPHONE));
        goods.add(new Good(4, "Nokia", "7 Plus", 7900, 5, TypeOfGoods.SMARTPHONE));
        goods.add(new Good(5, "LG", "Flatron", 3000, 2, TypeOfGoods.MONITOR));
        goods.add(new Good(6, "Samsung", "U Series", 3200, 3, TypeOfGoods.MONITOR));
        goods.add(new Good(7, "Siemens", "Futjitsu", 10500, 2, TypeOfGoods.LAPTOP));
        goods.add(new Good(8, "Apple", "MacBook", 19500, 2, TypeOfGoods.LAPTOP));
        goods.add(new Good(9, "Canon", "Pixma", 1600, 3, TypeOfGoods.PRINTER));
        goods.add(new Good(10, "HP", "SmartPrint", 1800, 3, TypeOfGoods.PRINTER));
        goods.add(new Good(11, "Epson", "AllInOne", 2500, 2, TypeOfGoods.PRINTER));

        // Orders
        orders.add(new Order(1, 1, "21.03.2018", new Integer[]{1, 5, 9}, false));
        orders.add(new Order(2, 2, "28.03.2019", new Integer[]{2, 3, 7, 10}, false));
        orders.add(new Order(3, 3, "30.02.2019", new Integer[]{1, 4, 8}, false));
        orders.add(new Order(4, 4, "15.04.2018", new Integer[]{4, 4}, false));
        orders.add(new Order(5, 5, "07.01.2019", new Integer[]{6, 9, 11}, false));

    }
}

// Зробити інтернет магазин, товар, каса, юзери можуть шось купити.
// Товар має мати свою кількість і зменшується при купівлі.
// Можна подивитись шо купили юзери. Має бути адмін. Все через консоль