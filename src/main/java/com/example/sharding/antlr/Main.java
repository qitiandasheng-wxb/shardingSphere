package com.example.sharding.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.apache.shardingsphere.sql.parser.mysql.lexer.MySQLLexer;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        String  s="";
        String sql="select id,name  from billinfo where  billno='12321312'";
        MySQLLexer mySQLLexer=new MySQLLexer(CharStreams.fromString(sql));
        Iterator<Token> results= (Iterator<Token>) mySQLLexer.getAllTokens().iterator();
        while (results.hasNext()){
            Token token=results.next();
            String format="Token start:%d,end:%d,TokenType %d,Token: %s";
            String str=String.format(format,token.getStartIndex(),token.getStopIndex(),token.getType(),
                    token.getText());
            System.out.println(str);
        }
     }
}
