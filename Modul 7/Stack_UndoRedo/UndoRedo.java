package Stack_UndoRedo;

import java.util.Stack;
import java.util.Scanner;

public class UndoRedo {

    public static void main(String[] args) {
        UndoRedo app = new UndoRedo();
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("Ketikkan teks sebagai command.");
            System.out.println("Ketik U untuk melakukan Undo");
            System.out.println("Ketik R untuk melakukan Redo");
            System.out.println("Ketik X untuk mengakhiri program.");
            System.out.print("Command: ");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("x")) break;
            if (command.equalsIgnoreCase("u")) { app.undo(); }
            else if (command.equalsIgnoreCase("r")) { app.redo(); }
            else app.action(command);
        }

        scanner.close();
        System.out.println("Program selesai.");
    }

    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();

    public void action(String command) {
        System.out.println("Action: " + command);
        undoStack.push(command);
        redoStack.clear(); //Menghapus isi redoStack setiap method action() dipanggil
        UndoRedo.print(undoStack, redoStack);
    }

    public void undo() {
        if (undoStack.isEmpty())
            System.out.println("Nothing to undo.");
        else {
            //Menambahkan head dari undoStack ke dalam redoStack
            redoStack.push(undoStack.peek());
            //Mengeluarkan head dari undoStack
            undoStack.pop();
        }
        UndoRedo.print(undoStack, redoStack);
    }

    public void redo() {
        if (redoStack.isEmpty())
            System.out.println("Nothing to redo.");
        else {
            //Menambahkan head dari redoStack ke dalam undoStack
            undoStack.push(redoStack.peek());
            //Mengeluarkan head dari redoStack
            redoStack.pop();
        }
        UndoRedo.print(undoStack, redoStack);
    }

    public static void print(Stack<String> stackUndo, Stack<String> stackRedo) {
        //Print isi undoStack
        System.out.print("Stack Undo: ");
        for(String s: stackUndo)
            System.out.print(s + " ");
        System.out.println();

        //Print isi redoStack
        System.out.print("Stack Redo: ");
        for(String s: stackRedo)
            System.out.print(s + " ");
        System.out.println();
    }
}
