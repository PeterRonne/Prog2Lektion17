package opgave02;

import opgave01.models.ArrayListStack;

public class Opgave02 {
    public static void main(String[] args) {
//        Lav en metode der givet en streng kan fortæller om parenteserne i strengen
//        matcher hinanden.
//        De parenteser der kan genkendes er (), {},[].
//        Følgende streng er lovlig:
//        (3+{5{99{*}}[23[{67}67]]})
//        Følgende streng er ikke lovlig:
//        (}){
//        Metoden skal have følgende signatur:

        System.out.println("checkParantes(\"(3+{5{99{*}}[23[{67}67]]})\") = " + checkParantes("(3+{5{99{*}}[23[{67}67]]})"));
        System.out.println("checkParantes(\"(}){\") = " + checkParantes("(}){"));
        System.out.println("checkParantes(\"({)}\") = " + checkParantes("({)}"));

    }

    public static boolean checkParantes(String s) {
        ArrayListStack<Character> charListStack = new ArrayListStack<>();
        char characters[] = s.toCharArray();

        for (char character : characters) {
            if (character == '(' || character == '{' || character == '[') {
                charListStack.push(character);
            }

            if (character == ')' || character == '}' || character == ']') {
                if (charListStack.isEmpty()) {
                    return false;
                }
                char top = charListStack.pop();
                if ((character == ')' && top != '(') || (character == '}' && top != '{') || (character == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return charListStack.isEmpty();
    }
}
