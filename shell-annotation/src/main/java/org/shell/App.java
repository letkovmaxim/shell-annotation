package org.shell;

import java.io.Console;
import java.util.Scanner;

public class App {
    
    public static void main ( String[] args ) {
        Command[] cmds = (new CommandFinder()).getCommands() ;
        Scanner scanner = new Scanner(System.in) ;
        String input ;

        System.out.print( "\n[ Команды: " ) ;
        String sep = "";
        for ( Command cmd : cmds ) {
            System.out.print(sep + cmd.name());
            sep = ", ";
        }
        System.out.println(" ]");
        System.out.println( "[ Введите команду ]" ) ;

        do {
            // Ввод команды
            System.out.print(" >> ") ;
            input = scanner.nextLine() ;
            input = input.strip().toUpperCase() ;

            // Поиск команды в cmds (теперь может быть пустым)
            for ( int i = 0 ; i < cmds.length ; i++ ) {

                if ( cmds[i].name().equals( input ) ) {
                    cmds[i].exec() ;
                    break ;
                }

                // Конец массива, break не сработал - неизвестная команда
                if ( i == cmds.length - 1 ) {
                    System.out.println( "[ Неизвестная команда ]" ) ;
                }
            }
        } while ( true ) ;
    }
}