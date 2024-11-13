package build.interpreter;

public class InterpreterTask extends DefaultTask {

    @TaskAction
    public void interpret() {
        String commandInput = (String) getProject().findProperty("command");

        if (commandInput != null) {
            try {
                Command command = Command.fromString(commandInput);
                System.out.println("Executing command: " + command.getTaskName());
                getProject().getTasks().getByName(command.getTaskName()).execute();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                printAvailableCommands();
            }
        } else {
            System.out.println("No command provided.");
            printAvailableCommands();
        }
    }

    private void printAvailableCommands() {
        System.out.println("Available commands:");
        for (Command cmd : Command.values()) {
            System.out.println(" - " + cmd.getTaskName());
        }
    }
}
