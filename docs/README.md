# TheGroad User Guide

```
                                      _     _   
                                     (o\~~~/o)  
                                      \_   _/   
                                     (_     _)  
                                       \_._/

```


## Introduction
**The Groad** is a **task management chatbot** designed for users who enjoy **command-line interactions**. Let **The Groad** assist in managing your **to-dos, deadlines and events**, ensuring you stay on track for your goals.

---
## 📖Table of Contents
-[🚀 Getting started](#-getting-started)
- [🛠️ Features](#-features)
  - [1️⃣ Adding Todos](#1-adding-todos-todo)
  - [2️⃣ Adding Deadlines](#2-adding-deadlines-deadline)
  - [3️⃣ Adding Events](#3-adding-events-event)
  - [📋 Listing All Tasks](#4-listing-all-tasks-list)
  - [✔️ Marking Tasks as Done](#5-marking-tasks-as-done-mark)
  - [❌ Unmarking Tasks](#6-unmarking-tasks-as-incomplete-unmark)
  - [🗑️ Deleting Tasks](#7-deleting-tasks-delete)
  - [🔎 Finding Tasks](#8-finding-tasks-using-keyword-find)
  - [🔚 Exiting the Application](#9-exiting-the-application-bye)

---
## 🚀 Getting Started
1. Ensure you have Java `17` or above installed on your computer.
2. Download the latest `.jar` from [here](https://github.com/prathisttam/ip/releases)
3. Copy the file to the folder you want to use as the home folder for your TaskList.
4. Open a command terminal, `cd` into the folder you put the jar file in and run the following:
```
java -jar ip.jar
```

## 🛠️ Features

> [!NOTE]
> Words enclosed within `<>` are placeholders for user input

### ️1️⃣ Adding todos: **`todo`**

**Syntax:** `todo <task description>`

Adds a new todo task to your list.

**Example:**
--------------------------------------------------------------
> todo Homework

```
Got it. I've added this task:
[T][ ] Homework
You have 1 tasks in the list
```
--------------------------------------------------------------

### 2️⃣ Adding deadlines: **`deadline`**

**Syntax** `deadline <task description> /by <date>`

**Example:**
--------------------------------------------------------------
> deadline project proposal /by April 27 2025

```
Got it. I've added this task:
[D][ ] project proposal (by: Apr 27 2025)
Now you have 2 tasks in the list.
```
--------------------------------------------------------------

### 3️⃣ Adding events: **`event`**

**Syntax** `event <task description> /from <start date/time> /to <end date/time>`

**Example:**
--------------------------------------------------------------
> event hangout with friends /from 7pm /to 9pm

```
Got it. I've added this task:
[E][ ] hangout with friends (from: 7pm to: 9pm)
You have 3 tasks in the list.
```
--------------------------------------------------------------

### 4. 📋 Listing all tasks: **`list`**

**Syntax** `list`

**Example:**
--------------------------------------------------------------
> list

```
1. [T][ ] Homework
2. [D][ ] project proposal (by: Apr 27 2025)
3. [E][ ] hangout with friends (from: 7pm to: 9pm)
```
--------------------------------------------------------------

### 5. ✔️ Marking tasks as done: **`mark`**

**Syntax** `mark <task index in list>`

**Example:**
--------------------------------------------------------------
> mark 1

```
Nice! I’ve marked task as done:
[T][X] Homework
```
--------------------------------------------------------------

### 6. ❌ Unmarking tasks as incomplete: **`unmark`**

**Syntax** `unmark <task index in list>`

**Example:**
--------------------------------------------------------------
> unmark 1

```
OK, I've marked this task as not done yet:
[T][ ] Homework
```
--------------------------------------------------------------

### 7. 🗑️ Deleting tasks: **`delete`**

**Syntax** `delete <task index in list>`

**Example:**
--------------------------------------------------------------
> delete 1

```
Noted. I’ve removed this task:
[T][ ] Homework
Now you have 2 tasks in the list
```
--------------------------------------------------------------

### 8. 🔎 Finding tasks using keyword: **`keyword`**

**Syntax** `find <keyword>`

**Example:**
--------------------------------------------------------------
> find hang

```
Here is a list of your tasks:
1. [E][ ] hangout with friends (from: 7pm to: 9pm)
```
--------------------------------------------------------------

### 9. 🔚 Exiting the application: **`bye`**

**Syntax** `bye`

**Example:**
____________________________________________________________
> bye

```
Bye. Hope to see you again soon!
Process finished with exit code 0
```

---