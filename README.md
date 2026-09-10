# ExpenseTracker

CLI expense manager written in Java (25). The app stores expenses in the `src/main/resources/expenses.json` file.

## Getting the project from GitHub

Requirements: **Java 25** and **Maven**.

```bash
git clone https://github.com/glakszymon/ExpenseTracker.git
cd ExpenseTracker
mvn compile
```

## Running the app

Dependencies and code are compiled automatically by Maven.

**Via Maven (command line):**

```bash
mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="--help"
```

When passing arguments, wrap a multi-word description in quotes.

---

## Available commands (`--help` output)

```
Usage: expenses [-hV] [COMMAND]
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
expenses add --amount 50 --description "shopping"
expenses list
```

---

## `add` — add a new expense

```
Usage: expenses add -a=<amount> -d=<description>
Add a new expense
  -a, --amount=<amount>   Expense amount
  -d, --description=<description>
                          Expense description
```

Both parameters are required.

```bash
expenses add -a 100 -d "lunch"
expenses add --amount 25.50 --description "ticket"
```

---

## `list` — display the list of expenses

```
Usage: expenses list [-m=<monthNumber>]
Display the list of all expenses
  -m, --month=<monthNumber>
         Month number (1-12) to list expenses for
```

The `-m/--month` parameter is optional. Without it, all expenses are shown; with it, only expenses from the given month (1–12) are shown.

```bash
expenses list
expenses list -m 3
expenses list --month 12
```

---

## `summary` — total sum of expenses

```
Usage: expenses summary [-m=<monthNumber>]
Display the total sum of expenses
  -m, --month=<monthNumber>
         Month number (1-12) to calculate expenses for
```

The `-m/--month` parameter is optional. Without it, the sum of all expenses is calculated; with it, the sum for the given month (1–12).

```bash
expenses summary
expenses summary -m 6
expenses summary --month 1
```

---

## `delete` — delete an expense

```
Usage: expenses delete --id=<id>
Delete an expense by its ID
      --id=<id>   ID of the expense to delete
```

The `--id` parameter is required.

```bash
expenses delete --id 5
```

---

## `update` — update an expense

```
Usage: expenses update [-a=<amount>] [-d=<description>] --id=<id>
Update existing expense
  -a, --amount=<amount>   Expense amount
  -d, --description=<description>
                          Expense description
      --id=<id>           ID of updating expense
```

The `--id` parameter is required; `-a/--amount` and `-d/--description` are optional (you can update the amount, description, or both).

```bash
expenses update --id 5 -a 120
expenses update --id 5 -d "new description"
expenses update --id 5 -a 90 -d "taxi"
```