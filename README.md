
# Java Data Structures Project 2024

## Project Overview

This repository contains the solutions to the Data Structures Spring Semester Project, including the implementation of a skip list, merging of two sorted lists, a hash table for words, and a mathematical expression evaluator.

### Contents:
- `SkipListDemo.java`: Skip List Implementation
- `MergeSortedLists.java`: Merge Two Sorted Lists
- `WordHashTable.java`: Hash Table for Words
- `EfficiencyComparison.java`: Mathematical Expression Evaluator
- `words.txt`: Input text file for word hash table

## Question 1: Skip List Implementation

**Files:**
- `SkipListDemo.java`

**Description:**
This program builds a Skip List Data Structure, allowing efficient search, insert, and retrieval operations. The skip list is compared with a standard singly linked list for efficiency.

![Question 1](./Questions/Question1.png)

**Usage:**
1. Create a skip list and insert elements.
2. Search for elements in the skip list.
3. Compare the performance with a singly linked list.

```java
// Example usage
SkipList skipList = new SkipList();
skipList.insert(10);
skipList.insert(20);
skipList.insert(30);
boolean found = skipList.search(20);
System.out.println("Found 20: " + found);
```

## Question 2: Merge Two Sorted Lists

**Files:**
- `MergeSortedLists.java`

**Description:**
This program merges two sorted lists into a single sorted list, ensuring no duplicate elements. The resulting list is the union of the input lists.

![Question 2](./Questions/Question2.png)

**Usage:**
1. Create two sorted lists.
2. Merge them into a single sorted list.

```java
// Example usage
List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
List<Integer> list2 = Arrays.asList(2, 3, 6, 8);
List<Integer> mergedList = MergeSortedLists.merge(list1, list2);
System.out.println("Merged List: " + mergedList);
```

## Question 3: Hash Table for Words

**Files:**
- `WordHashTable.java`
- `words.txt`

**Description:**
This program reads words from a text file (`words.txt`) and inserts them into a hash table. It calculates the number of distinct words and identifies the most frequently occurring word.

![Question 3](./Questions/Question3.png)

**Usage:**
1. Read words from the text file.
2. Insert words into the hash table.
3. Find the most frequent word and count distinct words.

```java
// Example usage
WordHashTable wordHashTable = new WordHashTable();
wordHashTable.readFromFile("words.txt");
wordHashTable.printMostFrequentWord();
wordHashTable.printDistinctWordCount();
```

## Question 4: Mathematical Expression Evaluator

**Files:**
- `EfficiencyComparison.java`

**Description:**
This program evaluates mathematical expressions input by the user. It supports infix, postfix, or prefix notation and uses either a tree or stack for the evaluation.

![Question 4](./Questions/Question4.png)

**Usage:**
1. Input a mathematical expression.
2. Evaluate the expression using the preferred method.

```java
// Example usage
String expression = "(25 + 10) * 3 / 4 * 2 / 4 / 90 / 2 / 3";
double result = ExpressionEvaluator.evaluate(expression);
System.out.println("Result: " + result);
```

---
This repository showcases various data structure implementations and their practical applications in solving common problems. Each solution is designed to be efficient and demonstrates the use of different data structures in Java.
