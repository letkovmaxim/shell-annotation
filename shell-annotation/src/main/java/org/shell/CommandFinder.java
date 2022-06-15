package org.shell;

import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CommandFinder {
    private ArrayList<Command> cmds = new ArrayList<>();

    private void findCommands() {
        Reflections ref = new Reflections(CommandFinder.class.getPackage().getName());

        for (Class<?> cls : ref.getTypesAnnotatedWith(ShellCommand.class)) {
            try {
                cmds.add((Command) cls.getDeclaredConstructor().newInstance());
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Command[] getCommands() {
        findCommands();
        return cmds.toArray(new Command[0]);
    }
}
