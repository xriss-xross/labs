public class VGather {
    public static void main(String args[]) {
        System.out.print("How Many Students in Class?\n");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();
        Student[] studentArray = new Student[n];
        
        for (int i = 0; i < n; i++) {
            studentArray[i] = new Student();
            System.out.print("Enter a grade:\n");
            int grade = scanner.nextInt();
            studentArray[i].updateGrade(grade);
        }

        scanner.close();

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += studentArray[i].getGrade();
        }

        double average = sum / n;
        
        // have to do 100.0 because otherwise it turns into an int???
        average = Math.round(average * 100.0)/100.0;  
        System.out.println(average);
    }
}
