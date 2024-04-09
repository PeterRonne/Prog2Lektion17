package opgave03;

import opgave03.models.DropOutStack;

public class Opgave03 {
    public static void main(String[] args) {
        DropOutStack<String> stringsStack = new DropOutStack<>(10);

        stringsStack.push("bottom");
        stringsStack.push("middle");
        stringsStack.push("top");

        stringsStack.pop();
        stringsStack.pop();

        stringsStack.printStack();

    }
}
