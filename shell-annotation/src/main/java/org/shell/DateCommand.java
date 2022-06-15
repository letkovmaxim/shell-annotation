package org.shell;

import java.time.LocalDateTime ;
import java.time.format.DateTimeFormatter ;

@ShellCommand
public class DateCommand implements Command {
    public String name () {
        return "DATE" ;
    }

    public void exec () {
        LocalDateTime now = LocalDateTime.now() ;
        DateTimeFormatter df = DateTimeFormatter.ofPattern( "d/M/y" ) ;

        System.out.println( "[ Текущая дата: " + now.format( df ) + " ] " ) ;
    }
}