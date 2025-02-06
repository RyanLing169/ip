import java.util.Scanner;

public class TheGroad {
    public static void main(String[] args) {
        String line = "________________________________________________________" ;
        String greeting = line + "____\n"+
                "Hello! I'm THE GROAD \n" +
                "What can I do for you?\n" +
                line + "____";
        String bye = "    Bye. Hope to see you again soon!\n";
        String indent = "    ";
        System.out.println(greeting);
        Scanner scanner = new Scanner(System.in);
        String[] list = new String[100];
        int j = 0;

        while (true)
        {
            String input = scanner.nextLine();
            if (input.equals("bye"))
            {
                System.out.println(indent + line +"\n" + bye + indent + line);
                break;
            }
            if (input.equals("list"))
            {
                System.out.println(indent + line);
                for (int i = 0 ; i < j ; i += 1)
                {
                    System.out.println(indent + (i + 1) + ". " + list[i] );
                }
                System.out.println(indent + line);
            }
            else
            {
                System.out.println(indent + line + "\n" + indent + "added: " + input + "\n" + indent + line);
                list[j] = input;
                j += 1;
            }
        }

    }
}
