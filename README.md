
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
├── Log.java
└── logs/
    ├── log0.txt
    ├── log1.txt
    └── log2.txt
```

The `logs/` directory and its files are generated automatically.

## Usage

Create a `Log` object with the message you want to save and the program arguments.

Conceptually:

- `write` — the text to store in the log file.
- `args` — command-line arguments used to enable debug output.

### Debug Mode

Run your Java program with the argument:

```bash
java Main --debug
```

When enabled, the logger prints status messages such as:

```text
folder created successfully
File created: log0.txt
```

Without `--debug`, these status messages are suppressed.

## How It Works

1. The constructor receives the message and arguments.
2. The program creates the `logs` directory if necessary.
3. It starts checking filenames from `log0.txt`.
4. If a filename already exists, it tries the next number.
5. When it finds an available filename, it creates the file and writes the message.
6. The program exits after successfully creating the file.

## Error Handling

- Directory creation errors are reported to standard error.
- File creation and writing errors are caught as `IOException`.
- Debug messages are displayed only when debug mode is enabled.

## Limitations

- `System.exit(0)` terminates the entire Java application after a successful log write.
- The constructor performs all logging work, rather than providing a separate logging method.
- The filename search uses an infinite loop, so persistent file errors may cause repeated attempts.
- The `--debug` option is checked only in the first argument.
- The relative path `./logs` depends on the program's current working directory.
- `FileWriter` uses the platform's default character encoding.

## Future Improvements

- Add a dedicated `write()` method.
- Remove `System.exit(0)` so the logger can be reused.
- Use try-with-resources to manage file writers safely.
- Add timestamps to log entries.
- Support configurable log directories and filenames.
- Add log levels such as `INFO`, `WARNING`, and `ERROR`.

## License

Specify a license before distributing or reusing this project.
