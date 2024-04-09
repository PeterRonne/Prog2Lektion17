package opgave03;

import opgave03.models.DropOutStack;

public class Opgave03 {
    public static void main(String[] args) {
        DropOutStack<String> stringsStack = new DropOutStack<>(10);


        stringsStack.push("level 1");
        stringsStack.push("level 2");
        stringsStack.push("level 3");
        stringsStack.push("level 4");
        stringsStack.push("level 5");
        stringsStack.push("level 6");
        stringsStack.push("level 7");
        stringsStack.push("level 8");
        stringsStack.push("level 9");
        stringsStack.push("level 10");
        stringsStack.push("level 11");
        stringsStack.push("level 12");
        stringsStack.pop();
        stringsStack.pop();
        stringsStack.pop();

        stringsStack.push("level 10");
        stringsStack.push("level 11");
        stringsStack.push("level 11");
        stringsStack.push("level 13");
        stringsStack.push("level 14");


        System.out.println("Size: " + stringsStack.size());
        System.out.println();


        stringsStack.printStack();

    }
}
