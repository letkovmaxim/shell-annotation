package org.shell;

@ShellCommand
public class PwdCommand implements Command {
    public String name () {
        return "PWD" ;
    }

    public void exec () {
        System.out.println( "[ Текущий рабочий каталог: \"" + System.getProperty( "user.dir" ) + "\" ] " ) ;
    }
}