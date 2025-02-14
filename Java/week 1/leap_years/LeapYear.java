public class LeapYear {
  public static void main(String[] args) {
    int year = Integer.parseInt(args[0]);

    boolean leapYear = false; // Your code here

    if (year % 400 == 0) {
      leapYear = true;
    } else if (year % 4 == 0 && year % 100 != 0) {
      leapYear = true;
    }

    // output
    System.out.println(leapYear);
  }
}
