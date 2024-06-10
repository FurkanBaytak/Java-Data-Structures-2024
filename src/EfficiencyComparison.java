import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
class SingleLinkedList {
    Node head;

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to search for a node with a given data
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.value == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }


}

public class EfficiencyComparison {
    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        SingleLinkedList linkedList = new SingleLinkedList();

        int numberOfElements = 10000; // Eleman sayısı
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        // Aynı rastgele sayıları içeren bir liste oluştur
        for (int i = 0; i < numberOfElements; i++) {
            int randomNumber = random.nextInt();
            randomNumbers.add(randomNumber);
        }

        // SkipList ve SingleLinkedList'e aynı sayıları ekle
        long startTime = System.currentTimeMillis();
        for (int number : randomNumbers) {
            skipList.insert(number);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("SkipList Insertion Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for (int number : randomNumbers) {
            linkedList.insert(number);
        }
        endTime = System.currentTimeMillis();
        System.out.println("SingleLinkedList Insertion Time: " + (endTime - startTime) + " ms");

        // Her iki yapıda da aynı sayıları ara
        startTime = System.currentTimeMillis();
        for (int number : randomNumbers) {
            skipList.search(number);
        }
        endTime = System.currentTimeMillis();
        System.out.println("SkipList Search Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for (int number : randomNumbers) {
            linkedList.search(number);
        }
        endTime = System.currentTimeMillis();
        System.out.println("SingleLinkedList Search Time: " + (endTime - startTime) + " ms");
    }
}