package build.interpreter;

public enum GradleCommand {
    CLEAN("clean"),
    BUILD("build"),
    TEST("test");

    private final String taskName;

    GradleCommand(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    // Метод для поиска команды по строке
    public static GradleCommand fromString(String command) {
        for (GradleCommand cmd : GradleCommand.values()) {
            if (cmd.taskName.equalsIgnoreCase(command)) {
                return cmd;
            }
        }
        throw new IllegalArgumentException("Unknown command: " + command);
    }
}
