import java.util.Random;

class SkipListNode {
    int value;
    SkipListNode right, down;

    public SkipListNode(int value) {
        this.value = value;
        this.right = null;
        this.down = null;
    }
}

class SkipList {
    private SkipListNode head;
    private int maxLevel;
    private Random random;

    public SkipList() {
        head = new SkipListNode(Integer.MIN_VALUE);
        maxLevel = 0;
        random = new Random();
    }

    private SkipListNode find(int value) {
        SkipListNode current = head;
        while (current != null) {
            while (current.right != null && current.right.value < value) {
                current = current.right;
            }
            if (current.down == null) {
                break;
            }
            // Aşağı yerine doğru seviyeden devam ediyoruz
            current = current.down;
        }
        return current;
    }

    public boolean search(int value) {
        SkipListNode node = find(value);
        return node.right != null && node.right.value == value;
    }

    public void insert(int value) {
        SkipListNode current = find(value);
        SkipListNode newNode = new SkipListNode(value);
        newNode.right = current.right;
        current.right = newNode;

        int level = 0;
        while (level < maxLevel && random.nextDouble() < 0.5) {
            // Seviye güncellemesi
            while (current != null && current.down == null) {
                current = current.right;
            }
            if (current == null) break;

            SkipListNode newUpper = new SkipListNode(value);
            newUpper.down = newNode;
            newUpper.right = current.right;
            current.right = newUpper;

            newNode = newUpper;
            current = current.down;
            level++;
        }

        if (level >= maxLevel) {
            maxLevel++;
        }
    }

    public void display() {
        System.out.println("Skip List:");
        SkipListNode currentLevelHead = head;
        while (currentLevelHead != null) {
            SkipListNode currentNode = currentLevelHead;
            while (currentNode != null) {
                System.out.print(currentNode.value + " ");
                currentNode = currentNode.right;
            }
            System.out.println();
            currentLevelHead = currentLevelHead.down;
        }
    }

    // Additional methods for delete, display, etc., can be added here.
}

public class SkipListDemo {
    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.insert(15);
        list.insert(10);
        list.insert(20);

        list.display(); 

        System.out.println("Search 15: " + list.search(15));
        System.out.println("Search 25: " + list.search(25));
    }
}

