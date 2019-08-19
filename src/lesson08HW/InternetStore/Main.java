package lesson08HW.InternetStore;

import lesson08HW.InternetStore.Sort.SortGoodsByModel;
import lesson08HW.InternetStore.Sort.SortGoodsByPrice;
import lesson08HW.InternetStore.Sort.SortOrdersByPriceAscending;
import lesson08HW.InternetStore.Sort.SortOrdersByPriceDescending;
import lesson08HW.InternetStore.model.*;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by anton.sviatov on 24.07.2019.
 */
public class Main {

    static List<Good> goods = new ArrayList<>();
    static List<Client> clients = new ArrayList<>();
    static List<Employee> employees = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    static List<TotalOrder> totalOrders = new ArrayList<>();
    public static Map<Integer, Order> clientBasket = new HashMap<>();

    static List<Object> clientsFromFile = new ArrayList<>();
    static List<Object> ordersFromFile = new ArrayList<>();
    static List<Object> goodsFromFile = new ArrayList<>();
    static Map<Integer, Order> orderMap = new HashMap<>();

    private static String currentClientName;
    private static Integer currentClientId;
    private static String userLogin = "", userPassword = "";
    private static int userInput;

    /** Main method */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean isCorrectLogin = false;
        boolean isCorrectPassword = false;
        Scanner input = new Scanner(System.in);

        /* ------------------DATA INITIALIZATION ----------------*/
        initData();
        readFilesInit();
        saveFileInit();

        // Test read from file
        clientsFromFile.stream().forEach(System.out::println);

        /* --------------- MENU Start Point --------------------*/
        do {
            System.out.println("Welcome!" +
                    "\n\t- To login as Administrator, press '1';" +
                    "\n\t- To login as Client, press '2'.");
            userInput = input.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("Option '1' selected.");
                    adminActions(input);
                    break;
                case 2:
                    System.out.println("Option '2' selected.");
                    clientActions(isCorrectLogin, isCorrectPassword, input);
                    break;
            }
        } while (userInput == 1 || userInput == 2);

        System.out.println("Incorrect choice. Program is closing...");
    }

    /** Method operate with actions, if Client was connect ------------------------*/
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
                /* Goods Sorting Method */
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

                    // Add new position to the client order (Integer position --> -1)
                    Integer lengthArray = clientBasket.get(currentClientId).getSoldGoods().length + 1;
                    Integer[] soldGoodsNew = new Integer[lengthArray];
                    Integer[] soldGoodsOld = clientBasket.get(currentClientId).getSoldGoods();
                    System.arraycopy(soldGoodsOld, 0, soldGoodsNew, 0, soldGoodsOld.length);
                    soldGoodsNew[soldGoodsNew.length - 1] = clientChoice;
                    // Update client order
                    clientBasket.get(currentClientId).setSoldGoods(soldGoodsNew);
                    System.out.println("Your new wish list is: ");
                    System.out.println(getOrderDetailsByClientId(currentClientId));

                } else if (clientChoice == 2) {
                    System.out.println("Your wish list is: ");
                    System.out.println(getOrderDetailsByClientId(currentClientId));
                    System.out.println("Enter ID of position to remove from wish list: ");
                    while (true){
                        clientChoice = input.nextInt();
                        Integer[] soldGoodsOld = clientBasket.get(currentClientId).getSoldGoods();
                        if (clientChoice > soldGoodsOld.length) {
                            System.out.println("Wrong ID. Try again...");
                        }
                        for (int i = 0; i < soldGoodsOld.length; i++) {
                            if (soldGoodsOld[i] == clientChoice) {
                                soldGoodsOld[i] = null;
                                clientBasket.remove(soldGoodsOld[i]);
                            }
                        }
                        break;
                    }
                    System.out.println("Your new wish list is: ");
                    System.out.println(getOrderDetailsByClientId(currentClientId));
                    System.out.println("- To Add new position, press '1';" +
                                        "\n- To Delete position, Press '2';" +
                                        "\n- To make payment, press '3' OR '0' to EXIT: ");

                } else if (clientChoice == 0) {
                    System.exit(1);
                }

                // choice 3
            } else if (clientChoice == 3) {
                System.out.println("Your new wish list is: ");
                System.out.println(getOrderDetailsByClientId(currentClientId));
                // From Zero...
                System.out.println(clientBasket.get(currentClientId));
                System.out.println("To make a purchase, press '1' OR '0' to EXIT: ");
                clientChoice = input.nextInt();
                if (clientChoice == 1) {
                    clientBasket.get(currentClientId).setComplete(true);
                    // From Zero...
                    System.out.println("Total price is " + getPriceOfSoldGoodsInOrder(clientBasket.get(currentClientId)));
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

    /** Method operate with actions, if Administrator was connect --------------------------*/
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
//                List list = new ArrayList(clientBasket.entrySet());
//                Collections.sort(list, new Comparator<Map.Entry<Integer, Order>>() {
//                    @Override
//                    public int compare(Map.Entry<Integer, Order> o1, Map.Entry<Integer, Order> o2) {
//                        return o1.getValue() - o2.getValue();
//                    }
//                });
                Collections.sort(orders, new SortOrdersByPriceAscending());
            } else if (sortChoose == 2) {
                Collections.sort(orders, new SortOrdersByPriceDescending());
            }
            for (Order order : clientBasket.values()) {
                if (order.isComplete()) {
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
                    } else if (userInput > (clientBasket.size())) {
                        System.out.println("Order does not exist! Try again...");
                    }
                    // For get order details
                    for (Order order : clientBasket.values()) {
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

                    // To delete a position
                } else if (userInput == 2) {
                    System.out.println("\nTo delete a position, enter a number of it's ID: ");
                    userInput = input.nextInt();
                    if (userInput > goods.size()) {
                        System.out.println("This ID does not exist. Exiting...");
                    } else {
                        System.out.println(getGoodById(userInput) + " is removed!");
                        /** Removed with ITERATOR */
                        for (Iterator<Good> iterator = goods.listIterator(); iterator.hasNext();) {
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
                    goods.forEach(System.out::println);
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
            goods.forEach(System.out::println);
        } else if (sortChoose == 2) {
            goods.sort(new SortGoodsByPrice());
            goods.forEach(System.out::println);
        } else if (sortChoose == 3) {
            goods.sort(new SortGoodsByModel());
            goods.forEach(System.out::println);
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

    /**
     * Method return total price of goods in all orders
     */
    private static Double getAllPriceOfSoldGoods() {
        Double price = 0.0;
        for (Order order : clientBasket.values()) {
            price += getPriceOfSoldGoodsInOrder(order);
        }
        return price;
    }

    /**
     * Method return total price of goods in every order
     */
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

    /**
     * Method return number of total sold goods
     */
    private static int getCountOfSoldGoods() {
        return clientBasket.values().stream().mapToInt(order -> order.getSoldGoods().length).sum();
    }

    /**
     * Method return order details with total price
     */
    private static String getOrderDetailsByClientId(Integer id) {
        StringBuilder current = new StringBuilder();
        Integer totalPriceInOrder = 0;
        clientBasket.values().stream().filter(order -> order.getId().equals(id)).
                forEach(order -> IntStream.range(0, order.getSoldGoods().length)
                .forEach(i -> current.append(getGoodById(order.getSoldGoods()[i])).append("\n")));
        current.append("Total price in order ").append(getPriceOfSoldGoodsInOrder(clientBasket.get(id)));
        return current.toString();
    }

    /**
     * Method return name of the client by ID
     */
    private static String getClientNameById(Integer id) {
        return clients.stream().filter(client ->
                client.getId().equals(id)).findFirst().map(Person::getName).orElse(null);
    }

    /**
     * Return good information by ID
     */
    private static Good getGoodById(Integer id) {
        return goods.stream().filter(good -> good.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Method checks if correct client login and password
     */
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

    /**
     * Method add information to our Lists
     */
    public static void initData() {
        // Staff

        // make read from file
        employees.add(new Employee(1, "Administrator", 32));
        employees.add(new Employee(2, "Client", 41));

        // Clients List
        clients.add(new Client(1, "Stiven Pupkin", 30, "user", "1111"));
        clients.add(new Client(2, "Eva Pupkina", 28, "user", "2222"));
        clients.add(new Client(3, "Bob Marley", 33, "user", "3333"));
        clients.add(new Client(4, "Donald Trump", 73, "user", "4444"));
        clients.add(new Client(5, "Ivo Bobul", 67, "user", "5555"));

        // Good List
        goods.add(new Good(1, "Apple", "Iphone XR", 20900, 5, TypeOfGoods.SMARTPHONE));
        goods.add(new Good(2, "Samsung", "Galaxy S10", 18900, 3, TypeOfGoods.SMARTPHONE));
        goods.add(new Good(3, "Huawei", "P30", 17900, 3, TypeOfGoods.SMARTPHONE));
        goods.add(new Good(4, "Nokia", "7 Plus", 7900, 5, TypeOfGoods.SMARTPHONE));
        goods.add(new Good(5, "LG", "Flatron", 3000, 2, TypeOfGoods.MONITOR));
        goods.add(new Good(6, "Samsung", "U Series", 3200, 3, TypeOfGoods.MONITOR));
        goods.add(new Good(7, "Siemens", "Fujitsu", 10500, 2, TypeOfGoods.LAPTOP));
        goods.add(new Good(8, "Apple", "MacBook", 19500, 2, TypeOfGoods.LAPTOP));
        goods.add(new Good(9, "Canon", "Pixma", 1600, 3, TypeOfGoods.PRINTER));
        goods.add(new Good(10, "HP", "SmartPrint", 1800, 3, TypeOfGoods.PRINTER));
        goods.add(new Good(11, "Epson", "AllInOne", 2500, 2, TypeOfGoods.PRINTER));

        // Orders Map
        clientBasket.put(1, new Order(1, 1, "21.03.2018", new Integer[]{1, 5, 9}, false));
        clientBasket.put(2, new Order(2, 2, "28.03.2019", new Integer[]{2, 3, 7, 10}, false));
        clientBasket.put(3, new Order(3, 3, "30.03.2019", new Integer[]{1, 4, 8}, false));
        clientBasket.put(4, new Order(4, 4, "15.04.2018", new Integer[]{4, 4}, false));
        clientBasket.put(5, new Order(5, 5, "07.01.2019", new Integer[]{6, 9, 11}, false));

    }

    private static void saveFileInit() throws IOException {
        saveDataToFile(orders, "orders");
        saveDataToFile(clients, "clients");
        saveDataToFile(goods, "goods");
        saveDataToFile(clientBasket, "clientBasket");
    }

    private static void readFilesInit() throws IOException, ClassNotFoundException {
        orderMap = readMapFromFile("clientBasket");
        goodsFromFile.add(readDataFromFile("goods"));
        clientsFromFile.add(readDataFromFile("clients"));
        ordersFromFile.add(readDataFromFile("clients"));
    }

    /** Save to File */
    public static void saveDataToFile(Object o, String fileName) throws IOException {
        File tempFile = new File("src/lesson08HW/InternetStore/" + fileName + ".dat");
        if (!tempFile.exists()) {
            File file = new File("src/lesson08HW/InternetStore/" + fileName + ".dat");
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(o);
            output.close();
        } else {
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("src/lesson08HW/InternetStore/" + fileName + ".dat"));
            output.writeObject(o);
            output.close();
        }
    }

    /** Read from File */
    public static List<Object> readDataFromFile(String fileName) throws IOException, ClassNotFoundException {
        File file = new File("src/lesson08HW/InternetStore/" + fileName + ".dat");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        clientsFromFile = (List<Object>) input.readObject();
        input.close();

        return clientsFromFile;

        /** Незавершений метод. Ідея - всі дані закидати в окремі файли, а потім
         * зчитувати назад з них в відповідні нові лісти/мапи... */
    }

    /** Read from File */
    public static Map<Integer, Order> readMapFromFile(String fileName) throws IOException, ClassNotFoundException {
        File file = new File("src/lesson08HW/InternetStore/" + fileName + ".dat");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        orderMap = (Map<Integer, Order>) input.readObject();
        input.close();

        return orderMap;
    }
}

// HomeWork04
// Зробити інтернет магазин, товар, каса, юзери можуть шось купити.
// Товар має мати свою кількість і зменшується при купівлі.
// Можна подивитись шо купили юзери. Має бути адмін. Все через консоль

/**
 * HomeWork06  Перебудувати консольний магазин таким чином, щоб в кожного користувача був свій кошик
 * і кожен був пов"язаний з власним кошиком через мапу і весь функціонал зберігся
 */

// transient - to not serializating object. Обмежити видачу якихось даних. Позначаємо об"єкт трансіант -
// і він не показуєтсья при видачі.

