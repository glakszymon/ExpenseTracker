# ExpenseTracker

CLI expense manager written in Java (25). The app stores expenses in the `src/main/resources/expenses.json` file.

## Getting and running the app

The app can be run in two ways.

### Option A: Download the JAR (recommended — no Maven needed)

Requirement: **Java 25**. Download `ExpenseTracker.jar` from the latest [release](https://github.com/glakszymon/ExpenseTracker/releases), then run:

```bash
java -jar ExpenseTracker.jar --help
```

Example invocation:

```bash
java -jar ExpenseTracker.jar add -a 100 -d "lunch"
java -jar ExpenseTracker.jar list
```

### Option B: Clone the source and build it yourself

Requirements: **Java 25** and **Maven**.

```bash
git clone https://github.com/glakszymon/ExpenseTracker.git
cd ExpenseTracker
mvn clean package
java -jar target/ExpenseTracker.jar --help
```

Alternatively, run without building a JAR:

```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="--help"
```

When passing arguments, wrap a multi-word description in quotes.

---

## Available commands (`--help` output)

```
Menedżer wydatków CLI
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
Commands:
  add      Add a new expense
  list     Display the list of all expenses
  summary  Display the total sum of expenses
  delete   Delete an expense by its ID
  update   Update existing expense
```

Example invocation:

```bash
 add --amount 50 --description "shopping"
 list
```

---

## `add` — add a new expense

```
Usage:  add -a=<amount> -d=<description>
Add a new expense
  -a, --amount=<amount>   Expense amount
  -d, --description=<description>
                          Expense description
```

Both parameters are required.

```bash
 add -a 100 -d "lunch"
 add --amount 25.50 --description "ticket"
```

---

## `list` — display the list of expenses

```
Usage:  list [-m=<monthNumber>]
Display the list of all expenses
  -m, --month=<monthNumber>
         Month number (1-12) to list expenses for
```

The `-m/--month` parameter is optional. Without it, all expenses are shown; with it, only expenses from the given month (1–12) are shown.

```bash
 list
 list -m 3
 list --month 12
```

---

## `summary` — total sum of expenses

```
Usage:  summary [-m=<monthNumber>]
Display the total sum of expenses
  -m, --month=<monthNumber>
         Month number (1-12) to calculate expenses for
```

The `-m/--month` parameter is optional. Without it, the sum of all expenses is calculated; with it, the sum for the given month (1–12).

```bash
 summary
 summary -m 6
 summary --month 1
```

---

## `delete` — delete an expense

```
Usage:  delete --id=<id>
Delete an expense by its ID
      --id=<id>   ID of the expense to delete
```

The `--id` parameter is required.

```bash
 delete --id 5
```

---

## `update` — update an expense

```
Usage:  update [-a=<amount>] [-d=<description>] --id=<id>
Update existing expense
  -a, --amount=<amount>   Expense amount
  -d, --description=<description>
                          Expense description
      --id=<id>           ID of updating expense
```

The `--id` parameter is required; `-a/--amount` and `-d/--description` are optional (you can update the amount, description, or both).

```bash
 update --id 5 -a 120
 update --id 5 -d "new description"
 update --id 5 -a 90 -d "taxi"
```


https://roadmap.sh/projects/expense-tracker
