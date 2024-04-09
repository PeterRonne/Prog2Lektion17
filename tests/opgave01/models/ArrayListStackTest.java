package opgave01.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListStackTest {

    StackEaaa<String> sut;

    @BeforeEach
    void initialize() {
        sut = new ArrayListStack<>();
    }

    @Test
    @DisplayName("Push to an empty stack")
    void pushToEmptyStack() {
        //Arrange
        //Act
        sut.push("Test");
        //Assert
        assertEquals(1, sut.size());
        String actual = sut.pop();
        assertEquals("Test", actual);
        assertEquals(0, sut.size());
    }

    @Test
    @DisplayName("Push several elements to stack")
    void pushToStack() {
        //Arrange
        //Act
        sut.push("Test 01");
        sut.push("Test 02");
        //Assert
        assertEquals(2, sut.size());
        String actual = sut.pop();
        assertEquals("Test 02", actual);
    }

    @Test
    @DisplayName("Pop on an empty stack should throw an exception")
    void popEmptyStack() {
        //Arrange
        //Act/Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> sut.pop());
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Peek returns top element")
    void peek() {
        //Arrange
        //Act
        sut.push("Test 01");
        sut.push("Test 02");
        //Assert
        String actual = sut.peek();
        assertEquals("Test 02", actual);
        assertEquals(2, sut.size());
    }

    @Test
    @DisplayName("Peek on empty Stack")
    void peekEmptyStack() {
        //Arrange
        //Act - Assert
        Exception exception = assertThrows(NoSuchElementException.class, () -> sut.peek());
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void isEmpty() {
        //Arrange
        //Act
        boolean actual = sut.isEmpty();
        //Assert
        assertTrue(actual);
        sut.push("Test");
        actual = sut.isEmpty();
        assertFalse(actual);

    }

    @Test
    void clear() {
        //Arrange
        sut.push("Test");
        //Act
        sut.clear();
        //Assert
        assertEquals(0, sut.size());
        assertThrows(NoSuchElementException.class, () -> sut.pop());
    }

    @Test
    void size() {
        //Arrange
        //Assert
        assertEquals(0, sut.size());
        //Act
        sut.push("Test");
        //Assert
        assertEquals(1, sut.size());
        //Act
        sut.pop();
        assertEquals(0, sut.size());
    }
}