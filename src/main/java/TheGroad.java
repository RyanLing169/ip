import java.util.Scanner;

public class TheGroad {
    public static void main(String[] args) {
        String line = "________________________________________________________\n" ;
        String greeting = "____________________________________________________________\n"+
                "Hello! I'm THE GROAD \n" +
                "What can I do for you?\n" +
                "____________________________________________________________";
        String bye = "    Bye. Hope to see you again soon!\n";
        String indent = "    ";
        System.out.println(greeting);
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            String input = scanner.nextLine();
            if (input.equals("bye"))
            {
                System.out.println(indent + line + bye + indent + line);
                break;
            }
            else
            {
                System.out.println(indent + line + indent + input + "\n" + indent + line);
            }
        }

    }
}
