package com.fmi;
import java.util.Scanner;


public class email extends account{
    private String contains;
    private boolean unread;
    private boolean read;
    private boolean attachments;
    private String title;
    private String target;
    private String CC;
    private String BCC;
    public  email(){
        Scanner input = new Scanner(System.in);
        System.out.println("Target: ");
        this.target=input.next();
        System.out.println("Title: ");
        this.title=input.next();
        System.out.println("CC: ");
        this.CC=input.next();
        System.out.println("BCC" );
        this.BCC=input.next();
        System.out.println("Contains: ");
        this.contains=input.next();
        System.out.println("Attachements:Y/N ");
        this.attachments=input.nextBoolean();
        this.unread = true;
        this.read= false;
    }
    public void send(email sending){



    }

}
