#  LOGs

A minimal and high-performance logging library for applications.

##  Features

- Simple setup with minimal overhead.
- Configurable log levels (`INFO`, `DEBUG`, `WARN`, `ERROR`).
- Clean, structured console output.

##  Installation

Clone the repository into your project:

```bash
git clone https://github.com/ToasTMe-git/LOGs.git
```

##  Usage in `Main` Class

Here is how to initialize and use the logger in your `Main` class:

```java
public class Main {
    private static final Logger logger = new Logger("Main");

    public static void main(String[] args) {
        logger.info("Application started.");

        try {
            int result = performTask();
            logger.debug("Task result: " + result);
        } catch (Exception e) {
            logger.error("An error occurred during execution", e);
        }

        logger.info("Application shut down cleanly.");
    }

    private static int performTask() {
        logger.warn("Task execution taking longer than expected...");
        return 42;
    }
}
```

## 📄 License

[MIT](LICENSE)
