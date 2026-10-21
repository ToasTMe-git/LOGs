
# Java Log

A simple Java logging utility that saves text messages into separate `.txt` files inside a `logs` directory.

## Features

- **Automatic directory creation** — creates the `./logs` directory if it doesn't exist.
- **Unique log files** — creates files named `log0.txt`, `log1.txt`, `log2.txt`, and so on.
- **Preserves existing logs** — skips filenames that already exist instead of overwriting them.
- **Debug mode** — displays status messages when the `--debug` argument is provided.
- **Automatic writing** — writes the specified message into the newly created log file.

## Requirements

- Java JDK installed.
- Permission to create directories and files in the working directory.

## Project Structure

```text
project/
├── Main.java
├── Log.java
└── logs/
    ├── log0.txt
    ├── log1.txt
    └── log2.txt
```

The `logs/` directory and its files are generated automatically.

## Usage

### Main.java

The following example creates a logger and writes a message to a log file.

```java
public class Main {
    public static void main(String[] args) {
        Log myToastyLog = new Log("this is a toasty log", args);
    }
}
```

### Compile and Run

Compile both Java files:

```bash
javac Main.java Log.java
```

Run the program:

```bash
java Main
```

To enable debug output:

```bash
java Main --debug
```

### Example Output

With debug mode enabled:

```text
folder created successfully
File created: log0.txt
```

The generated `logs/log0.txt` file contains:

```text
this is a toasty log
```

If `log0.txt` already exists, the logger tries `log1.txt`, then `log2.txt`, and continues until it finds an available filename.

## How It Works

1. The `Main` class creates a `Log` object.
2. The constructor receives the message and command-line arguments.
3. The program creates the `logs` directory if necessary.
4. It searches for an available numbered log filename.
5. The message is written into the new text file.
6. The program exits after successfully creating the file.

## Debug Mode

The `--debug` argument enables status messages through the `printif()` method.

Without this argument, debug messages are suppressed.
